package com.example.accountengine.shared.transferengine;

import com.example.accountengine.shared.transferengine.exception.ExecuteTransferException;
import com.example.accountengine.shared.transferengine.exception.GetTransactionException;
import com.example.accountengine.shared.transferengine.request.ExecuteRequest;
import com.example.accountengine.shared.transferengine.response.ExecuteResponse;
import com.example.accountengine.shared.transferengine.response.TransactionsResponse;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * The type Transfer engine network.
 */
@AllArgsConstructor
@Log4j2
@Service
public class TransferEngineNetwork {

  private final RestTemplate restTemplate;
  private final TransferEngineConfig transferEngineConfig;

  /**
   * Execute transaction int.
   *
   * @param amount                     the amount
   * @param customerId                 the customer id
   * @param destinationAccount         the destination account
   * @param destinationCurrency        the destination currency
   * @param sourceAccount              the source account
   * @param sourceCurrency             the source currency
   * @param totalDebitedFromSource     the total debited from source
   * @param totalCreditedToDestination the total credited to destination
   * @return the int
   */
  public int executeTransaction(
      BigDecimal amount,
      int customerId,
      String destinationAccount,
      String destinationCurrency,
      String sourceAccount,
      String sourceCurrency,
      BigDecimal totalDebitedFromSource,
      BigDecimal totalCreditedToDestination) {
    /*
    Fill the execute request.
     */
    ExecuteRequest executeRequest = new ExecuteRequest();
    executeRequest.setCustomerId(customerId);
    executeRequest.setDestinationAccount(destinationAccount);
    executeRequest.setDestinationCurrency(destinationCurrency);
    executeRequest.setSourceAccount(sourceAccount);
    executeRequest.setSourceCurrency(sourceCurrency);
    executeRequest.setTotalDebitedFromSource(totalDebitedFromSource);
    executeRequest.setTotalCreditedToDestination(totalCreditedToDestination);
    executeRequest.setAmount(amount);
    /*
    Build transfer engine url
     */
    String transferEngineUrlExecuteUrl =
        "http://" + transferEngineConfig.getHost() + ":" + transferEngineConfig.getPort();
    transferEngineUrlExecuteUrl = transferEngineUrlExecuteUrl + "/" + "transaction";
    ExecuteResponse executeresponse = null;
    try {
      /*
      Send the request to the transaction engine service
      */
      executeresponse = restTemplate
          .postForObject(
              transferEngineUrlExecuteUrl,
              executeRequest,
              ExecuteResponse.class);
    } catch (Exception e) {
      log.warn("Exception while sending the request to the transfer engine", e);
      throw new ExecuteTransferException(customerId);
    }
    return executeresponse.getTransactionId();
  }


  /**
   * Get transactions transactions response.
   *
   * @param customerId the customer id
   * @return the transactions response
   */
  public TransactionsResponse getTransactions (int customerId){
    /*
    Build transfer engine url
     */
    String transferEngineGetTransactions =
        "http://" + transferEngineConfig.getHost() + ":" + transferEngineConfig.getPort();
    transferEngineGetTransactions = transferEngineGetTransactions + "/" + "transaction";
    transferEngineGetTransactions = transferEngineGetTransactions+"?customerId="+customerId;
    TransactionsResponse transactionsResponse = null;
    try {
      /*
      Send the request to the transaction engine service
      */
      transactionsResponse = restTemplate
          .getForObject(
              transferEngineGetTransactions,
              TransactionsResponse.class);
    } catch (Exception e) {
      log.warn("Exception while sending the request to the transfer engine", e);
      throw new GetTransactionException(customerId);
    }

    return transactionsResponse;

  }
}

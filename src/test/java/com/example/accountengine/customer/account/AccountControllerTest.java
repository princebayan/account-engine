package com.example.accountengine.customer.account;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.accountengine.customer.account.request.CreateAccountRequest;
import com.example.accountengine.customer.request.CreateCustomerRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

/**
 * The type Account controller test.
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Account Controller Test")
public class AccountControllerTest {

  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @Autowired
  private MockMvc mvc;

  /**
   * Test create account.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("Test Create Account")
  @Description("Test Create Account "
      + "Acceptance Criteria = 200 Success")
  public void testCreateAccount() throws Exception {

    /*
    Fill the execute request.
     */
    CreateAccountRequest createAccountRequest = new CreateAccountRequest();
    createAccountRequest.setInitialAmount(new BigDecimal(10));

    long executionTime = System.currentTimeMillis();

    MvcResult createAccountResponse = mvc.perform(post("/customer/1/account")
        .contentType(MediaType.APPLICATION_JSON)
        .content(createAccountRequest.toJson()))
        .andExpect(status().isOk())
        .andReturn();

    executionTime = System.currentTimeMillis() - executionTime;

    /*
    Extract response content & Assure != null
     */
    String createAccountContent = createAccountResponse.getResponse().getContentAsString();
    JsonElement createAccountOutput = JsonParser.parseString(createAccountContent);

    Allure.addAttachment("Create Account Response:", gson.toJson(createAccountOutput));
    Allure.addAttachment("Execution Time in ms", String.valueOf(executionTime));
  }


  /**
   * Test create account initial zero.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("Test Create Account initial Zero")
  @Description("Test Create Account initial Zero"
      + "Acceptance Criteria = 200 Success")
  public void testCreateAccountInitialZero() throws Exception {

    /*
    Fill the execute request.
     */
    CreateAccountRequest createAccountRequest = new CreateAccountRequest();
    createAccountRequest.setInitialAmount(new BigDecimal(0));

    long executionTime = System.currentTimeMillis();

    MvcResult createAccountResponse = mvc.perform(post("/customer/1/account")
        .contentType(MediaType.APPLICATION_JSON)
        .content(createAccountRequest.toJson()))
        .andExpect(status().isOk())
        .andReturn();

    executionTime = System.currentTimeMillis() - executionTime;

    /*
    Extract response content & Assure != null
     */
    String createAccountContent = createAccountResponse.getResponse().getContentAsString();
    JsonElement createAccountOutput = JsonParser.parseString(createAccountContent);

    Allure.addAttachment("Create Account Response:", gson.toJson(createAccountOutput));
    Allure.addAttachment("Execution Time in ms", String.valueOf(executionTime));
  }


  /**
   * Test create account customer not found.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("Test Create Account Customer Not Found")
  @Description("Test Create Account Customer Not Found"
      + "Acceptance Criteria = 422 Unprocessable Entity")
  public void testCreateAccountCustomerNotFound() throws Exception {

    /*
    Fill the execute request.
     */
    CreateAccountRequest createAccountRequest = new CreateAccountRequest();
    createAccountRequest.setInitialAmount(new BigDecimal(0));

    long executionTime = System.currentTimeMillis();

    MvcResult createAccountResponse = mvc.perform(post("/customer/11/account")
        .contentType(MediaType.APPLICATION_JSON)
        .content(createAccountRequest.toJson()))
        .andExpect(status().isUnprocessableEntity())
        .andReturn();

    executionTime = System.currentTimeMillis() - executionTime;

    /*
    Extract response content & Assure != null
     */
    String createAccountContent = createAccountResponse.getResponse().getContentAsString();
    JsonElement createAccountOutput = JsonParser.parseString(createAccountContent);

    Allure.addAttachment("Create Account Response:", gson.toJson(createAccountOutput));
    Allure.addAttachment("Execution Time in ms", String.valueOf(executionTime));
  }

}

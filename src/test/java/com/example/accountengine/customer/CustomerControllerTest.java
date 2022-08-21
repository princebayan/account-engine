package com.example.accountengine.customer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.accountengine.customer.request.CreateCustomerRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Customer Controller Test")
public class CustomerControllerTest {

  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @Autowired
  private MockMvc mvc;

  @Test
  @DisplayName("Test Create Customer")
  @Description("Test Create Customer "
      + "Acceptance Criteria = 200 Success")
  public void testCreateCustomer() throws Exception {

    /*
    Fill the execute request.
     */
    CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
    createCustomerRequest.setName("John");
    createCustomerRequest.setSurname("Dou");

    long executionTime = System.currentTimeMillis();

    MvcResult createCustomerResponse = mvc.perform(post("/customer")
        .contentType(MediaType.APPLICATION_JSON)
        .content(createCustomerRequest.toJson()))
        .andExpect(status().isOk())
        .andReturn();

    executionTime = System.currentTimeMillis() - executionTime;

    /*
    Extract response content & Assure != null
     */
    String createCustomerContent = createCustomerResponse.getResponse().getContentAsString();
    JsonElement createCustomerOutput = JsonParser.parseString(createCustomerContent);

    Allure.addAttachment("Create Customer Response:", gson.toJson(createCustomerOutput));
    Allure.addAttachment("Execution Time in ms", String.valueOf(executionTime));
  }

  @Test
  @DisplayName("Test Create Customer name is null")
  @Description("Test Create Customer name is null "
      + "Acceptance Criteria = 400 Success")
  public void testCreateCustomerNameNull() throws Exception {

    /*
    Fill the execute request.
     */
    CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
    createCustomerRequest.setSurname("Dou");

    long executionTime = System.currentTimeMillis();

    MvcResult createCustomerResponse = mvc.perform(post("/customer")
        .contentType(MediaType.APPLICATION_JSON)
        .content(createCustomerRequest.toJson()))
        .andExpect(status().isBadRequest())
        .andReturn();

    executionTime = System.currentTimeMillis() - executionTime;

    /*
    Extract response content & Assure != null
     */
    String createCustomerContent = createCustomerResponse.getResponse().getContentAsString();
    JsonElement createCustomerOutput = JsonParser.parseString(createCustomerContent);

    Allure.addAttachment("Create Customer Response:", gson.toJson(createCustomerOutput));
    Allure.addAttachment("Execution Time in ms", String.valueOf(executionTime));
  }

  @Test
  @DisplayName("Test Create Customer surname is null")
  @Description("Test Create Customer surname is null "
      + "Acceptance Criteria = 400 Success")
  public void testCreateCustomerSurnameNull() throws Exception {

    /*
    Fill the execute request.
     */
    CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest();
    createCustomerRequest.setName("John");

    long executionTime = System.currentTimeMillis();

    MvcResult createCustomerResponse = mvc.perform(post("/customer")
        .contentType(MediaType.APPLICATION_JSON)
        .content(createCustomerRequest.toJson()))
        .andExpect(status().isBadRequest())
        .andReturn();

    executionTime = System.currentTimeMillis() - executionTime;

    /*
    Extract response content & Assure != null
     */
    String createCustomerContent = createCustomerResponse.getResponse().getContentAsString();
    JsonElement createCustomerOutput = JsonParser.parseString(createCustomerContent);

    Allure.addAttachment("Create Customer Response:", gson.toJson(createCustomerOutput));
    Allure.addAttachment("Execution Time in ms", String.valueOf(executionTime));
  }

  @Test
  @DisplayName("Test Get Customer")
  @Description("Test Get Customer "
      + "Acceptance Criteria = 200 Success")
  public void testGetCustomer() throws Exception {


    long executionTime = System.currentTimeMillis();

    MvcResult createCustomerResponse = mvc.perform(get("/customer/1"))
        .andExpect(status().isOk())
        .andReturn();

    executionTime = System.currentTimeMillis() - executionTime;

    /*
    Extract response content & Assure != null
     */
    String createCustomerContent = createCustomerResponse.getResponse().getContentAsString();
    JsonElement createCustomerOutput = JsonParser.parseString(createCustomerContent);

    Allure.addAttachment("Get Customer Response:", gson.toJson(createCustomerOutput));
    Allure.addAttachment("Execution Time in ms", String.valueOf(executionTime));
  }



  @Test
  @DisplayName("Test Get Customer not found")
  @Description("Test Get Customer not found"
      + "Acceptance Criteria = 422 Unprocessable Entity")
  public void testGetCustomerNotFound() throws Exception {


    long executionTime = System.currentTimeMillis();

    MvcResult createCustomerResponse = mvc.perform(get("/customer/11"))
        .andExpect(status().isUnprocessableEntity())
        .andReturn();

    executionTime = System.currentTimeMillis() - executionTime;

    /*
    Extract response content & Assure != null
     */
    String createCustomerContent = createCustomerResponse.getResponse().getContentAsString();
    JsonElement createCustomerOutput = JsonParser.parseString(createCustomerContent);

    Allure.addAttachment("Get Customer Response:", gson.toJson(createCustomerOutput));
    Allure.addAttachment("Execution Time in ms", String.valueOf(executionTime));
  }



}

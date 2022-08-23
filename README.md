# Account-Engine
[![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](http://projects.spring.io/spring-boot/)

[![Build Status](https://github.com/princebayan/account-engine/actions/workflows/account-engine-pipeline.yaml/badge.svg)](https://github.com/princebayan/account-engine/actions)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Naereen/StrapDown.js/graphs/commit-activity)

Account engine is a spring boot java application that expose APIs to manage customer accounts and transactions


Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.


## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Gradle 7.5](https://services.gradle.org/distributions/gradle-7.5-bin.zip)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.accountengine.Application` class from your IDE.

<h3>It is preferred to run the application with a spring profile property:</h3>

<h4>JVM System Parameter</h4>

```shell
-Dspring.profiles.active=dev
```
<h4>Environment Variable</h4>

```shell
export spring_profiles_active=dev
```
<h3>Swagger Documentation</h3>
once the application is up you can access the swagger documentation page from the
below URL:
<br>

[Localhost Swagger](http://localhost:8082/swagger-ui.html)
<br>
<br>
Also, you can check the swagger documentation from the Cloud Server instance
<br>

[Cloud Swagger](http://137.184.12.5:8081/swagger-ui.html)

## Testing the application

Below is a sample request and response to test the available APIs

- ### Add Customer
  Method : POST

  URI: <b>/customer</b>

  Request:

    ```json
    {
      "name": "Amir",
      "surname": "Bayan"
    }
    ```
  Expected Success Response:

    ```json
    {
      "id": 1
    }
    ```

- ### Get Customer
  Method : GET

  URI: <b>/customer/{id}</b>

  Expected Success Response:

    ```json
    {
      "id": 1,
      "name": "Amir",
      "surname": "Bayan",
      "customerNumber": "1338508",
      "accounts": [
        {
          "accountNumber": "1338508934840",
          "currency": "USD",
          "balance": 50
        }
      ],
      "transactions": [
        {
          "createdDate": "2022-08-22T20:24:57.756+00:00",
          "updatedDate": "2022-08-22T20:24:57.756+00:00",
          "id": 1,
          "amount": 50,
          "account": "1338508934840"
        }
      ]
    }
    ```
- ### Create Account
  Method : GET

  URI: <b>/customer/{id}/account</b>
  Request:

    ```json
    {
      "initialAmount": 50
    }
    ```
  Expected Success Response:

    ```json
    {
      "accountNumber": "1338508934840",
      "balance": 50
    }
    ```


## Allure Report
This project use allure to visualize the Junit results, you can check the result
from the Github Action Pipeline by navigating to the stage `Post the link to the report`
or directly from Github pages feature through the below link:

[Github Pages](https://princebayan.github.io/account-engine/)


## Technologies Used

- [Spring Boot Framework](http://projects.spring.io/spring-boot/)
- [Spring Boot H2 Database](https://www.baeldung.com/spring-boot-h2-database)
- [Project Lombok](https://projectlombok.org/)
- [Allure Report](https://qameta.io/allure-report/)
- [Rest Exception Handling](https://www.baeldung.com/exception-handling-for-rest-with-spring)


## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/princebayan/account-engine/blob/develop/LICENSE.txt) file.

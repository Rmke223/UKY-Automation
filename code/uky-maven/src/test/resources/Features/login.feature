@SmokeScenario
Feature: POC to test login functionality
  @SmokeTest
  Scenario: Checks that login is successful with correct login credentials
    Given user is on login page
    When title of login page is free CRM
    Then user enters username and password
    And clicks on the login button
    Then the user is navigated to the home page



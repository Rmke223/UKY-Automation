@SmokeScenario
Feature: POC to test login functionality
  @SmokeTest
  Scenario: Checks that login is successful with correct login credentials
    Given user is on login page
    When user enters username and password
    And clicks on the login button
    Then the user is navigated to the home page

  @SmokeTest
  Scenario Outline: Checks that login is successful with correct login credentials
    Given user is on login page
    When user enters <username> and <password>
    And clicks on the login button
    Then the user is navigated to the home page
    Examples:
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |


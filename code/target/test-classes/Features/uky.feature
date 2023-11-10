@myuky
Feature: feature to test login functionality on uky
  Scenario: Validate uky login is working
    Given browser is open
    And user is on uky page
    And user clicks on the "login-button" button
    And user enters username in "userNameInput" field
    And user enters password in "passwordInput" field
    And user clicks on the "submitButton" button
    Then check that "auth-view-wrapper" is present

Feature: feature to test login functionality on DB connection
  Scenario: Validate DB connection
    Given I connect to the "restaurants" DB
		Then I check that an object was pulled from the db
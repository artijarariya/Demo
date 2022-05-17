Feature: Check login functionality
@hooks1
  Scenario: 
    Given user is on login page
    When user enters valid credentials
    And click on login button
    Then user is navigated to home page
@hooks2
    Scenario: 
    Given user is on login page
    When user enters valid credentials
    And click on login button
    Then user is navigated to home page
    
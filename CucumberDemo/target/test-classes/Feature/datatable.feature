Feature: Check login functionality

  Scenario: Succesful login with valid credentials
    Given user is on home page
    When user navigate to login page
    And user enters credentials to login
      | admin | admin123 |
    Then meassage displayed login succesfully

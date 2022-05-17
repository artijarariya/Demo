#Feature File

@SmokeScenario
Feature: feature to test login functionality
@SmokeTest
  Scenario: check login is successful with valid credentials
    Given user is on login page
    When  enters username and password
    And clicks on login button
    Then user is navigated home page

 
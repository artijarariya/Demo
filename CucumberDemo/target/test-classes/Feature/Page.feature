Feature: Test login functionality

  Scenario Outline: check login is successful with valid credentials
    Given browser is opening
    And user on login page
    When user enters <username> and<password>
    Then user click login
    And user is in home Page
    Then user is in assign leave page
    

    Examples: 
      | username | password |
      | Admin    | admin123 |

      
      
      
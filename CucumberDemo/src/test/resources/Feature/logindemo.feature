Feature: Test login functionality
@Smoke
  Scenario Outline: check login is successful with valid credentials
    Given browser is opening
    And user on login page
    When user enters <username> and<password>
    Then user click login
    

    Examples: 
      | username | password |
      | Admin    | admin123 |

      
      
      
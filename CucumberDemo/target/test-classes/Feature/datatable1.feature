Feature: Registration functionality

  Scenario: Email creation
    Given user navigate to the login page
    When user click register
    And user enter self details as
      | First   | lastName | Email         | Gender |
      | niraj   | gupta    | abc@gmail.com | Male   |
      | prakash | jain     | prakash2gmail | Male   |
    And click submit button
    Then meassage displayed successfully creation of email

  @map
  Scenario: Registration
    Given user navigate to the login page
    When user click register
    And user enter self details as Map
      | username   | password   |
      | arti | admin123     |
      | Pakhi| aditi123  |
      | ritu  | abc@123 |
    And click submit button
    Then meassage displayed successfully creation of email

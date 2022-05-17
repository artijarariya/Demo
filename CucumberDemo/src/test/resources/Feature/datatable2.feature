Feature: User Registration

  Scenario: User Registration with different dataset
    Given user is on registration page
    When user enters following user details
      | arti  | jarariya    | arti@gmail.com | 2345354 | Vidisha |
      | asha   | negi    | a@gmail.com | 235464 | Dehradun|
      | shilpa | solanki | s@gmail.com | 36547 | Mumbai    |
    And click on OK button
    Then registration is successful

  Scenario: User Registration with different dataset using columns
    Given user is on registration page
    When user enters following user details with collumns
      | firstname | lastname | email       | phone | location |
      | arti      | jarariya     | a@gmail.com | 999 | vidisha |
      | aditi      | jarariya     | adi@gmail.com | 46657 | ahmadabad |
      | deepti    | jain  | de@gmail.com | 23534546 | Patna     |
    And click on OK button
    Then registration is successful

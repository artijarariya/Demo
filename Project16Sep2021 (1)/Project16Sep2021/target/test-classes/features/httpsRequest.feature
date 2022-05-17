Feature: test http request

  Scenario Outline: test GET request for single user
    Given retrive data from "<sheetName>" and <rowNumber> for GET
    When user call baseUrl with endpoint and userId for GET
    Then verify statusCode and userId with excel file for GET
    And print the response body for GET

    Examples: 
      | sheetName               | rowNumber |
      | GET_single_user_request |         0 |
      | GET_single_user_request |         1 |
      | GET_single_user_request |         2 |
      | GET_single_user_request |         3 |
      | GET_single_user_request |         4 |

  Scenario Outline: test GET request for users list
    Given retrive data from "<sheetName>" and <rowNumber> for GET_list
    When user call baseUrl with endpoint and userId for GET_list
    Then verify statusCode and pageId with excel file for GET_list
    And print the response body for GET_list

    Examples: 
      | sheetName      | rowNumber |
      | GET_list_users |         0 |
      | GET_list_users |         1 |
      | GET_list_users |         2 |

  Scenario Outline: test POST request
    Given retrive data from "<sheetName>" and <rowNumber> for POST
    When user call baseUrl with endpoint and userId for POST
    Then verify statusCode with excel file for POST
    And print the response body for POST

    Examples: 
      | sheetName    | rowNumber |
      | POST_request |         0 |
      | POST_request |         1 |
      | POST_request |         2 |
      | POST_request |         3 |
      | POST_request |         4 |

  Scenario Outline: test PUT request
    Given retrive data from "<sheetName>" and <rowNumber> for PUT
    When user call baseUrl with endpoint and userId for PUT
    Then verify statusCode with excel file for PUT
    And print the response body for PUT

    Examples: 
      | sheetName   | rowNumber |
      | PUT_request |         0 |

  Scenario Outline: test PATCH request
    Given retrive data from "<sheetName>" and <rowNumber> for PATCH
    When user call baseUrl with endpoint and userId for PATCH
    Then verify statusCode with excel file for PATCH
    And print the response body for PATCH

    Examples: 
      | sheetName     | rowNumber |
      | PATCH_request |         0 |

  Scenario Outline: test DELETE request
    Given retrive data from "<sheetName>" and <rowNumber> for DELETE
    When user call baseUrl with endpoint and userId for DELETE
    Then verify statusCode with excel file for DELETE
    And print the response body for DELETE

    Examples: 
      | sheetName      | rowNumber |
      | DELETE_request |         0 |

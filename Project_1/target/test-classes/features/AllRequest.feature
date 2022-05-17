Feature: test http request

  Scenario Outline: test GET request for single user
    Given retrive data from "<sheet_name>" and <row_number> for GET
    When user call baseUrl with endpoint and userId for GET
    Then verify statusCode and userId with excel file for GET
    And print the response body for GET

    Examples: 
      | sheet_name    | row_number |
      | GETSingleUser |          0 |
      | GETSingleUser |          1 |
      | GETSingleUser |          2 |
      | GETSingleUser |          3 |
      | GETSingleUser |          4 |

  Scenario Outline: test GET request for users list
    Given retrive data from "<sheet_name>" and <row_number> for GET_list
    When user call baseUrl with endpoint and userId for GET_list
    Then verify statusCode and pageId with excel file for GET_list
    And print the response body for GET_list

    Examples: 
      | sheet_name  | row_number |
      | GET |          0 |
      | GET |          1 |
      | GET |          2 |

  Scenario Outline: test POST request
    Given retrive data from "<sheet_name>" and <row_number> for POST
    When user call baseUrl with endpoint and userId for POST
    Then verify statusCode with excel file for POST
    And print the response body for POST

    Examples: 
      | sheet_name | row_number |
      | POST     |          0 |
      | POST       |          1 |
      | POST       |          2 |
      | POST       |          3 |
      | POST       |          4 |

  Scenario Outline: test PUT request
    Given retrive data from "<sheet_name>" and <row_number> for PUT
    When user call baseUrl with endpoint and userId for PUT
    Then verify statusCode with excel file for PUT
    And print the response body for PUT

    Examples: 
      | sheet_name | row_number |
      | PUT        |          0 |

  Scenario Outline: test PATCH request
    Given retrive data from "<sheet_name>" and <row_number> for PATCH
    When user call baseUrl with endpoint and userId for PATCH
    Then verify statusCode with excel file for PATCH
    And print the response body for PATCH

    Examples: 
      | sheet_name | row_number |
      | PATCH      |          0 |

  Scenario Outline: test DELETE request
    Given retrive data from "<sheet_name>" and <row_number> for DELETE
    When user call baseUrl with endpoint and userId for DELETE
    Then verify statusCode with excel file for DELETE
    And print the response body for DELETE

    Examples: 
      | sheet_name | row_number |
      | DELETE    |          0 |

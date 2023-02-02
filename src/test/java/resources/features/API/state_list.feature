Feature: Derive API State List testing

  Scenario: get all the state names and verify
    Given the state_list
    When the user sends the request
    Then verify that status code 200
    And  verify Header in Requests to be Content Type JSON
    And  verify "text" starts from capital letter
    Then verify size of the text is not exceeding 20 chars
    And  verify "value" is 2-letter country code in Capital format
    And  verify the value size does not exceed 2 chars
    Then verify id is 1 for 38 state objects


Feature: Derive API Price Proposal testing

  Scenario: get all the state names and verify
    Given the state_list
    When the user sends the request
    Then verify that status code 200
    And  verify Header in Requests to be Content Type JSON
    And  verify "ask_price" is 50.46
    Then verify "date_expiry" is 1675304748
    And  verify "date_start" is 1675304688
    And  verify "display_value" is 50.46
    Then verify "id" is "0ecb003b-00b7-f723-67be-21d7d3357fe6"
    And verify "product_type" is "basic"
    And verify "longcode" is "Win payout if Volatility 100 Index is strictly higher than entry spot plus 0.10 at 1 minute after contract start time."
    And verify "payout" is 100
    And verify "spot" is 4112.6
    Then verify "spot_time" is 1675304688
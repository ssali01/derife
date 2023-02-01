
Feature: Title Verification MarketsOptions
  User story: As a user I am on derivefe page,
  I should be able to see the Markets on that page

  Background:
    Given User is on "https://derivfe.github.io/qa-test/" page

  Scenario: Markets title verification
    When User sees the Markets option
    And User clicks on "Markets" option
    Then User sees title is as expected.

  Scenario: Terms button verification
    When User clicks on Terms button
    Then User sees Terms page


Feature: Title Verification BinaryOptions
  User story: As a user I am on derivefe page,
  I should be able to see the title of the page

  Background:
    Given User is on "https://derivfe.github.io/qa-test/" page

  Scenario: BinaryOptions title verification
    When User sees title is as expected.
    Then User sees "Binary Options" is selected
    And Terms button verification
    When User clicks on Terms button
    Then User sees Terms page
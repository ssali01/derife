@wip
Feature: Title Verification Contact Us
  User story: As a user I am on Contact Us page,
  I should be able to send the message in correct format

  Background:
    Given User is on "https://derivfe.github.io/qa-test/contact" page

  Scenario: Contact Us title verification
    When User clicks on "Contact Us" option
    Then User sees title is as expected.

  Scenario: User sends the message in correct format
    When User fills out the Name line,
    And User fills out the Phone Number line
    Then "Name" should start from Capital letter
    Then "Phone Number" should be only in digits format
    Then Phone Number should be in the following format "xxxx-xxx-xxxx"


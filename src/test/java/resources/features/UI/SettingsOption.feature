@wip
Feature: Title Verification Settings Option
  User story: As a user I am on Settings page,
  I should be able to see Profile settings

  Background:
    Given User is on "https://derivfe.github.io/qa-test/" page

  Scenario: User is on the Profile settings
    When fill out the First and Last names lines
    And fill out the Phone Number
    Then it should be in the following format "xxxx-xxx-xxxx"
    Then "First name" should start from Capital letter
    Then "Last name" should start from Capital letter

  Scenario: Terms button verification
    When User clicks on Terms button
    Then User sees Terms page

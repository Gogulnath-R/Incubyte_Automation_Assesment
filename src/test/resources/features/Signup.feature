#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Sign up for a new account on Magento

  Scenario: User successfully signs up with valid details
    Given I am on the Magento sign-up page
    When I enter valid details
    And I click the Create Account button
    Then I should be redirected to the account dashboard

  Scenario: User tries to sign up with an existing email
    Given I am on the Magento sign-up page
    When I enter an already registered email
    And I click the Create Account button
    Then I should see an error message

  Scenario: User enters an invalid password
    Given I am on the Magento sign-up page
    When I enter a weak password
    And I click the Create Account button
    Then I should see a password validation error

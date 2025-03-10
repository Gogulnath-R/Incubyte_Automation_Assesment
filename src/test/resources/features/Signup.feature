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

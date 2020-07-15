Feature: To test the functionality of My Account Page

  @regression
  Scenario: As a user, I should validate my account page
    Given I am on the Home page
    And I navigate to Sign in page
    When I click on Sign in button with credential
    Then I should see My Account page

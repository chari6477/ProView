@Core
Feature: LMS personalization

  Scenario: Core_LMSPersonalization
    When I launch ProView
    And I check in the checkout code
    And I sign in using a checkout code
    And I open the account menu
    And I open the personalization dialog from the account menu
    Then I verify that the personalization dialog is displayed
    When I personalize
    Then I verify that the reg key was generated
    When I click the Return to ProView button
    Then I verify that I am on the sign in page
    And I close the app



@Core4
Feature: IPP authentication

	Scenario: Core_IPPAuthentication
		When I launch ProView via IPP
		And I open the account menu
		And I open the personalization dialog from the account menu
		Then I verify that the personalization dialog is displayed
		When I personalize
		Then I verify that the reg key was generated
		When I click the Return to ProView button
		Then I verify that I am on the sign in page
		Then I close the app
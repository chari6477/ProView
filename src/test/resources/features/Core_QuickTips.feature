@Core_Regression @Sanity
Feature: Quick tips

	Scenario: Core_QuickTips
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		Then I verify that the content in the quick tip contains "To add a Note"
		When I click the quick tip refresh button
		Then I verify that the content in the quick tip contains "Add a bookmark"
		When I open the account menu
		And I sign out from the account menu
		Then I close the app
		
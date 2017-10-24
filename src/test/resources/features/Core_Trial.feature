@Core
Feature: Trial

	Scenario: Core_Trial
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedTrial1"
		#Then I verify that the sample title toast is displayed
		And I verify that the content contains "You are reading a preview sample of this title"
		When I open the options menu
		And I sign out
		Then I close the app
		
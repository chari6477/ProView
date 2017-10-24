@Core
Feature: Freemium with non-trial version of a title

	Scenario: Core_FreemiumNonTrial
		When I launch ProView via freemium non-trial
		Then I verify that the content contains "Income Tax Act"
		When I open the options menu
		And I sign out
		Then I close the app

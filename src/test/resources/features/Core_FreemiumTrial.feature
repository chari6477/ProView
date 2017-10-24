@Core
Feature: Freemium with trial version of a title

	Scenario: Core_FreemiumTrial
		When I launch ProView via freemium trial
		Then I verify that the content contains "preview sample"
		When I open the options menu
		And I sign out
		Then I close the app

@Core
Feature: Periodical group

	Scenario: Core_PeriodicalAndGroup
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the group panel for "Automated Periodical"
		Then I verify that the title "AutomatedPeriodicalIssue2" is displayed
		When I open the title "AutomatedPeriodicalIssue2" from the group menu
		Then I verify that the content contains "Q3 results"
		When I open the options menu
		And I sign out
		Then I close the app
		
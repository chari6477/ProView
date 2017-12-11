@Core
Feature: IP authentication

	Scenario: Core_IPAuthentication
		When I launch ProView via IP
		Then I verify that I am in the library
		When I open the title "AutomatedPeriodicalIssue3"
		Then I verify that the content contains "The Hub Daily"
		When I open the options menu
		And I click on "Sair" option of Options Menu
		Then I close the app
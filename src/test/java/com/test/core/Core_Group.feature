@Core
Feature: Group

	Scenario: Core_Group
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the group panel for "Automated Group"
		Then I verify that the title "AutomatedGroupBook2" is displayed
		When I open the title "AutomatedGroupBook2" from the group menu
		Then I verify that the content contains "Link testing"
		When I open the options menu
		And I sign out
		Then I close the app
		
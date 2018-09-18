@Core_Regression1
Feature: Group

	Scenario: Core_Group
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the group panel for "Automated Group"
		When I open the title "AutomatedGroupBook2" from the groupS menu
		Then I verify that the content contains "Link testing"
		When I open the options menu
		And I sign out
		Then I close the app
		
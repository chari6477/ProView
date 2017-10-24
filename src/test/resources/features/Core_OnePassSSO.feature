@Core
Feature: OnePass SSO

	Scenario: Core_OnePassSSO
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedLinking"
		And I jump to page "9"
		Then I verify that the content contains "OnePass SSO Linking"
		When I click the link "WestlawNext link"
		#Then I verify that I am signed in to WestlawNext
		When I click the Continue button
		Then I verify that content contains "Procedure after removal generally"
		When I sign out of WestlawNext
		And I go back to ProView
		And I open the options menu
		And I sign out
		Then I close the app
		
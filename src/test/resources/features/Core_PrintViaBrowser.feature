@Core
Feature: Print Via Browser

Scenario: Core_PrintViaBrowser
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedNewberg"
		And I generate a print preview
		Then I verify that the print preview displays the same content that was displayed in the current view
		When I open the options menu
		And I sign out
		Then I close the app
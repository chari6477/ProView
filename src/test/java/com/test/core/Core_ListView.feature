@Core
Feature: List view

	Scenario: Core_ListView
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I switch to "list" view
		Then I verify that the titles are displayed in "list" view
		When I switch to "card" view
		Then I verify that the titles are displayed in "card" view
		When I open the account menu
		And I sign out from the account menu
		Then I close the app
		
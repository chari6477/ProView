@Core
Feature: Library filter

	Scenario: Core_LibrarySearch
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the library search and filter panel
		And I select "Eagan" from the "Jurisdiction" dropdown
		Then I verify that the tag labeled "Eagan" is displayed
		And I verify that the title "AutomatedNewberg" is displayed
		When I clear the "Eagan" label
		Then I verify that the title "AutomatedAZIndex" is displayed
		When I open the account menu
		And I sign out from the account menu
		Then I close the app
		
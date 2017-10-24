Feature: Library pagination

	Scenario: Core_LibraryPagination
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		Then I verify that the "Next Page" button is displayed
		When I click the "Next Page" button
		Then I verify that the title "AutomatedPITA" is displayed in current page
		When I click the "Previous Page" button
		Then I verify that the title "KthCopyNotesCopy" is displayed in current page
		When I open the account menu
		And I sign out from the account menu
		Then I close the app
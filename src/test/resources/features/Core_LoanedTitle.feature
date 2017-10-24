Feature: Loaned title

	Scenario: Core_LoanedTitle
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I enter the text "Automated Compass" in the title or author filter box
		Then I verify that the due date is displayed
		When I open the title "AutomatedCompassLoan"
		Then I verify that the content contains "Lorem ipsum"
		When I open the options menu
		And I sign out
		Then I close the app
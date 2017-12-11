Feature: Loaned title

	Scenario: Core_LoanedTitle
		When I launch ProView
		#And I sign in
		And I sign in using a checkout code
		Then I verify that I am in the library
		When I enter the text "Automated A-Z Index" in the title or author filter box
		Then I verify that the due date is displayed
		When I open the loaned title "AutomatedAZIndex"
		Then I verify that the content contains "Theory, Structure, and Constitutionality of Class Actions"
		When I open the options menu
		And I sign out
		Then I close the app
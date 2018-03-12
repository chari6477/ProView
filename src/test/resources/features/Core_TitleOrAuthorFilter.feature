@Core_Regression
Feature: Title or author filter

	Scenario: Core_eReference
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I enter the text "Automated Compass" in the title or author filter box
		Then I verify that the title "AutomatedCompass" is displayed
		When I clear the title or author filter box
		Then I verify that the title "AutomatedAZIndex" is displayed
		When I open the account menu
		And I sign out from the account menu
		Then I close the app
		
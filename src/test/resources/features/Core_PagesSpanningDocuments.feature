@Core_Regression1
Feature: Pages spanning documents

	Scenario: Core_PagesSpanningDocuments
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPSD1"
		And I open the options menu
		And I click on "Layout" option of Options Menu
		And I select the "Pages" layout option
		And I close the options menu
		When I add a highlights in the color "purple" by selecting the text "document"
		And I open the options menu
		And I click on "Layout" option of Options Menu
		And I select the "Scroll" layout option
		And I open the annotations menu
		Then I verify that the highlight is displayed in the annotations menu
		When I click the highlight in the annotations menu
		Then I verify that the content contains "document"
		When I delete the highlight from the annotations menu
		Then I verify that the highlight is not displayed in the annotations menu
		When I open the options menu
		And I sign out
		Then I close the app
		
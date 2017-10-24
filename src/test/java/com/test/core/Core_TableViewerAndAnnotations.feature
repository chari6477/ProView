@Core
Feature: Table viewer and annotations

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedTableViewer"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_TableViewerAndAnnotations_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the table viewer
		When I add a note in the color "purple" by selecting the text "Header 1" with the description "Core Regression"
		Then I close the "table" viewer
		And I open the annotations menu
		Then I verify that the note is displayed in the annotations menu
		When I click the note in the annotations menu
		When I delete the note from the annotations menu
		Then I verify that the note is not displayed in the annotations menu
		And I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_TableViewerAndAnnotations_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I open the table viewer
		When I add a note in the color "purple" by selecting the text "row 1, column 1" with the description "Core Regression"
		Then I close the "table" viewer
		And I open the annotations menu
		Then I verify that the note is displayed in the annotations menu
		When I click the note in the annotations menu
		When I delete the note from the annotations menu
		Then I verify that the note is not displayed in the annotations menu
		And I open the options menu
		And I sign out
		Then I close the app
		
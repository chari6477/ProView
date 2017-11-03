@Core
Feature: Note

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPITA"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_Note_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I add a note in the color "blue" by selecting the text "Editor and Author of Notes" with the description "Core Regression"
		And I jump to page "21"
		And I open the annotations menu
		Then I verify that the note is displayed in the annotations menu
		When I click the note in the annotations menu
		Then I verify that the content contains "Notes"
		When I delete the note from the annotations menu
		Then I verify that the note is not displayed in the annotations menu
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_Note_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I add a note in the color "blue" by selecting the text "Editor and Author of Notes" with the description "Core Regression"
		And I jump to page "21"
		And I open the annotations menu
		Then I verify that the note is displayed in the annotations menu
		When I click the note in the annotations menu
		Then I verify that the content contains "Notes"
		When I delete the note from the annotations menu
		Then I verify that the note is not displayed in the annotations menu
		When I open the options menu
		And I sign out
		Then I close the app
		
@Core_Regression3
Feature: Import note

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the details panel of "AutomatedPITA" to import annotations
		And I click the Import Annotations link
		And I select "Automated Newberg" from the Import Annotations menu
		And I click the Import button
		Then I verify that the annotations were imported
		When I click the Close button
		And I open the title "AutomatedPITA"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_ImportNote_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the annotations menu
		And I open the displaced annotations menu
		And I click the displaced annotation
		And I create a displaced note by selecting the text "Income Tax Application Rules"
		And I jump to page "21"
		And I open the annotations menu
		Then I verify that the note is displayed in the annotations menu
		When I click the note in the annotation menu
		Then I verify that the content contains "Income Tax"
		When I delete the note from the annotation menu
		Then I verify that the note is not displayed in the annotations menu
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_ImportNote_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I open the annotations menu
		And I open the displaced annotations menu
		And I click the displaced annotation
		And I create a displaced note by selecting the text "Income Tax Application Rules"
		And I jump to page "21"
		And I open the annotations menu
		Then I verify that the note is displayed in the annotations menu
		When I click the note in the annotation menu
		Then I verify that the content contains "Income Tax"
		When I delete the note from the annotation menu
		Then I verify that the note is not displayed in the annotations menu
		When I open the options menu
		And I sign out
		Then I close the app
		
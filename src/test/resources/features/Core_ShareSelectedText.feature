@Core_Regression
Feature: Share selected text

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedNewberg"
		And I open the options menu
		And I click on "Layout" option of Options Menu
		
	Scenario: Core_ShareSelectedText_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I jump to page "1"
		Then I verify that the content contains "Text References"
		When I select the texts "Text References"
		And I click the "Share" option
		Then I verify that the "SelectedText" option is selected
		When I click the Next button
		And I save the PDF
		Then I verify that the PDF generated from "SelectedText" contains the text "Text"
		When I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_ShareSelectedText_Scroll
		And I select the "Scroll" layout option 
		And I close the options menu
		When I jump to page "1"
		Then I verify that the content contains "Text References"
		When I select the texts "Text References"
		And I click the "Share" option
		Then I verify that the "SelectedText" option is selected
		When I click the Next button
		And I save the PDF
		Then I verify that the PDF generated from "SelectedText" contains the text "Text"
		When I open the options menu
		And I sign out
		Then I close the app
		
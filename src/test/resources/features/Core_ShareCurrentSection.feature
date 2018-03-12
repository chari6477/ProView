@Core_Regression
Feature: Share current section
	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedNewberg"
		And I open the options menu
		And I click on "Layout" option of Options Menu
		
	Scenario: Core_ShareCurrentSection_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I jump to page "iitest1"
		Then I verify that the content contains "This page left intentionally blank - iitest1wwwwwwwxxxxxxx"
		When I open the Create & Share menu
		And I select the "PDF" from the sub menu 
		And I select the "CurrentTOCSection" pdf option
		Then I verify that the "CurrentTOCSection" option is selected
		When I click the Next button
		And I save the PDF
		Then I verify that the PDF generated from "CurrentTOCSection" contains the text "iitest1w"
		When I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_ShareCurrentSection_Scroll
		And I select the "Scroll" layout option 
		And I close the options menu
		When I jump to page "1.1"
		Then I verify that the content contains "On December 1, 2003"
		When I open the Create & Share menu
		And I select the "PDF" from the sub menu 
		And I select the "CurrentTOCSection" pdf option 
		Then I verify that the "CurrentTOCSection" option is selected
		When I click the Next button
		And I save the PDF
		Then I verify that the PDF generated from "CurrentTOCSection" contains the text "On December 1, 2003"
		When I open the options menu
		And I sign out
		Then I close the app
		
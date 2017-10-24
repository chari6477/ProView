@Core
Feature: Share current view

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedNewberg"
		And I open the options menu
		And I click on "Layout" option of Options Menu
		
	Scenario: Core_ShareCurrentView_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I jump to page "iitest1"
		Then I verify that the content contains "iitest1w"
		When I open the Create & Share menu
		And I select the "PDF" from the sub menu
		And I select the "CurrentView" pdf option
		Then I verify that the "CurrentView" option is selected
		When I click the Next button
		And I save the PDF
		Then I verify that the PDF generated from "CurrentView" contains the text "iitest1w"
		When I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_ShareCurrentView_Scroll
		And I select the "Scroll" layout option 
		And I close the options menu
		When I jump to page "iitest1"
		Then I verify that the content contains "222 Rosewood Drive"
		When I open the Create & Share menu
		And I select the "PDF" from the sub menu
		And I select the "CurrentView" pdf option
		Then I verify that the "CurrentView" option is selected
		When I click the Next button
		And I save the PDF
		Then I verify that the PDF generated from "CurrentView" contains the text "Rosewood"
		When I open the options menu
		And I sign out
		Then I close the app
		
@Core
Feature: Table viewer and PDF

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedTableViewer"
		And I open the options menu
		And I click on "Layout" option of Options Menu
		
	Scenario: Core_TableViewerAndPDF_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the table viewer
		Then I verify that the viewer contains "row 2, column 10"
		When I open the Create & Share PDF menu from the "table" viewer
		Then I verify that the "CurrentView" option is selected
		When I click the create and share Next button
		And I save the PDF
		Then I verify that the PDF generated from "TableViewer" contains the text "row 2"
		Then I close the "table" viewer
		And I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_TableViewerAndPDF_Scroll
		And I select the "Scroll" layout option 
		And I close the options menu
		When I open the table viewer
		Then I verify that the viewer contains "row 2, column 10"
		When I open the Create & Share PDF menu from the "table" viewer
		Then I verify that the "CurrentView" option is selected
		When I click the create and share Next button
		And I save the PDF
		Then I verify that the PDF generated from "TableViewer" contains the text "row 2"
		Then I close the "table" viewer
		And I open the options menu
		And I sign out
		Then I close the app
		
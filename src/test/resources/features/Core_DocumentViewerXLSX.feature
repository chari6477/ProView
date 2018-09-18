@Core_Regression1
Feature: Document viewer XLSX

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedDocumentViewer"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_DocumentViewerXLSX_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I click the "XLSX Test" link
		And I saves the XLSX file
		Then I verify that the XLSX "File" contains the text "1	XLSX	Test" 
		When I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_DocumentViewerXLSX_Scroll
		And I select the "Scroll" layout option 
		And I close the options menu
		When I click the "XLSX Test" link
		And I saves the XLSX file
		Then I verify that the XLSX "File" contains the text "1	XLSX	Test"
		When I open the options menu
		And I sign out
		Then I close the app
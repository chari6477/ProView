@Core
Feature: Document viewer DOCX

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedDocumentViewer"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_DocumentViewerDOCX_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I click the "DOCX Test" link
		And I save the file
		Then I verify that the DOCX "File" contains the text "DOCX Test"
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_DocumentViewerDOCX_Scroll
		And I select the "Scroll" layout option 
		And I close the options menu
		When I click the "DOCX Test" link 
		And I save the file
		Then I verify that the DOCX "File" contains the text "DOCX Test"
		When I open the options menu
		And I sign out
		Then I close the app
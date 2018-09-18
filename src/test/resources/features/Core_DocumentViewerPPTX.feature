@Core_Regression1
Feature: Document viewer PPTX

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedDocumentViewer"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_DocumentViewerPPTX_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I click the "PPTX Test" link
		And I saves the PPTX file
		Then I verify that the PPTX "File" contains the text "PPTX Test" 
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_DocumentViewerPPTX_Scroll
		And I select the "Scroll" layout option 
		And I close the options menu
		When I click the "PPTX Test" link
		And I saves the PPTX file
		Then I verify that the PPTX "File" contains the text "PPTX Test"
		When I open the options menu
		And I sign out
		Then I close the app

@Core
Feature: Image viewer and PDF

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedImageViewer"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_ImageViewerAndPDF_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the image viewer
		Then I verify that the viewer contains the image
		When I open the Create & Share PDF menu from the "image" viewer
		Then I verify that the "CurrentView" option is selected
		When I click the Next button
		And I save the PDF
		Then I verify that the PDF generated from "ImageViewer" contains the image
		When I close the "image" viewer
		And I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_ImageViewerAndPDF_Scroll
		And I select the "Scroll" layout option 
		And I close the options menu
		When I open the image viewer
		Then I verify that the viewer contains the image
		When I open the Create & Share PDF menu from the "image" viewer
		Then I verify that the "CurrentView" option is selected
		When I click the Next button
		And I save the PDF
		Then I verify that the PDF generated from "ImageViewer" contains the image
		When I close the "image" viewer
		And I open the options menu
		And I sign out
		Then I close the app
		
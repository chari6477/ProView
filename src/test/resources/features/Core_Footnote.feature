@Core
Feature: Footnotes

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedNewberg"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_Footnote_Pages
		And I select the "Pages" layout option 
		And I close the options menu
		And I jump to page "18"
		Then I verify that the content contains "promote judicial economy"
		#When I scroll to the bottom of the page
		And I click on the footnote "10"
		#Then I verify that the content scrolls to "topFootnote10Location"
		When I open the options menu
		And I sign out
		Then I close the app
		
	Scenario: Core_Footnote_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		And I jump to page "18"
		Then I verify that the content contains "promote judicial economy"
		When I click on the footnote "10"
		Then I verify that the footnote popover contains "Chardon v. Fumero"
		When I open the options menu
		And I sign out
		Then I close the app
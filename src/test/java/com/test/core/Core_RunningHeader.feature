@Core
Feature: Running header

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedNewberg"
		And I jump to page "18"
		Then I verify that the content contains "historic jurisdictional precedents"
		When I open the options menu
		And I click on "Layout" option of Options Menu
		
	Scenario: Core_RunningHeader_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the running header
		Then I verify that the content contains "Chapter 1 Theory"
		When I close the running header
		Then I verify that the content does not contain "Chapter 1 Theory"
		When I open the options menu
		And I sign out
		Then I close the app
		
	Scenario: Core_RunningHeader_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I open the running header
		Then I verify that the content contains "Chapter 1 Theory"
		When I close the running header
		Then I verify that the content does not contain "Chapter 1 Theory"
		When I open the options menu
		And I sign out
		Then I close the app
		
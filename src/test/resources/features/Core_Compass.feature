@Coress
Feature: Compass

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedCompass"
		Then I verify that the content contains "Chapter 1"
		When I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_Trial_Pages
		And I select the "Pages" layout option
		And I close the options menu
		Then I verify that the compass with the title "Ch1-S1" is available on page
		When I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_Trial_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		Then I verify that the compass with the title "Ch1-S1" is available on page
		When I open the options menu
		And I sign out
		Then I close the app
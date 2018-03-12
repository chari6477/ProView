@Core_Regression
Feature: Scrubber

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedNewberg"
		And I open the options menu
		And I click on "Layout" option of Options Menu
		
	Scenario: Core_Scrubber_Pages
		And I select the "Pages" layout option
		And I close the options menu
		And I slide the scrubber to the right edge
		Then I verify that the content contains "courts"
		When I slide the scrubber to the left edge
		Then I verify that the content contains "testing qed"
		When I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_Scrubber_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		And I slide the scrubber to the right edge
		Then I verify that the content contains "courts"
		When I slide the scrubber to the left edge
		Then I verify that the content contains "testing qed"
		When I open the options menu
		And I sign out
		Then I close the app
		
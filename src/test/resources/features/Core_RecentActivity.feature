@Core_Regression
Feature: Recent activity

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedNewberg"
		And I open the options menu
		And I click on "Layout" option of Options Menu
				
	Scenario: Core_RecentActivity_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I jump to page "18"
		Then I verify that the content contains "because a major objective"
		When I return to the library
		And I open the title "AutomatedNewberg" via Recent Activity
		Then I verify that the content contains "because a major objective"
		When I open the options menu
		And I sign out
		Then I close the app
		
	Scenario: Core_RecentActivity_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I jump to page "18"
		Then I verify that the content contains "because a major objective"
		When I return to the library
		And I open the title "AutomatedNewberg" via Recent Activity
		Then I verify that the content contains "because a major objective"
		When I open the options menu
		And I sign out
		Then I close the app
		
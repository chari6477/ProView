@Core_Regression
Feature: Quick links

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedQuickLinks"
		And I open the options menu
		And I click on "Layout" option of Options Menu
		
	Scenario: Core_QuickLinks_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the quick links menu
		And I select the "Athlete List" set
		And I click the "Dan Bennett" quick link
		Then I verify that the content reads "Section 3:2"
		And I close the quick links menu
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_QuickLinks_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I open the quick links menu
		And I select the "Athlete List" set
		And I click the "Dan Bennett" quick link
		Then I verify that the content reads "Section 3:2"
		And I close the quick links menu
		When I open the options menu
		And I sign out
		Then I close the app
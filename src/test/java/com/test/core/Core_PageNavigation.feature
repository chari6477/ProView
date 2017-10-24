@Core
Feature: Page navigation

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPITA"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_pageNav_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I navigate to the next page
		Then I verify that the content contains "NOTICE AND DISCLAIMER"
		When I navigate to the previous page
		Then I verify that the content contains "Contributing Editors"
		When I jump to page "v"
		Then I verify that the content contains "comprehensive and informative"
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_pageNav_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I navigate to the next page
		Then I verify that the content contains "1988 Tax Reform"
		When I navigate to the previous page
		Then I verify that the content contains "Contributing Editors"
		When I jump to page "v"
		Then I verify that the content contains "comprehensive and informative"
		When I open the options menu
		And I sign out
		Then I close the app
		
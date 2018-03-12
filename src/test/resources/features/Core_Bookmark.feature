@Core_Regression_sanity
Feature: Bookmarks

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPSD1"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_Bookmark_Pages
		And I select the "Pages" layout option 
		And I close the options menu
		When I add a bookmark in the color "purple" with the description "Core Regression"
		And I jump to page "5"
		And I open the annotations menu
		Then I verify that the bookmark is displayed in the annotations menu
		When I click the bookmark in the annotations menu
		Then I verify that the content contains "Thomson Reuters"
		When I delete the bookmark from the annotations menu
		Then I verify that the bookmark is not displayed in the annotations menu
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_Bookmark_Scroll
		And I select the "Scroll" layout option 
		And I close the options menu
		When I add a bookmark in the color "purple" with the description "Core Regression"
		And I jump to page "5"
		And I open the annotations menu
		Then I verify that the bookmark is displayed in the annotations menu
		When I click the bookmark in the annotations menu
		Then I verify that the content contains "Thomson Reuters"
		When I delete the bookmark from the annotations menu
		Then I verify that the bookmark is not displayed in the annotations menu
		When I open the options menu
		And I sign out
		Then I close the app
		
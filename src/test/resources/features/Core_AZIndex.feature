@Core_Regression  @Sanity
Feature: A-Z Index

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedAZIndex"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_AZIndex_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the A-Z index
		And I click the letter "C"
		And I click the "Class action flexibility" index link
		Then I verify that the content contains "Courts have emphasized the flexibility"
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_AZIndex_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I open the A-Z index
		And I click the letter "C"
		And I click the "Class action flexibility" index link
		Then I verify that the content contains "Courts have emphasized the flexibility"
		When I open the options menu
		And I sign out
		Then I close the app
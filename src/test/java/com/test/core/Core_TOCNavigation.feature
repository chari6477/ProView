@Core
Feature: Table of Contents navigation

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPITA"
		And I open the options menu
		And I click on "Layout" option of Options Menu
		
	Scenario: Core_TOCNavigation_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the table of contents
		And I click the section "Income Tax Act, Annotated"
		And I click the section "Short title"
		Then I verify that the content reads "An Act Respecting Income Taxes"
		And I close the TOC
		When I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_TOCNavigation_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I open the table of contents
		And I click the section "Income Tax Act, Annotated"
		And I click the section "Short title"
		Then I verify that the content reads "An Act Respecting Income Taxes"
		And I close the TOC
		When I open the options menu
		And I sign out
		Then I close the app
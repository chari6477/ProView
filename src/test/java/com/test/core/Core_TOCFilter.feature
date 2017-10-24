@Core
Feature: TOC filter

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPITA"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_TOCFilter_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the table of contents
		And I filter the table of contents by "former ITA"
		And I click the section "Effect of amendments on former ITA"
		And I close the TOC
		Then I verify that the content reads "Effect of amendments on former ITA"
		When I open the options menu
		And I sign out
		Then I close the app
		
	Scenario: Core_TOCFilter_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I open the table of contents
		And I filter the table of contents by "former ITA"
		And I click the section "Effect of amendments on former ITA"
		And I close the TOC
		Then I verify that the content reads "Effect of amendments on former ITA"
		When I open the options menu
		And I sign out
		Then I close the app
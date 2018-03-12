@Core_Regression
Feature: Internal links

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedLinking"
		And I jump to page "7"
		Then I verify that the content contains "Internal Linking"
		When I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_InternalLinks_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I click the link "Link to the same document on the same page"
		Then I verify that the content contains "Internal Linking"
		When I click the link "Link to the same document on a different page"
		Then I verify that the content contains "Internal link location: same document on a different page"
		When I jump to page "7"
		Then I verify that the content contains "Internal Linking"
		When I click the link "Link to a different document on a different page"
		Then I verify that the content contains "Internal link location: different document on a different page"
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_InternalLinks_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I click the link "Link to the same document on the same page"
		Then I verify that the content contains "Internal Linking"
		When I click the link "Link to the same document on a different page"
		Then I verify that the content contains "Internal link location: same document on a different page"
		When I jump to page "7"
		Then I verify that the content contains "Internal Linking"
		When I click the link "Link to a different document on a different page"
		Then I verify that the content contains "Internal link location: different document on a different page"
		When I open the options menu
		And I sign out
		Then I close the app
		
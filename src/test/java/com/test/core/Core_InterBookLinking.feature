@Core
Feature: Inter-book linking

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedLinking"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_InterBookLinking_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I jump to page "6"
		Then I verify that the content contains "Inter-book Linking"
		When I click the link "Link to anchor within Automated PSD v1.x (pages spanning documents)"
		And I click the Continue button for Inter-book linking
		Then I verify that the content reads "IBL anchor here"
		When I open the options menu
		And I sign out
		Then I close the app

	Scenario: Core_InterBookLinking_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I jump to page "6"
		Then I verify that the content contains "Inter-book Linking"
		When I click the link "Link to anchor within Automated PSD v1.x (pages spanning documents)"
		And I click the Continue button for Inter-book linking
		Then I verify that the content reads "IBL anchor here"
		When I open the options menu
		And I sign out
		Then I close the app
		
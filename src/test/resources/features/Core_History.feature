@Core_Regression1
Feature: History

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPITA"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_History_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I jump to page "5"
		When I jump to page "123"
		Then I verify that the content contains "If a province institutes"
		When I jump to page "5"
		Then I verify that the content contains "consistent with case law"
		When I open the history menu
		Then I verify that the history item for page "123" is displayed
		When I click the first history item
		Then I verify that the content contains "If a province institutes"
		When I click the Back button
		Then I verify that the content contains "consistent with case law"
		When I click the Forward button
		Then I verify that the content contains "If a province institutes"
		When I open the options menu
		And I sign out
		Then I close the app
	
	Scenario: Core_History_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I jump to page "5"
		When I jump to page "123"
		Then I verify that the content contains "If a province institutes"
		When I jump to page "5"
		Then I verify that the content contains "consistent with case law"
		When I open the history menu
		Then I verify that the history item for page "123" is displayed
		When I click the first history item
		Then I verify that the content contains "If a province institutes"
		When I click the Back button
		Then I verify that the content contains "consistent with case law"
		When I click the Forward button
		Then I verify that the content contains "If a province institutes"
		When I open the options menu
		And I sign out
		Then I close the app
		
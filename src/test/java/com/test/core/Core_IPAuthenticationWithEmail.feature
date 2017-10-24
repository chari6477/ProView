@Core
Feature: IP authentication with email

	Scenario: Core_IPAuthentication
		When I launch ProView via IP with email
		Then I verify that I am in the library
		When I open the title "AutomatedPeriodicalIssue3"
		Then I verify that the content contains "The Hub Daily"
		When I add a highlight in the color "purple" by selecting the text "Spread the word: Engage for success"
		And I jump to page "03-2"
		And I open the annotations menu
		Then I verify that the highlight is displayed in the annotations menu
		When I click the highlight in the annotations menu
		Then I verify that the content contains "Spread the word: Engage for success"
		When I delete the highlight from the annotations menu
		Then I verify that the highlight is not displayed in the annotations menu
		When I open the options menu
		And I sign out
		Then I close the app
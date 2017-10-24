@Core
Feature: Annotations color filter

	Scenario: Core_AnnotationsColorFilter
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPITA"
		And I add a highlight in the color "orange" by selecting the text "Editor and Author of Notes"
		And I open the annotations menu
		Then I verify that the highlight is displayed in the annotations menu
		When I open the annotations color filter
		And I select the "blue" filter option
		Then I verify that the highlight is not displayed in the annotations menu
		Then I open the annotations menu
		When I open the annotations color filter
		And I select the "all" filter option
		Then I verify that the highlight is displayed in the annotations menu
		When I delete the highlight from the annotations menu
		Then I verify that the highlight is not displayed in the annotations menu
		When I open the options menu
		And I sign out
		Then I close the app
@Core_Regression
Feature: Options menu

	Scenario: Core_OptionsMenu
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPITA"
		And I jump to page "3"
		Then I verify that the content contains "hockey training"
		When I open the options menu
		And I select the color scheme "White On Black"
		Then I verify that the content is in the color scheme "White On Black"
		When I return to the library
		And I open the title "AutomatedPITA"
		Then I verify that the content is in the color scheme "White On Black"
		When I open the options menu
		And I select the color scheme "Black On White"
		Then I verify that the content is in the color scheme "Black On White"
		When I open the options menu
		And I sign out
		Then I close the app
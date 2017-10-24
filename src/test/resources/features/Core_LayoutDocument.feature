@Core
Feature: Layout document

	Scenario: Core_LayoutDocument
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the title "AutomatedPeriodicalIssue3"
		And I open the options menu
		Then I verify that the user is unable to make any display changes 
		When I navigate to the next page
		And I open the options menu
		And I select the color scheme "White On Black"
		Then I verify that the content is in the color scheme "White On Black"
		When I navigate to the previous page
		Then I verify that the content is in the color scheme "Black On White"
		When I navigate to the next page
		Then I verify that the content is in the color scheme "White On Black"
		When I open the options menu
		And I select the color scheme "Black On White"
		Then I verify that the content is in the color scheme "Black On White"
		Then I open the options menu
		And I sign out
		Then I close the app
		
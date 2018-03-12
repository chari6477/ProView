@Core_Regression_sanity
Feature: Categories
  #the verify should be changed back to "This Is A Category With A Name That Is 50 Chars!!!" when we see if the bug is a bug/it gets fixed
	Scenario: Core_Categories
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the details panel of "AutomatedNewberg"
		Then I verify that the category "This Is A Category ... hat Is 50 Chars!!!" is displayed
		When I add the category "Core Regression"
		Then I verify that the user category "Core Regression" is displayed
		When I delete the category
		Then I verify that the category "Core Regression" is not displayed
		When I open the account menu
		And I sign out from the account menu
		Then I close the app
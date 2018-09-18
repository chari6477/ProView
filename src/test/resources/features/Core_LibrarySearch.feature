@Core_Regression1
Feature: Library search 

Scenario: Core_LibrarySearch 
	When I launch ProView 
	And I sign in 
	Then I verify that I am in the library 
	When I open the library search and filter panel 
	And I execute a text search for "newberg" 
	Then I verify that the tag labeled "newberg" is displayed 
	When I open the title "AutomatedNewberg" in current page 
	Then I verify that the title search "newberg" was executed 
	When I return to the library 
	When I clear the "newberg" label 
	Then I verify that the library search was cleared 
	When I open the account menu 
	And I sign out from the account menu 
	Then I close the app 
		
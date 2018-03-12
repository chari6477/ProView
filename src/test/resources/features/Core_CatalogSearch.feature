@Core_Regression
Feature: Catalog search

	Background:
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I click the Catalog tab
		Then I verify that I am in the catalog tab
		When I select the catalog "Automated Catalog"
		And I execute a catalog search for "florida"
		Then I verify that the tag labeled "florida" is displayed
		
	Scenario: Core_CatalogSearch_OpenTitle
		When I open the catalog search result "AutomatedPITA"
		#Then I verify that the title search was executed
		When I return to the library
		Then I verify that I am in the library
		When I open the account menu
		And I sign out from the account menu
		Then I close the app
		
	Scenario: Core_CatalogSearch_PreviewTitle
		When I open the catalog search result "AutomatedCatalogPreviewNoeStoreLink"
		Then I verify that the title preview is displayed
		When I return to the library
		#When I return to the catalog search results
		And I clear the catalog search
		Then I verify that the catalog search was cleared
		When I open the account menu
		And I sign out from the account menu
		Then I close the app
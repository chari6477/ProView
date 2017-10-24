@Core
Feature: Translation via URL

	Scenario: Core_TranslationViaURL
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I change the language to "es_ES" via the URL
		Then I verify that the content in the quick tip contains "Para agregar"
		When I change the language to "en_US" via the URL
		Then I verify that the content in the quick tip contains "To add a Note"
		When I open the account menu
		And I sign out from the account menu
		Then I close the app

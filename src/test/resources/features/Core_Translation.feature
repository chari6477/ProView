# DEPRECATED! USE Core_TranslationViaURL
Feature: Translation

	Scenario: Core_Translation
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I open the account menu
		And I click on "Language" option of Options Menu
		And I select the "Spanish" language
		Then I verify that the content in the quick tip contains "Para agregar"
		When I open the account menu
		And I click on "Language" option of Options Menu
		And I select the "EnglishUS" language
		Then I verify that the content in the quick tip contains "To add a Note"
		When I open the account menu
		And I sign out from the account menu
		Then I close the app
		
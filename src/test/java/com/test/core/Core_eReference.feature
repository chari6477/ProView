@Core
Feature: eReference filter button

	Scenario: Core_eReference
		When I launch ProView
		And I sign in
		Then I verify that I am in the library
		When I click the eReference tab
		Then I verify that the title "AutomatedEReference" is displayed
		And I verify that the library is sorted by "Subject"
		When I click the library tab
		Then I verify that the title "AutomatedNewberg" is displayed
		When I open the account menu
		And I sign out from the account menu
		Then I close the app

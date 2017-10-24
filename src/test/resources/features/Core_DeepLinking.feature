@Coress
Feature: Deep linking

	Scenario: Core_DeepLinking
		When I launch ProView via deep linking
		And I select the "Web Browser" option for deep linking
		And I click the Launch ProView button
#		And I select the "signIntoProViewNow" option for deep linking
#		And I click the Launch ProView button
		And I sign in to view the deep link
		Then I verify that the content contains "IBL anchor here"
		When I open the options menu
		And I sign out
		Then I close the app
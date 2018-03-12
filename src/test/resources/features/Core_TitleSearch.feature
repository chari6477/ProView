@Core_Regression_sanity
Feature: Title search

	Background:
		When I launch ProView
		And I sign in 
		Then I verify that I am in the library
		When I open the title "AutomatedThesaurus"
		And I open the options menu
		And I click on "Layout" option of Options Menu

	Scenario: Core_TitleSearch_Pages
		And I select the "Pages" layout option
		And I close the options menu
		When I open the search menu
		And I execute a thesaurus search for "CHILD SUPPORT"
		And I execute a keyWord search for "chief judge"
		And I click the first hit link with text "APPOINTMENT, POWERS AND DUTIES"
		Then I verify that the content contains "APPOINTMENT, POWERS AND DUTIES"
		And I verify that the hit number "1" of text "CHIEF JUDGE" is highlighted
		When I click the Next Hit button
		Then I verify that the hit number "2" of text "Chief Judge" is highlighted
		When I click the Previous Hit button
		Then I verify that the hit number "1" of text "CHIEF JUDGE" is highlighted
		When I click the Reset button
		Then I verify that the hit number "1" of text "CHIEF JUDGE" is not highlighted
		When I open the options menu
		And I sign out
		Then I close the app                                          
		
	Scenario: Core_TitleSearch_Scroll
		And I select the "Scroll" layout option
		And I close the options menu
		When I open the search menu
		And I execute a thesaurus search for "CHILD SUPPORT"
		And I execute a keyWord search for "chief judge"
		And I click the first hit link with text "APPOINTMENT, POWERS AND DUTIES"
		Then I verify that the content contains "APPOINTMENT, POWERS AND DUTIES"
		And I verify that the hit number "1" of text "CHIEF JUDGE" is highlighted
		When I click the Next Hit button
		Then I verify that the hit number "2" of text "Chief Judge" is highlighted
		When I click the Previous Hit button
		Then I verify that the hit number "1" of text "CHIEF JUDGE" is highlighted
		When I click the Reset button
		Then I verify that the hit number "1" of text "CHIEF JUDGE" is not highlighted
		When I open the options menu
		And I sign out
		Then I close the app
		
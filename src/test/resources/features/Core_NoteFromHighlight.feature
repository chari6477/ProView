@Core_Regression1
Feature: Note from highlight

  Background: 
    When I launch ProView
    And I sign in
    Then I verify that I am in the library
    When I open the title "AutomatedPITA"
    And I open the options menu
    And I click on "Layout" option of Options Menu

  Scenario: Core_NoteFromHighlight_Pages
    And I select the "Pages" layout option
    And I close the options menu
    When I add a highlight in the color "purple" by selecting the text "Income Tax Application Rules"
    And I open the annotations menu
    Then I verify that the highlight is displayed in the annotations menu
	When I add a note from the highlight "Rules" with the text "Core Regression"
    Then I verify that the note is displayed in the annotations menu
	When I click the note in the annotations menu
	Then I verify that the content contains "Rules"
    When I delete the note from the annotations menu
    Then I verify that the note is not displayed in the annotations menu
    When I open the options menu
    And I sign out
    Then I close the app

  Scenario: Core_NoteFromHighlight_Scroll
    And I select the "Scroll" layout option
    And I close the options menu
     When I add a highlight in the color "purple" by selecting the text "Income Tax Application Rules"
    And I open the annotations menu
    Then I verify that the highlight is displayed in the annotations menu
	When I add a note from the highlight "Rules" with the text "Core Regression"
    Then I verify that the note is displayed in the annotations menu
	When I click the note in the annotations menu
	Then I verify that the content contains "Rules"
    When I delete the note from the annotations menu
    Then I verify that the note is not displayed in the annotations menu
    When I open the options menu
    And I sign out
    Then I close the app
	
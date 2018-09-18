@Core_Regression
Feature: eStore Link 

Scenario: Core_eStoreLink 

	Given Paste this URL into a browser tab and hit Enter "https://proview.ci.thomsonreuters.com/launchapp/title/fake/fake/fake/v1?query=test&tterm=FAKE%20TERM&su=http%3A%2F%2Fwww.google.com%2F" 
	#When Select "Web Browser" 
	#And Click on the "Launch ProView" button 
	#And You can either select "Sign in to ProView now" (as OnePass) or "Not Now" (as IP) 
	#And Click on the "Launch ProView" buttons 
	When If you chose "Sign in to ProView now", enter credentials and click on the Sign In button 
	Then At the library page, verify a dialog is displayed and it includes: The text "This title is not available in your library." 
	And At the library page, verify a dialog is displayed and it includes: The text "Visit the store to purchase this title." 
	And A Visit Store button 
	And A Cancel link 
	When Click on the Visit Store button 
	Then Verify the user is taken to the Google.com page in a new browser window 
	And Verify the ProView browser window no longer shows the dialog 
	Then I close the app
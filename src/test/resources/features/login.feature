Feature: Login Page feature

  @Regression
Scenario: Login Page title
Given user is on login page
When user gets the title of the page
Then page title should be "demosite"

  @smoke
Scenario: New User button
Given user is on login page
Then New User button should be displayed

  @Regression
Scenario: Login with correct credentials
Given user is on login page
When user enters username "saisonu"
And user enters password "Sonu@2000"
And user clicks on login
When user gets the title of the page
Then page title should be "demosite"
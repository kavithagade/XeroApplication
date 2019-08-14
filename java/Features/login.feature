Feature: Xero login feature
Scenario: Xero login Test Scenario

#user navigates to www.xero.com and click on Login
Given user is already on login page
When user enters username and enters password
And user clicks on login button
Then user is on Account Dashboard
And user clicks on Connect your bank accounts link
And user enters Bank Account details
And user clicks on Continue
And user is on Dashboard


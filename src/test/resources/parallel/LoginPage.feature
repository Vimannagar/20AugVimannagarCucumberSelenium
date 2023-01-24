Feature: Login page feature

@functional
Scenario: Login page title
Given user is at the login page
When user gets the title of page
Then page should contain "Shopping"

@regression
Scenario: orders link
Given user is at the login page
Then order link should get display

@smoke
Scenario: Login with correct credentials
Given user is at the login page
When user enters the username as "8176867662"
And user enters the password as "123456"
And user click on signin button

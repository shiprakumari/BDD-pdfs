#Author:Shipra Kumari
Feature: Login
Background:
Given User is on AccountPage

Scenario: Check the heading of the Form
Then user verify the heading of the Form

Scenario: Prompt user to fill the name field
When user does not enter the name
And user click the submit button
Then display pop up  message 

Scenario: Prompt user to fill the mobile field
When user does not enter the mobile number
And user click the submit button
Then display pop up message

Scenario: Prompt user to fill the Email field
When user does not enter the email 
And user click the submit button
Then display the pop uop message

Scenario: Prompt user to fill the address field
When user does not enter the address
And user click the submit button
Then display the pop up message

Scenario: Failed submission as user enterd the invalid Name
When user enter the invalid name
And user click the submit button
Then display the error message

Scenario: failed submission as user enters the invalid mobile number
When user enter the invalid mobile number
|000000000|
|1235454665|
|986737346758|
|dsbfsdhfds|
|987654|
Then display the err message

Scenario: failed submission as user enterd invalid email 
When user enters invalid email
|12345@vgfv|
|fdvf.fhf|
|dvfvd@354.fdb|
|fbfb.gfvg.fbghf|
Then display the err message

Scenario: Failed submission as user enterd invalid address
When user enter invalid address
|#^&%*&|
|5645734|
Then display error message

Scenario: Succesful Submission as user enterd data with valid credentials
When user enter valid data
And user click the submit button
Then display success message

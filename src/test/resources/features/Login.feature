Feature: Login functionality

Background: 
Given User has navigates to login page

Scenario: Login with valid credentials
When User has entered valid email address "omarnechmii@outlook.fr"
And User has entered valid password "45877"
And User clicks on login button 
Then User should get succedfully login in 

Scenario: Login with invalid credentials 
When User enters invalid email adress into email fiels
And User enters inavalid password "457" into password field
And User clicks on login button 
Then User should get a warning message about credentials mismatch

Scenario: Login with valid email and invalid password
When User has entered valid email address "omarnechmii@outlook.fr"
And User enters inavalid password "457" into password field
And User clicks on login button 
Then User should get a warning message about credentials mismatch

Scenario: Login with invalid email and valid password
When User enters invalid email adress into email fiels
And User has entered valid password "45877"
And User clicks on login button 
Then User should get a warning message about credentials mismatch

Scenario: Login without providing any credentials
When User dont enter any email adress into email field
And User dont enter any password into password field
And User clicks on login button 
Then User should get a warning message about credentials mismatch


  
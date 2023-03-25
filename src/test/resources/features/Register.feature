Feature: Registration functionality

Background: 
Given User has navigates to Registration Account page 

Scenario: User creates an account only with mandatory fields
When User enters the details into the below fields
|FirstName|Omar                   |
|LastName |Nachmi                 |
|Telephone |54656458               |
|Password  |45877                  |
And User selects Privacy Policy
And User clicks on Continue button 
Then User account sgould get created succefully

Scenario: User creates an account  with mandatory fields
When User enters the details into the below fields
|FirstName|Omar                   |
|LastName |Nachmi                 |
|Telephone |54656458               |
|Password  |45877                  |
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button 
Then User account sgould get created succefully

Scenario: User creates a duplicate account  
When User enters the details into the below fields with exist email
|FirstName|Omar                    |
|LastName |Nachmi                  |
|E-mail   |omarnechmii@outlook.fr  |
|Telephone|54656458                |
|Password |45877                   |
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button 
Then User should get a proper warning about duplicate email

Scenario: User creates an account without filling any details
When User dont enter any details into fields 
And User clicks on Continue button  
Then User should get proper warning messages for every mandatory field


Feature: validate age for the registration for the BBC   

Background:
Given I launch https://account.bbc.com/signin																								
And I click "Register" now	
And I'm on the starting page for registration  

@Test	
Scenario: Verify that the visitor is over 13   
    
When I click on "13 or over" button   
Then I will go to the "Date of Birth" registration   
    
@Test 
Scenario: Verify that the visitor is under 13   
    
Given I'm on the starting page for registration   
When I click on "under 13" button   
Then I will receive the following message: "Sorry, you can’t register the child because you’re outside the UK"   
    

Scenario: Verify that the visitor can't use empty fields to progress further   
    
Given I'm on the date of birth registration page   
When The field Day is empty   
And The field Month is empty   
And The field Year is empty   
Then When I leave the year field I should receive the following message: "Oops, that date doesn't look right. Make sure it's a real date written as DD-MM-YYYY e.g. the 5th of June 2009 is 05-06-2009."   
    
@TestAkshat55
Scenario: Verify that the visitor can't be under 13   
    
Given I'm on the date of birth registration page   
When The field Day is 03   
And The field Month is 02   
And The field Year is 2010   
And Click the "Continue" button   
Then When I click I should receive the following message: "Sorry, you need to be 13 or over."   
    
@TestAkshat
Scenario: Verify that the visitor is over 13   
    
Given I'm on the date of birth registration page   
When The field Day is 03   
And The field Month is 02   
And The field Year is 1990   
And Click the "Continue" button   
Then When I click I should go to the email registration page   
    
@TestAkshat111
Scenario: validate if a correct email is used   
    
Given I'm on the registration page for e-mail and password   
When The field e-mail is filled in by "whoknows@hotmailcom"   
And Go to password field   
Then I'll receive the message: "Sorry, that doesn't look right. Please check it's a proper email."   
    
@Test11
Scenario: validate if a correct email is used   
    
Given I'm on the registration page for e-mail and password   
When The field e-mail is filled in by "whoknows@hotmail.com"   
And Go to password field   
Then I should not receive an error   
    
@Test11
Scenario: validate if a password of 7 or less characters is able to be used.   
    
Given I'm on the registration page for e-mail and password   
When The field e-mail is filled in by "whoknows@hotmail.com"   
And Go to password field   
And The field password is filled in with: "Whokno3"   
Then I should receive the error: "Sorry, that password is too short. It needs to be eight characters or more."   
    
@TestAkshat
Scenario: validate if a password without numbers is able to be used.   
    
Given I'm on the registration page for e-mail and password   
When The field e-mail is filled in by "whoknows@hotmail.com"   
And Go to password field   
And The field password is filled in with: "Whoknows"   
Then I should receive the error: "Sorry, that password isn't valid. Please include something that isn't a letter."   
    
 @TestAkshat111
Scenario: validate if a password without letters is able to be used.   
    
Given I'm on the registration page for e-mail and password   
When The field e-mail is filled in by "whoknows@hotmail.com"   
And Go to password field   
And The field password is filled in with: "@345678!"   
Then I should receive the error: "Sorry, that password isn't valid. Please include a letter."   
    
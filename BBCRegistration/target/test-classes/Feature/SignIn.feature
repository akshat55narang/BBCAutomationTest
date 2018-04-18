Feature: Sign up for the BBC																								

@Signin																								
Scenario: Verify that the visitor can go the subscribe page																								
																									
Given I launch https://account.bbc.com/signin																								
When I click "Register" now																								
Then I'm on the starting page for registration																								


@Regression1 @Case_1A2
Feature: Interview Nicolas Mori 

Scenario Outline: Access to the app after make the login. 

	Given I start the browser 
	And I access to this url "<url>"
	And I login to the web application 
	Then I press in the menu Transfers 
	And I select te first of my favorites contacts 
	And I set in the amount field the amount 
	And I include in the text reference this test 
	And I access the Transfer Code 
	And I press the button Transfer 
	Then I check if I can see the pop up message. 
	
	Examples: 
		| device uuid     	| url				 	 | 
		| 8575525242395141 	| https://my.n26.com/	 | 
		
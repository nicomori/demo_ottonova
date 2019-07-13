@Regression1 @Case_1A1
Feature: Interview Nicolas Mori 

Scenario Outline: Make a transfer of money to high.

	Given I start the android native app with this device "<device uuid>"
	And press in the button iniciar sesion
	
	Examples:
	| device uuid     	| email		 | pass     | 
	| 8575525242395141 	| qa@n26.com | 123asdF  |
		
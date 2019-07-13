package com.demo.ottonova.steps;

import com.demo.ottonova.framework.ParentScenario;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class StepsWeb extends ParentScenario {

	@Then("I press in the menu Transfers")
	public void a333() {
		System.out.println("333333333333333333333333333");
	}

	@And("I select te first of my favorites contacts")
	public void a444() {
		System.out.println("4444444444444444444444444444");
	}

	@And("I set in the amount field the amount")
	public void a555() {
		System.out.println("5555555555555555555555555");
	}

}
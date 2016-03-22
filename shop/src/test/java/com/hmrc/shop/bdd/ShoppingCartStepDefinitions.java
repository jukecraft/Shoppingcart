package com.hmrc.shop.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingCartStepDefinitions {
	
	@Given("^the fruit cost in \"([^\"]*)\"$")
	public void initialiseFruitCost(String fruitPropertiesFile) throws Throwable {
		System.out.println("1");
	}

	@When("^the customer scans \"([^\"]*)\"$")
	public void scanItems(String items) throws Throwable {
		System.out.println("2");
	}

	@Then("^The total cost should be (.+)$")
	public void generateTotalCostOfBill(double expectedCost) throws Throwable {
		System.out.println("3 " +expectedCost);
	}
}

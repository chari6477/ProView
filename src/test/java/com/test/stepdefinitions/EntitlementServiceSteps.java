package com.test.stepdefinitions;

import java.io.IOException;

import org.apache.http.ParseException;

import com.util.helpers.EntitlementService;
import com.util.helpers.PropertyReader;

import cucumber.api.java.en.Then;

public class EntitlementServiceSteps
{
	EntitlementService entitlement = new EntitlementService();
	PropertyReader propertyReader = new PropertyReader();

	@Then("^I check in the checkout code$")
	public void i_check_in_the_checkout_code() throws ParseException, IOException
	{
		entitlement.removeEntitlement(propertyReader.readProperty("Environment"), propertyReader.readProperty("EntitlementAccountID"), propertyReader.readProperty("CheckoutCode"));
	}
}
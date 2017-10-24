package com.test.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = {"com.test.stepdefinitions"},
		plugin = {"pretty", "json:results/json/output.json", "html:results/cucumber-html-report"},
		tags = {"@Coress"} //to run multiple tags, change to "@Core, @Whatever"
		)

public class FirefoxRunner
{
	@BeforeClass
	public static void setUp(){
		System.setProperty("Browser", "IE");
	}

}
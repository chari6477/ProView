package com.test.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"com.test.stepdefinitions"},
		plugin = {"json:target/cucumber.json" , "html:target/site/cucumber-pretty"},
		tags ={"@Core_Regression_sanity"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	

}

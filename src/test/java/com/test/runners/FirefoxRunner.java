package com.test.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources"},
		glue = {"com.test.stepdefinitions"},
		plugin = {"pretty", "json:results/json/output.json", "html:results/cucumber-html-report"},
		tags = {"@Core"} //to run multiple tags, change to "@Core, @Whatever"
		)

public class FirefoxRunner
{
	@BeforeClass
	public static void setUp(){
		System.setProperty("Browser", "IE");
	}

}
package com.test.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * A sample test to demonstrate
 */
@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/resources"},
	glue = {"com.test.stepdefinitions"},
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
	tags ={"@Core"}
)
public class ChromeRunner {
	@BeforeClass
	public static void setUp(){
		System.setProperty("Browser", "firefox");
	}
	
	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}

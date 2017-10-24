package com.test.core;

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
	features = {"src/test/java"},
	glue = {"com.test.stepdefinitions"},
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
	tags ={"@Coress"}
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
		Reporter.setSystemInfo("os", "Mac OSX");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}

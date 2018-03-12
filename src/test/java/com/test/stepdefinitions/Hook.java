package com.test.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.util.helpers.DriverFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends DriverFactory{


	private WebDriver driver = getDriver();
	Scenario scenario ;


	@Before
	public void testSetup(Scenario scenario)
	{
		this.scenario = scenario;
		System.out.println("Test Envoronment setup.");
		System.out.println("------------------------------------------------------------");
		System.out.println("Executing Scenario is : "+ scenario.getName());
	}

	@After
	public void tearDown(Scenario scenario)
	{
		scenario.write("Scenario finished...");
		System.out.println("Scenario is ended...");
		if(scenario.isFailed())
		{
			System.err.println(scenario.getName() +    ": Scenario is failed.");
			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
			/*try {
				driver.close();
			}catch(Exception e) {}*/
		}

		System.out.println("------------------------------------------------------------");
	}


}

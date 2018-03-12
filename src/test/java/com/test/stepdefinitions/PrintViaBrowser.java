package com.test.stepdefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.util.helpers.DriverFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrintViaBrowser  extends DriverFactory{

	Robot robot;

	@When("^I generate a print preview$")
	public void i_generate_a_print_preview() throws Throwable {
		Thread.sleep(15000);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	@Then("^I verify that the print preview displays the same content that was displayed in the current view$")
	public void i_verify_that_the_print_preview_displays_the_same_content_that_was_displayed_in_the_current_view() throws Throwable {
		Thread.sleep(5000);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}

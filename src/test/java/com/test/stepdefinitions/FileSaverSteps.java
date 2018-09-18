package com.test.stepdefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.util.helpers.DriverFactory;
import com.util.pages.FileSaver;

import cucumber.api.java.en.When;

public class FileSaverSteps extends DriverFactory
{
	WebDriver driver = getDriver();
	FileSaver fileSaver = new FileSaver(driver);
	
	@When("^I save the file$")
	public void i_save_the_file() throws IOException, InterruptedException, AWTException
	{
		fileSaver.saveFile();
		Thread.sleep(10000);
	}
	
	@When("^I saves the file$")
	public void i_saves_the_file() throws IOException, InterruptedException, AWTException
	{
		fileSaver.savesFile();
		Thread.sleep(10000);
	}
	
	@When("^I save the PDF file$")
	public void i_save_the_PDF_file() throws IOException, InterruptedException, AWTException
	{
		fileSaver.savePDFfile();
		Thread.sleep(10000);
	}
	
	@When("^I saves the PDF file$")
	public void i_saves_the_PDF_file() throws IOException, InterruptedException, AWTException
	{
		fileSaver.savesPDFfile();
		Thread.sleep(10000);
	}
	
	@When("^I save the PPTX file$")
	public void i_save_the_PPTX_file() throws IOException, InterruptedException, AWTException
	{
		fileSaver.savePPTXfile();
		Thread.sleep(10000);
	}
	
	@When("^I saves the PPTX file$")
	public void i_saves_the_PPTX_file() throws IOException, InterruptedException, AWTException
	{
		fileSaver.savesPPTXfile();
		Thread.sleep(10000);
	}
	
	@When("^I save the XLSX file$")
	public void i_save_the_XLSX_file() throws IOException, InterruptedException, AWTException
	{
		fileSaver.saveXLSXfile();
		Thread.sleep(10000);
	}
	
	@When("^I saves the XLSX file$")
	public void i_saves_the_XLSX_file() throws IOException, InterruptedException, AWTException
	{
		fileSaver.savesXLSXfile();
		Thread.sleep(10000);
	}
}

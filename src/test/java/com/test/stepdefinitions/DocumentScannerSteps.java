package com.test.stepdefinitions;

import java.io.IOException;

import com.util.helpers.DocumentScanner;
import com.util.helpers.DriverFactory;

import cucumber.api.java.en.Then;

public class DocumentScannerSteps extends DriverFactory
{
	DocumentScanner docScanner = new DocumentScanner();
	
	@Then("^I verify that the DOCX \"(.*?)\" contains the text \"(.*?)\"$")
	public void i_verify_that_the_DOCX_contains_the_text(String filePath, String text) throws IOException, InterruptedException
	{
		filePath="DOCX_"+filePath+"_FilePath";
		docScanner.scanDOCX(text, filePath);
	}
	
	@Then("^I verify that the PDF generated from \"(.*?)\" contains the text \"(.*?)\"$")
	public void i_verify_that_the_pdf_contains(String scenario, String text) throws IOException, InterruptedException
	{
		scenario="PDF_"+scenario+"_FilePath";
		docScanner.scanPDF(scenario, text);
	}

	@Then("^I verify that the PDF generated from \"(.*?)\" contains the image$")
	public void i_verify_that_the_PDF_contains_the_image(String scenario) throws IOException, InterruptedException
	{
		scenario="PDF_"+scenario+"_FilePath";
		docScanner.checkForImage(scenario);
	}

/*	@Then("^I verify that the PDF \"(.*?)\" contains the text \"(.*?)\"$")
	public void i_verify_that_the_PDF_contains_the_text(String filePath, String text) throws IOException, InterruptedException
	{
		docScanner.scanPDF(filePath, text);
	}*/

	@Then("^I verify that the PPTX \"(.*?)\" contains the text \"(.*?)\"$")
	public void i_verify_that_the_PPTX_contains_the_text(String filePath, String Text) throws IOException, InterruptedException
	{
		filePath="PPTX_"+filePath+"_FilePath";
		docScanner.scanPPTX(Text, filePath);
	}

	@Then("^I verify that the XLSX \"(.*?)\" contains the text \"(.*?)\"$")
	public void i_verify_that_the_XLSX_contains_the_text(String filePath, String Text) throws IOException, InterruptedException
	{
		filePath="XLSX_"+filePath+"_FilePath";
		docScanner.scanXLSX(Text, filePath);
	}
}
package com.util.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.util.helpers.BaseObject;

public class Epub extends BaseObject{

	Screen screen = new Screen();
	public Epub(WebDriver driver)
	{
		this.driver = driver;
	}

	public void openUrl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void searchForBook(String searchText)
	{
		threadWait(5);
		highlightElement(searchTextFeild());
		enterText(searchTextFeild(), searchText);
		pressKeyEnter();
	}

	public WebElement searchTextFeild(){
		return findWebElementFromPropertyName("searchForBooksTextbox_ID");
	}

	public void clickOnBook(String bookName)
	{
		highlightElement(searchBook(bookName));
		clickWebElement(searchBook(bookName) , 5);
	}

	public WebElement searchBook(String bookName){
		return findWebElementFromPropertyName("searchForBookHavingLinkText_XPATH" , bookName);
	}

	public void clickLinkToDownload(String linkName)
	{
		highlightElement(locateLink(linkName));
		clickWebElement(locateLink(linkName) , 5);
	}

	public WebElement locateLink(String linkText){
		return findWebElementFromPropertyName("locateLinkToDownload_XPATH" , linkText);
	}


	public void importEpub()
	{
		threadWait(15);
		String command = "cmd.exe /c start cmd /k \" C:\\Users\\pc00541557\\Desktop\\epub.bat \"";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {

			e.printStackTrace();
		}

		//	okButtonOfPopup_ThisTitleAndItsAnnotationsAreOnlyStoredOnThisDeviceAndAreNotAvailableInOtherVersionsOfProView();
		threadWait(50);
	}

	public void okButtonOfPopup_ThisTitleAndItsAnnotationsAreOnlyStoredOnThisDeviceAndAreNotAvailableInOtherVersionsOfProView()
	{
		Pattern okButton = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\okButtonOfStartingPopup.PNG");
		for(int i=1;i<=40;i++)
		{
			try {
				screen.click(okButton);
				break;
			} catch (FindFailed e) {
				System.out.println(i+" seconds : waiting for image of popup to get Ok button and be clicked...");
				threadWait(1);
			}
		}
	}

	public void verifyTitle()
	{
		Pattern titleName = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\PrideAndPrejudiceTitleImage.PNG");
		for(int i=1;i<=40;i++)
		{
			try {
				screen.find(titleName);
				System.out.println(i+" loop --> verification is PASSED about whether Title imported succesfully");
				screen.click(titleName);
				break;
			} catch (FindFailed e) {
				System.out.println(i+" loop --> verification is FAILED about whether Title imported succesfully");
				threadWait(1);
			}
		}
	}

	public void arrowForwardSymbol()
	{
		Pattern arrowForward = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\nextPageArrow.PNG");
		for(int i=1;i<=20;i++)
		{
			try {
				screen.click(arrowForward);
				break;
			} catch (FindFailed e) {
				threadWait(1);
			}
		}
	}
	
	public void backButtonSymbol()
	{
		Pattern backbTN = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\BackButton.PNG");
		for(int i=1;i<=20;i++)
		{
			try {
				screen.click(backbTN);
				break;
			} catch (FindFailed e) {
				threadWait(1);
			}
		}
	}
	
	public void i_Image()
	{
		Pattern i_library = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\library_i_symbol.PNG");
		for(int i=1;i<=20;i++)
		{
			try {
				screen.click(i_library);
				threadWait(2);
				break;
			} catch (FindFailed e) {
				threadWait(1);
			}
		}
	}
	
	public void deleteTitle()
	{
		Pattern remove = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\removeFromDevice.PNG");
		for(int i=1;i<=20;i++)
		{
			try {
				screen.click(remove);
				threadWait(2);
				break;
			} catch (FindFailed e) {
				threadWait(1);
			}
		}
	}
	
	public void ok_RemoveTitle()
	{
		i_Image();
		deleteTitle();
		Pattern ok = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\Ok_Remove.PNG");
		for(int i=1;i<=20;i++)
		{
			try {
				screen.click(ok);
				threadWait(2);
				break;
			} catch (FindFailed e) {
				threadWait(1);
			}
		}
	}




}

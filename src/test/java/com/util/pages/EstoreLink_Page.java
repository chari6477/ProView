package com.util.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;

public class EstoreLink_Page extends BaseObject{

	WebDriver driver;
	SignIn sign ;
	public EstoreLink_Page(WebDriver driver)
	{
		this.driver = driver;
		sign = new SignIn(this.driver);
	}

	public void launchBrowserWithGivenURL(String url)
	{
		driver.get(url);
		sign.cookieTermsAcceptance();
	}

	public void launchProviewAs(String launchingType)
	{
		getEle("browserApp").click();
		System.out.println("\nAction: ProView selected as : \t\tText: "+launchingType);
		threadWait(3);
	}

	public void clcikOnLaunchProviewBtn(String launchBtn)
	{
		getEle("launchButton").click();
		System.out.println("\nAction: The Button is clciked Namely: \t\tText: "+launchBtn);
		threadWait(5);
		sign.cookieTermsAcceptance();
	}

	public void clcikOnLaunchProviewBtns(String launchBtn)
	{
		getEle("launchButton").click();
		System.out.println("\nAction: The Button is clciked Namely: \t\tText: "+launchBtn);
		threadWait(5);
	}

	public void clcikOnLoginwithmyOnePassaccount(String onepass)
	{
		getEle("ipPersonalizedTrue").click();
		System.out.println("\nAction: The Link is clciked Namely: \t\tText: "+onepass);
		threadWait(3);
	}

	public WebElement getEle(String id){
		WebElement ele = null;

		for(int i=0;i<15;i++)
		{
			try{
				ele=driver.findElement(By.id(id));
				break;
			}
			catch(Exception e)
			{
				try {Thread.sleep(1000);} catch (InterruptedException e1) 
				{
					System.out.println("Waiting for element to appear on DOM");
				}
			}
		}
		return ele;
	}

	public void verifyTextIsPresent(String text)
	{
		Assert.assertTrue(text + ": This text is not displayed in current window.", driver.findElement(By.xpath("//localize[contains(text(),'"+text+"')]")).isDisplayed());
	}

	public void verifyButtonIsPresent(String text)
	{
		Assert.assertTrue(text + ": The text button is not displayed in current window.", driver.findElement(By.xpath("//input[@value='Visit Store']")).isDisplayed());
	}

	public void verifyLinkIsPresent(String text)
	{
		Assert.assertTrue(text + ": The text Link is not displayed in current window.", driver.findElement(By.xpath("//div[contains(text(),'"+text+"')]")).isDisplayed());
	}


	public WebElement getEleByXpath(){
		WebElement ele = null;

		for(int i=0;i<15;i++)
		{
			try{
				ele=driver.findElement(By.xpath("//input[@value='Visit Store']"));
				break;
			}
			catch(Exception e)
			{
				try {Thread.sleep(1000);} catch (InterruptedException e1) 
				{
					System.out.println("Waiting for element to appear on DOM");
				}
			}
		}
		return ele;
	}
	String Parent_Window ;
	public void clickOnEstoreBtn()
	{
		Parent_Window = driver.getWindowHandle();
		getEleByXpath().click();
	}

	public void verifyUrl()
	{
		for (String Child_Window : driver.getWindowHandles())  
		{  
			driver.switchTo().window(Child_Window);  
			System.out.println("Current window URL : " + driver.getCurrentUrl());  
			if(!Child_Window.equalsIgnoreCase(Parent_Window))
			{
				try {Thread.sleep(3000);} catch (InterruptedException e1) {};
				Assert.assertTrue("", driver.getCurrentUrl().contains("google.com"));
				driver.close();
			}
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();	}
		}  
		driver.switchTo().window(Parent_Window);
	}

	public void verifyDialogIsNotDisplayed()
	{
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();	}
		Assert.assertTrue("\"Visit Store\" button dialog is still displayed...", getEle("libraryViewOptionLibrary").isEnabled());
	}
}

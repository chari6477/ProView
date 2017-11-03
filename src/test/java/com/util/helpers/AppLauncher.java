package com.util.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.pages.SignIn;

public class AppLauncher extends DriverFactory
{
	WebDriver driver = getDriver();
	PropertyReader properties = new PropertyReader();
	SignIn signIn = new SignIn(driver);

	public AppLauncher(WebDriver driver)
	{
		this.driver = driver;
	}

	public void closeProView()
	{
		destroyDriver();

	}

	public void launchDeepLinking() throws InterruptedException
	{
		driver.get("https://proview.ci.thomsonreuters.com/launchapp/title/trp/periodical/auto_periodical/document/newsarticle-03/anchor/iblanchor");
		Thread.sleep(2500);
		try {
			signIn.clickWebElement(signIn.cookieContinueLink());
		} catch (Exception e) {
			System.out.println("Cookie Continue Link Not Present");
		}
	}

	public void launchFreemium() throws InterruptedException
	{
		driver.get(
				"https://proview.ci.thomsonreuters.com/title.html?freemium=true&titleId=trp/ereader/trialindexthesaurus/v1");
		Thread.sleep(2500);
	}

	public void launchFreemiumNon() throws InterruptedException
	{
		driver.get("https://proview.ci.thomsonreuters.com/title.html?freemium=true&titleId=trp/ereader/auto_pita/v1");
		Thread.sleep(2500);
	}

	public void launchIPAuthentication()
	{
		driver.get("https://proview.ci.thomsonreuters.com/library.html?sponsor=prTesting-DEV");
	}
	
	public void launchIPAuthenticationWithEmail()
	{
		driver.get("https://proview.ci.thomsonreuters.com/library.html?sponsor=prTesting-DEV&email=proviewtester@gmail.com");
	}

	public void launchIPPAuthentication()
	{
		driver.get("https://proview.ci.thomsonreuters.com/library.html?sponsor=PPETER-1");
	}

	public void launchProView() throws InterruptedException
	{
		Thread.sleep(1000);
		if((properties.readProperty("platform")) != ("windows"))
		{
			switch(properties.readProperty("Environment"))
			{
				
				case "CI" :
					driver.get(properties.readProperty("CI_URL"));
					break;
					
				case "QED":
					driver.get(properties.readProperty("QED"));
					break;
					
				case "DEMO":
					driver.get(properties.readProperty("DEMO"));
					break;
			
			}
			//driver.manage().window().setSize(new Dimension(1280, 1024));
			driver.manage().window().maximize();
	/*		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
			
			Thread.sleep(3000);*/

		}
		else
		{
			Thread.sleep(15000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#splashKinesis")));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#splashSpinner")));

			Thread.sleep(10000);

			driver.switchTo().defaultContent();
			WebElement mainframe = driver.findElement(By.xpath("//*[@id=\"mainframe\"]"));
			driver.switchTo().frame(mainframe);
		}
	}
}
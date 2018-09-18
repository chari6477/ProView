package com.util.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.util.helpers.BaseObject;

public class FileSaver extends BaseObject
{
	public FileSaver(WebDriver driver)
	{
		this.driver = driver;
	}

	Robot robot ;
	Screen screen = new Screen();
	public void saveFile() throws InterruptedException
	{
		if(System.getProperty("Browser").equals("chrome"))
		{
			System.out.println("chrome doesn't need to be manually saved");
		}

		if(System.getProperty("Browser").equals("IE")){
			try {
				Runtime.getRuntime().exec("src/test/resources/Download.exe");
			} catch (IOException e) {
				System.out.println("Exception Occured While Saving File");
			}	
		}

		if(System.getProperty("Browser").equals("firefox")){
			try {
				Runtime.getRuntime().exec("src/test/resources/Firefox_Download.exe");
			} catch (IOException e) {
				System.out.println("Exception Occured While Saving File");
			}

		}
	}
	
	public void savesFile() throws InterruptedException
	{
		if(System.getProperty("Browser").equals("chrome"))
		{
			System.out.println("chrome doesn't need to be manually saved");
		}

		if(System.getProperty("Browser").equals("IE")){
			Thread.sleep(5000);
			Pattern save = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\saveDoc.PNG");
			try {
				screen.click(save);	
			} catch (FindFailed e) {
				e.printStackTrace();
				System.err.println("Waiting for save button to be appear");
			}
			Thread.sleep(5000);
			
			Pattern view = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\closeBtnViewDownloads.PNG");
			try {
				screen.click(view);	
			} catch (FindFailed e) {
				e.printStackTrace();
				System.err.println("Waiting for view button to be appear");
			}
			Thread.sleep(5000);
			
		}

		if(System.getProperty("Browser").equals("firefox")){
			try {
				Runtime.getRuntime().exec("src/test/resources/Firefox_Download.exe");
			} catch (IOException e) {
				System.out.println("Exception Occured While Saving File");
			}

		}
	}

	public void savePDFfile() throws InterruptedException
	{
		if(System.getProperty("Browser").equals("chrome"))
		{
			System.out.println("chrome doesn't need to be manually saved");
		}

		if(System.getProperty("Browser").equals("IE")){
			/*try {
				Runtime.getRuntime().exec("src/test/resources/Download.exe");
			} catch (IOException e) {
				System.out.println("Exception Occured While Saving File");
			}*/
			
			Thread.sleep(2000);
			Pattern save = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\savePdf.PNG");
			try {
				screen.click(save);	
			} catch (FindFailed e) {
				e.printStackTrace();
				System.err.println("Waiting for save button to be appear");
			}
			Thread.sleep(1000);
		}
		
		if(System.getProperty("Browser").equals("firefox")){

			try {	Thread.sleep(4000);} catch (InterruptedException e) {	e.printStackTrace();}
			int i=1;
			String winName = null ;
			for (String handle1 : driver.getWindowHandles())
			{
				if(i==1)
				{
					i++;
					winName = handle1;
				}
				else
				{
					System.err.println("Window name : --> " + handle1);
					driver.switchTo().window(handle1);
					Actions action = new Actions(driver);
					action.moveToElement(driver.findElement(By.id("download"))).click().build().perform();
					try {	Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
					driver.switchTo().window(winName);
				}
			}

		}
	}
	
	public void savesPDFfile() throws InterruptedException
	{
		if(System.getProperty("Browser").equals("chrome"))
		{
			System.out.println("chrome doesn't need to be manually saved");
		}

		if(System.getProperty("Browser").equals("IE")){
			Thread.sleep(5000);
			Pattern save = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\saveDoc.PNG");
			try {
				screen.click(save);	
			} catch (FindFailed e) {
				e.printStackTrace();
				System.err.println("Waiting for save button to be appear");
			}
			Thread.sleep(5000);
			
			Pattern view = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\closeBtnViewDownloads.PNG");
			try {
				screen.click(view);	
			} catch (FindFailed e) {
				e.printStackTrace();
				System.err.println("Waiting for view button to be appear");
			}
			Thread.sleep(5000);
		}
		
		if(System.getProperty("Browser").equals("firefox")){

			try {	Thread.sleep(4000);} catch (InterruptedException e) {	e.printStackTrace();}
			int i=1;
			String winName = null ;
			for (String handle1 : driver.getWindowHandles())
			{
				if(i==1)
				{
					i++;
					winName = handle1;
				}
				else
				{
					System.err.println("Window name : --> " + handle1);
					driver.switchTo().window(handle1);
					Actions action = new Actions(driver);
					action.moveToElement(driver.findElement(By.id("download"))).click().build().perform();
					try {	Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
					driver.switchTo().window(winName);
				}
			}
		}
	}

	public void savePPTXfile()
	{
		if(System.getProperty("Browser").equals("chrome"))
		{
			System.out.println("chrome doesn't need to be manually saved");
		}

		if(System.getProperty("Browser").equals("IE")){
			try {
				Runtime.getRuntime().exec("src/test/resources/Download.exe");
			} catch (IOException e) {
				System.out.println("Exception Occured While Saving File");
			}
		}

		if(System.getProperty("Browser").equals("firefox")){

			try {	Thread.sleep(4000);} catch (InterruptedException e) {	e.printStackTrace();}
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				try {	Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void savesPPTXfile() throws InterruptedException
	{
		if(System.getProperty("Browser").equals("chrome"))
		{
			System.out.println("chrome doesn't need to be manually saved");
		}

		if(System.getProperty("Browser").equals("IE")){
			Thread.sleep(5000);
			Pattern save = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\saveDoc.PNG");
			try {
				screen.click(save);	
			} catch (FindFailed e) {
				e.printStackTrace();
				System.err.println("Waiting for save button to be appear");
			}
			Thread.sleep(5000);
			
			Pattern view = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\closeBtnViewDownloads.PNG");
			try {
				screen.click(view);	
			} catch (FindFailed e) {
				e.printStackTrace();
				System.err.println("Waiting for view button to be appear");
			}
			Thread.sleep(5000);
		}

		if(System.getProperty("Browser").equals("firefox")){

			try {	Thread.sleep(4000);} catch (InterruptedException e) {	e.printStackTrace();}
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				try {	Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void saveXLSXfile()
	{
		if(System.getProperty("Browser").equals("chrome"))
		{
			System.out.println("chrome doesn't need to be manually saved");
		}

		if(System.getProperty("Browser").equals("IE")){
			try {
				Runtime.getRuntime().exec("src/test/resources/Download.exe");
			} catch (IOException e) {
				System.out.println("Exception Occured While Saving File");
			}
		}

		if(System.getProperty("Browser").equals("firefox")){

			try {	Thread.sleep(4000);} catch (InterruptedException e) {	e.printStackTrace();}
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				try {	Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void savesXLSXfile() throws InterruptedException
	{
		if(System.getProperty("Browser").equals("chrome"))
		{
			System.out.println("chrome doesn't need to be manually saved");
		}

		if(System.getProperty("Browser").equals("IE")){
			Thread.sleep(5000);
			Pattern save = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\saveDoc.PNG");
			try {
				screen.click(save);	
			} catch (FindFailed e) {
				e.printStackTrace();
				System.err.println("Waiting for save button to be appear");
			}
			Thread.sleep(5000);
			
			Pattern view = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\closeBtnViewDownloads.PNG");
			try {
				screen.click(view);	
			} catch (FindFailed e) {
				e.printStackTrace();
				System.err.println("Waiting for view button to be appear");
			}
			Thread.sleep(5000);
		}

		if(System.getProperty("Browser").equals("firefox")){

			try {	Thread.sleep(4000);} catch (InterruptedException e) {	e.printStackTrace();}
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				try {	Thread.sleep(1000);} catch (InterruptedException e) {	e.printStackTrace();}
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}
}
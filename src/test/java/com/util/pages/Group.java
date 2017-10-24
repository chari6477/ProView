package com.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
/**
 * This class contains all <b>Page Objects</b> related to <b>Group</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class Group extends BaseObject
{
	private Library library;
	
	/**
	 * This method constructs the Object of <b>Group</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public Group(WebDriver driver)
	{
		this.driver = driver;
		library=new Library(driver);
	}
	
	/**
	 * This method creates WebElement object based on property given.
	 * @param groupName Should be any one of groups among the available groups.
	 * @return WebElement for the property named <b>Group_LinkToGroupMembers_XPATH</b>.
	 */
	public WebElement linkToGroupMembers(String groupName){
		return findWebElementFromPropertyName("Group_LinkToGroupMembers_XPATH", groupName);
	}
	
	/**
	 * Opens Group Panel of group which contains list of Titles in that group.
	 * @param groupName Should be any one of the groups among the available groups.
	 * @throws InterruptedException
	 */
	public void openGroupPanel(String groupName) throws InterruptedException
	{
		library.filterTitlesByText(groupName);
		threadWait(2);
		clickWebElementByActionsClass(linkToGroupMembers(groupName));
	}
	
	/**
	 * Opens Title from group of titles.
	 * @param titleName Should be any one of the title among the list of titles present in that particular group.
	 * @throws InterruptedException
	 */
	public void openTitleFromGroupPanel(String titleName) throws InterruptedException
	{
		threadWait(2);
		clickWebElementByActionsClass(library.titleWithOutSearching(titleName));
	}
}
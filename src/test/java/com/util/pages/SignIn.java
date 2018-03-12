package com.util.pages;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.helpers.BaseObject;
import com.util.helpers.EntitlementService;
/**
 * This class contains all <b>Page Objects</b> related to <b>SignIn</b> functionality of <b>ProView Browser Application</b> 
 * @author U6064272 - <b>Basha Shaik</b>
 *
 */
public class SignIn extends BaseObject
{
	EntitlementService entitlement = new EntitlementService();

	/**
	 * This method constructs the Object of <b>SignIn</b> class.
	 * @param driver WebDriver object comes from called method.
	 */
	public SignIn(WebDriver driver)
	{
		this.driver = driver;

	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>Cookie_ContinueLink_ID</b>.
	 */
	public WebElement cookieContinueLink(){
		return findWebElementFromPropertyName("Cookie_ContinueLink_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_UsernameTextFld_ID</b>.
	 */
	public WebElement usernameTextFld(){
		return findWebElementFromPropertyName("SignIn_UsernameTextFld_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_PasswordTextFld_ID</b>.
	 */
	public WebElement passwordTextFld(){
		return findWebElementFromPropertyName("SignIn_PasswordTextFld_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_SignInButton_ID</b>.
	 */
	public WebElement signInBtn(){
		return findWebElementFromPropertyName("SignIn_SignInButton_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_CheckOutCode_SignInBtn_XPATH</b>.
	 */
	public WebElement checkOutPageSignInBtn(){
		return findWebElementFromPropertyName("SignIn_CheckOutCode_SignInBtn_XPATH");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_UseCheckoutCode_XPATH</b>.
	 */
	public WebElement useCheckoutCode(){
		return findWebElementFromPropertyName("SignIn_UseCheckoutCode_XPATH"); 
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_CheckoutCodeTextFld_ID</b>.
	 */
	public WebElement checkoutCodeTextFld(){
		return findWebElementFromPropertyName("SignIn_CheckoutCodeTextFld_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_ProductImage_XPATH</b>.
	 */
	public WebElement productImg(){
		return findWebElementFromPropertyName("SignIn_ProductImage_XPATH");
	}

	public void cookieTermsAcceptance(){
		try {
			clickWebElement(cookieContinueLink());
		} catch (Exception e) {
		}
	}

	/**
	 * Performs the sign in action of ProView app
	 */
	public void signInAction(){
		try {
			enterText(usernameTextFld(), readProperty("SignIn_Username_TestData"));
			enterText(passwordTextFld(), readProperty("SignIn_Password_TestData"));
			clickWebElement(signInBtn());
			threadWait(10);
			if(!readProperty("platform").equals("IE"))
			{
				cookieTermsAcceptance();
			}
		}catch(Exception e)
		{
			try {
				cookieTermsAcceptance();
			}catch(Exception e1)
			{
			}
			System.out.println("Already Signed In...");
		}
	}

	/**
	 * Clicks on the "Use Checkout Code" link, generates a checkout code, and
	 * signs in using that checkout code.
	 * 
	 * @return Library object
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	public Library signInToProViewUsingCheckoutCode() throws ClientProtocolException, IOException, JSONException, InterruptedException
	{
		Thread.sleep(3000);
		clickWebElement(useCheckoutCode());
		driver.get("https://proview.qed.thomsonreuters.com/checkoutCode");
		String checkoutCode = entitlement.createEntitlementForNewAnonymousUser(readProperty("Environment"),
				readProperty("EntitlementAccountID"), readProperty("EntitlementResourceID"),
				readProperty("EntitlementExpirationDate"));
		/*PropertySetter propertySetter = new PropertySetter();
		propertySetter.setProperty("CheckoutCode", checkoutCode);*/

		enterText(checkoutCodeTextFld(), checkoutCode);
		clickWebElement(checkOutPageSignInBtn());
		return new Library(driver);
	}

	/**
	 * Verifies that the logo is displayed at the top of the sign in page
	 * @throws InterruptedException 
	 */
	public void verifyLogo()
	{
		waitForElementToBeClickable(productImg(), 30);
	}
}
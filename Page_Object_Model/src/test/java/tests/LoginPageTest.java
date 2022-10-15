package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

@Listeners(utility.Listeners.class)
public class LoginPageTest extends Base{
	
	/**
	 * Method to call the parent class
	 */
	public LoginPageTest() {
		super();
	}
	
	/**
	 * Method to initialize the driver
	 */
	@SuppressWarnings("static-access")
	@BeforeMethod
	public void triggerDriver() {
		try {
			utility.initializeDriver(properties.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "Data")
	public Object[][] dataTest() {
		data = new Object[1][2];
		data[0][0] = "onealpha946@gmail.com";
		data[0][1] = "Demo@98765";	
		return data;
	}
	
	/**
	 * Method to login using DataProvider
	 */
	@Test(dataProvider = "Data", priority = 1)
	public void loginUserDataProviderTest(String email, String pwd) throws InterruptedException {
		loginPage = new LoginPage();
		loginPage.loginUsingDataProvider(email, pwd);
		String homePageTitle = loginPage.verifyPageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
	}
	
	/**
	 * Method to login using data from property file
	 */
	@Test(priority = 2)
	public void loginUserPropertyFileTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		String homePageTitle = loginPage.verifyPageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
	}
	
	/**
	 * Method to login using data from excel sheet
	 */
	@Test(priority = 3)
	public void loginUserUsingXlsxTest() {
		loginPage = new LoginPage();
		loginPage.loginUserUsingXlsx();
		String homePageTitle = loginPage.verifyPageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
	}
	
	/**
	 * Method to validate invalid login credentials
	 */
	@Test(priority = 4)
	public void validateInvalidLoginCredTest() {
		loginPage = new LoginPage();
		message = loginPage.validateInvalidLoginCred();
		Assert.assertEquals(message, "The password that you've entered is incorrect. Forgotten password");
	}
	
	/**
	 * Method to terminate the driver
	 */
	@SuppressWarnings("static-access")
	@AfterMethod
	public void terminateDriver() {
		try {
			utility.closeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
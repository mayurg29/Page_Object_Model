package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class LoginPageTest extends Base{
	
	public LoginPageTest() {
		super();
	}
	
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
		data[0][0] = "sonar.mayuresh260197@gmail.com";
		data[0][1] = "Test@12345";	
		return data;
	}
	
	/**
	 * DataProvider method
	 */
	@Test(dataProvider = "Data", priority = 1)
	public void loginUserDataProviderTest(String email, String pwd) throws InterruptedException {
		loginPage = new LoginPage();
		loginPage.loginUsingDataProvider(email, pwd);
		String homePageTitle = loginPage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
	}
	
	@Test(priority = 2)
	public void loginUserPropertyFileTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		String homePageTitle = loginPage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
	}
	
	@Test(priority = 3)
	public void loginUserUsingXlsxTest() {
		loginPage = new LoginPage();
		loginPage.loginUserUsingXlsx();
		String homePageTitle = loginPage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
	}
	
	@Test(priority = 4)
	public void validateInvalidLoginCredTest() {
		loginPage = new LoginPage();
		message = loginPage.validateInvalidLoginCred();
		Assert.assertEquals(message, "The password that you've entered is incorrect. Forgotten password?");
	}
	
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
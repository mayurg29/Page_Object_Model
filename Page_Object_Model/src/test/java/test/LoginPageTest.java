package test;

import org.openqa.selenium.By;
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
		data[0][0] = "mayur@gmail.com";
		data[0][1] = "Pwd123456";	
		return data;
	}
	
	/**
	 * DataProvider method
	 */
	@Test(dataProvider = "Data", priority = 1)
	public void loginPage(String username, String password) {
		try {
			String url = properties.getProperty("baseURL");
			driver.get(url);
			Thread.sleep(1000);
			driver.findElement(By.id("email")).sendKeys(username);
			Thread.sleep(1000);
			driver.findElement(By.id("pass")).sendKeys(password);
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void loginUserPropertyFileTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		String loginPageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up");
	}
	
	@Test(priority = 3)
	public void loginUserUsingXlsxTest() {
		loginPage = new LoginPage();
		loginPage.loginUserUsingXlsx();
		String loginPageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up");
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
			Thread.sleep(1000);
			utility.closeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;

@Listeners(utility.Listeners.class)
public class HomePageTest extends Base{

	/**
	 * Method to call the parent class
	 */
	public HomePageTest() {
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
	
	/**
	 * Method to post an image
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1)
	public void postImageTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		homePage = new HomePage();
		homePage.postImage();
		String postTime = utility.verifyPostTime();
		Assert.assertEquals(postTime, "1 m");
	}
	
	/**
	 * Method to post status
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 2)
	public void postStatusTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		homePage = new HomePage();
		homePage.postStatus();
		String postTime = utility.verifyPostTime();
		Assert.assertEquals(postTime, "1 m");
	}
	
	/**
	 * Method to post a video
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 3)
	public void postVideoTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		homePage = new HomePage();
		homePage.postVideo();
		String postTime = utility.verifyPostTime();
		Assert.assertEquals(postTime, "1 m");
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
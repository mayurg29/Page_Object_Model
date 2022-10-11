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

	public HomePageTest() {
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
	
	/**
	 * Method to post an image
	 */
	@SuppressWarnings("static-access")
	@Test
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
	@Test
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
	@Test
	public void postVideoTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		homePage = new HomePage();
		homePage.postVideo();
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

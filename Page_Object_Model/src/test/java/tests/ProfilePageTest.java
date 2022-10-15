package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;
import pages.ProfilePage;

@Listeners(utility.Listeners.class)
public class ProfilePageTest extends Base{
	
	/**
	 * Method to call the parent class
	 */
	public ProfilePageTest() {
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
	 * Method to upload profile picture
	 */
	@Test(priority = 1)
	public void uploadProfilePicTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		profilePage = new ProfilePage();
		profilePage.uploadProfilePic();
	}
	
	/**
	 * Method to add cover picture
	 */
	@Test(priority = 5)
	public void addCoverPicTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		profilePage = new ProfilePage();
		profilePage.addCoverPic();
	}
	
	/**
	 * Method to remove cover picture
	 */
	@Test(priority = 4)
	public void removeCoverPicTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		profilePage = new ProfilePage();
		profilePage.removeCoverPic();
	}
	
	/**
	 * Method to like recent post
	 */
	@Test(priority = 2)
	public void likePostTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		profilePage = new ProfilePage();
		profilePage.likePost();
	}
	
	/**
	 * Method to comment on recent post
	 */
	@Test(priority = 3)
	public void commentOnPostTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		profilePage = new ProfilePage();
		profilePage.commentOnPost();
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
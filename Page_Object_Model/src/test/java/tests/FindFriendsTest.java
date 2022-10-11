package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pages.FindFriendsPage;
import pages.LoginPage;

@Listeners(utility.Listeners.class)
public class FindFriendsTest extends Base{

	public FindFriendsTest() {
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
	 * Method to traverse to "All friends" page & validating "All friends" page title
	 */
	@Test
	public void findFriendsTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		findFriendsPage = new FindFriendsPage();
		findFriendsPage.findFriends();
		String findFriendsTitle = driver.getTitle();
		Assert.assertEquals(findFriendsTitle, "All Friends | Facebook");
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

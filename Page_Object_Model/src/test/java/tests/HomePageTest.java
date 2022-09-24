package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;

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
	
	@Test
	public void uploadProfilePicTest() {
		HomePage homePage = new HomePage();
		homePage.uploadProfilePic();
	}
	
	@Test
	public void postImageTest() {
		HomePage homePage = new HomePage();
		homePage.postImage();
	}
	
	@Test
	public void postStatusTest() {
		HomePage homePage = new HomePage();
		homePage.postStatus();
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

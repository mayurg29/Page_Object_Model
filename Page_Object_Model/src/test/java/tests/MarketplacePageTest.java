package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;
import pages.MarketplacePage;

@Listeners(utility.Listeners.class)
public class MarketplacePageTest extends Base{

	public MarketplacePageTest() {
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
	 * Method to search in marketplace
	 */
	@Test
	public void searchMarketplaceTest() {
		loginPage = new LoginPage();
		loginPage.loginUserPropertyFile();
		marketplacePage = new MarketplacePage();
		marketplacePage.searchMarketplace();
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

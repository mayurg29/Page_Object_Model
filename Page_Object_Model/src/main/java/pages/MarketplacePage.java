package pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class MarketplacePage extends Base{

	@FindBy(xpath = "//a[@aria-label='Marketplace']")
	private WebElement marketPlace;

	@FindBy(xpath = "(//input[@aria-label='Search Marketplace'])[1]")
	private WebElement searchMarketplace;
	
	@FindBy(xpath = "//span[contains(text(),'Sporting goods')]")
	private WebElement sportingGoods;

	public MarketplacePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to search in marketplace
	 */
	@SuppressWarnings("static-access")
	public void searchMarketplace() {
		try {
			utility.click(driver, 10, marketPlace);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", sportingGoods);
			utility.click(driver, 10, sportingGoods);
			Thread.sleep(2000);
			
			utility.sendKeys(driver, 10, searchMarketplace, "mobile");
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
}

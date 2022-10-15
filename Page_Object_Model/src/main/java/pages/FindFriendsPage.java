package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class FindFriendsPage extends Base{

	@FindBy(xpath = "//span[contains(text(),'Find Friends')]")
	private WebElement findFriends;

	@FindBy(xpath = "//span[contains(text(),'All Friends')]")
	private WebElement allFriends;

	@FindBy(xpath = "//input[@placeholder='Search Friends']")
	private WebElement searchFriends;

	public FindFriendsPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Traversing to All friends
	 */
	@SuppressWarnings("static-access")
	public void findFriends() {
		try {
			utility.click(driver, 10, findFriends);
			utility.click(driver, 10, allFriends);
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
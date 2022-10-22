package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Base;

public class HomePage extends Base{

	@FindBy(xpath = "//a[@aria-label='Home']")
	private WebElement homeBtn;

	@FindBy(xpath = "//span[contains(text(),'Photo/video')]")
	private WebElement createPost;

	@FindBy(xpath = "//span[contains(text(),'Add photos/videos')]")
	private WebElement addPhotoVideo;

	@FindBy(xpath = "//span[contains(text(),'Post')]")
	private WebElement postBtn;

	@FindBy(xpath = "//span[contains(text(),\"What's on your mind, Max?\")]")
	private WebElement postStatus;

	@FindBy(xpath = "//div[contains(text(),\"What's on your mind, Max?\")]")
	private WebElement statusMsg;
	
	@FindBy(xpath = "(//span[contains(text(),'Max Demo')])[1]")
	private WebElement profileBtn;
	
	@FindBy(xpath = "//a[@aria-label='Notifications, 1 unread']")
	private WebElement notifications;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to post an image
	 */
	@SuppressWarnings("static-access")
	public void postImage() {
		try {
			utility.click(driver, 10, homeBtn);
			utility.click(driver, 10, createPost);
			utility.click(driver, 10, addPhotoVideo);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\AutoItPhoto.exe").waitFor(10, TimeUnit.SECONDS);
			utility.click(driver, 10, postBtn);
			Thread.sleep(10000);
			utility.click(driver, 10, profileBtn);
			Thread.sleep(4000);
			driver.navigate().refresh();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to post status
	 */
	@SuppressWarnings("static-access")
	public void postStatus() {
		try {
			utility.click(driver, 10, homeBtn);
			utility.click(driver, 10, postStatus);
			Actions actions = new Actions(driver);
			actions.sendKeys(statusMsg, "Believe in yourself.").perform();
			utility.click(driver, 10, postBtn);
			Thread.sleep(4000);
			utility.click(driver, 10, profileBtn);
			Thread.sleep(4000);
			driver.navigate().refresh();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to post a video
	 */
	@SuppressWarnings("static-access")
	public void postVideo() {
		try {
			utility.click(driver, 10, homeBtn);
			utility.click(driver, 10, createPost);
			utility.click(driver, 10, addPhotoVideo);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\AutoItVideo.exe").waitFor(10, TimeUnit.SECONDS);
			utility.click(driver, 10, postBtn);
			Thread.sleep(6000);
			utility.click(driver, 10, profileBtn);
			utility.click(driver, 30, notifications);
			Thread.sleep(4000);
			driver.navigate().refresh();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
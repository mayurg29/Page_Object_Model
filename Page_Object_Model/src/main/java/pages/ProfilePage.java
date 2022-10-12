package pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;

public class ProfilePage extends Base{

	@FindBy(xpath = "//a[@aria-label='Bridgelabz Demo']")
	private WebElement profileBtn;

	@FindBy(xpath = "//div[@aria-label='Update profile picture']")
	private WebElement updateProfilePic;

	@FindBy(xpath = "//div[@aria-label='Upload Photo']")
	private WebElement uploadPhoto;

	@FindBy(xpath = "//div[@aria-label='Save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Add Cover Photo')]")
	private WebElement addCoverPhoto;
	
	@FindBy(xpath = "//span[contains(text(),'Edit Cover Photo')]")
	private WebElement editCoverPhoto;

	@FindBy(xpath = "//span[contains(text(),'Upload photo')]")
	private WebElement uploadCoverPhoto;
	
	@FindBy(xpath = "//span[contains(text(),'Remove')]")
	private WebElement removeCoverPhoto;
	
	@FindBy(xpath = "(//span[contains(text(),'Save changes')])[2]")
	private WebElement saveChanges;
	
	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	private WebElement confirm;
	
	@FindBy(xpath = "(//span[contains(text(),'Like')])[1]")
	private WebElement likeBtn;
	
	@FindBy(xpath = "(//span[contains(text(),'Comment')])[1]")
	private WebElement commentBtn;
	
	@FindBy(xpath = "(//div[@aria-label='Write a comment'])[1]")
	private WebElement writeComment;
	
	@FindBy(xpath = "(//span[contains(text(),'Like')])[1][@style='color: rgb(32, 120, 244);']")
	private WebElement liked;
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to upload profile picture
	 */
	@SuppressWarnings("static-access")
	public void uploadProfilePic() {
		try {
			utility.click(driver, 10, profileBtn);
			utility.click(driver, 10, updateProfilePic);
			utility.click(driver, 10, uploadPhoto);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\AutoItFB.exe").waitFor(10, TimeUnit.SECONDS);
			utility.click(driver, 10, saveBtn);
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to add cover picture
	 */
	@SuppressWarnings("static-access")
	public void addCoverPic() {
		try {
			utility.click(driver, 10, profileBtn);
			utility.click(driver, 10, addCoverPhoto);
			utility.click(driver, 10, uploadCoverPhoto);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\AutoItCover.exe").waitFor(10, TimeUnit.SECONDS);
			utility.click(driver, 10, saveChanges);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methhod to remove cover picture
	 */
	@SuppressWarnings("static-access")
	public void removeCoverPic() {
		try {
			utility.click(driver, 10, profileBtn);
			utility.click(driver, 10, editCoverPhoto);
			utility.click(driver, 10, removeCoverPhoto);
			utility.click(driver, 10, confirm);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to like recent post
	 */
	@SuppressWarnings("static-access")
	public void likePost() {
		try {
			utility.click(driver, 10, profileBtn);
			actions = new Actions(driver);
			String key = likeBtn.getAttribute("style");
			switch (key) {
			case "color: rgb(32, 120, 244);":
				actions.moveToElement(liked).perform();
				logger.warn("******Post is already liked******");
				break;
				
			default:
				utility.click(driver, 10, likeBtn);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to comment on recent post
	 */
	@SuppressWarnings("static-access")
	public void commentOnPost() {
		try {
			utility.click(driver, 10, profileBtn);
			String randomString = RandomStringUtils.randomAlphabetic(10);
			System.out.println("Random String: " + randomString);
			utility.sendKeys(driver, 10, writeComment, randomString);
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			String comment = profilePage.getComment();
			Assert.assertEquals(comment, randomString);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method to get recent comment on recent post
	 */
	public String getComment() {
		String comment = driver.findElement(By.xpath("(//ul)[2]/li[last()]/div/div/div/div/div/div/div/div/div/span/div/div")).getText();
		System.out.println("Comment: " + comment);
		return comment;
	}
}
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

	@FindBy(xpath = "//a[@aria-label='Bridgelabz Demo']")
	private WebElement profileBtn;

	@FindBy(xpath = "//div[@aria-label='Update profile picture']")
	private WebElement updateProfilePic;

	@FindBy(xpath = "//div[@aria-label='Upload Photo']")
	private WebElement uploadPhoto;

	@FindBy(xpath = "//div[@aria-label='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[contains(text(),'Photo/video')]")
	private WebElement createPost;

	@FindBy(xpath = "//div[@class='om3e55n1 g4tp4svg bdao358l alzwoclg cqf1kptm jez8cy9q gvxzyvdx pytsy3co']")
	private WebElement addPhotoVideo;

	@FindBy(xpath = "//span[contains(text(),'Post')]")
	private WebElement postBtn;

	@FindBy(xpath = "//span[contains(text(),\"What's on your mind, Bridgelabz?\")]")
	private WebElement postStatus;

	@FindBy(xpath = "//div[contains(text(),\"What's on your mind, Bridgelabz?\")]")
	private WebElement statusMsg;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@SuppressWarnings("static-access")
	public void uploadProfilePic() {
		try {
			loginPage = new LoginPage();
			loginPage.loginUserPropertyFile();
			utility.click(driver, 10, profileBtn);
			utility.click(driver, 10, updateProfilePic);
			utility.click(driver, 10, uploadPhoto);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\AutoItFB.exe").waitFor(10, TimeUnit.SECONDS);
			utility.click(driver, 10, saveBtn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public void postImage() {
		try {
			loginPage = new LoginPage();
			loginPage.loginUserPropertyFile();
			utility.click(driver, 10, homeBtn);
			utility.click(driver, 10, createPost);
			utility.click(driver, 10, addPhotoVideo);
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\AutoItPhoto.exe").waitFor(10, TimeUnit.SECONDS);
			utility.click(driver, 10, postBtn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public void postStatus() {
		try {
			loginPage = new LoginPage();
			loginPage.loginUserPropertyFile();
			utility.click(driver, 10, homeBtn);
			utility.click(driver, 10, postStatus);
			Actions actions = new Actions(driver);
			actions.sendKeys(statusMsg, "Believe in yourself.").perform();
			utility.click(driver, 10, postBtn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

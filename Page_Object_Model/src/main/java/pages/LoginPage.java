package pages;

import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class LoginPage extends Base{
	
	@FindBy(id = "email")
	private WebElement emailId;
	
	@FindBy(id = "pass")
	private WebElement password;
	
	@FindBy(name = "login")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='_9ay7']")
	private WebElement errorMsg;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@SuppressWarnings("static-access")
	public void loginUsingDataProvider(String email, String pwd) {
		try {
			String url = properties.getProperty("baseURL");
			driver.get(url);
			utility.sendKeys(driver, 10, emailId, email);
			utility.sendKeys(driver, 10, password, pwd);
			utility.click(driver, 5, loginBtn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public void loginUserPropertyFile() {
		try {
			String url = properties.getProperty("baseURL");
			driver.get(url);
			utility.sendKeys(driver, 10, emailId, properties.getProperty("emailId"));
			utility.sendKeys(driver, 10, password, properties.getProperty("password"));
			utility.click(driver, 5, loginBtn);
			System.out.println("Username from property file: " + properties.getProperty("emailId"));
			System.out.println("Password from property file: " + properties.getProperty("password"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public void loginUserUsingXlsx() {
		try {
			List<List<String>> values = new LinkedList<>();
			values.addAll(utility.excelReader());
			
			String url = properties.getProperty("baseURL");
			driver.get(url);
			utility.sendKeys(driver, 10, emailId, values.get(0).get(0));
			utility.sendKeys(driver, 10, password, values.get(0).get(1));
			utility.click(driver, 5, loginBtn);
			System.out.println("Username from excel file: " + values.get(0).get(0));
			System.out.println("Password from excel file: " + values.get(0).get(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public String validateInvalidLoginCred() {
		try {
			List<List<String>> values = new LinkedList<>();
			values.addAll(utility.excelReader());
			
			String url = properties.getProperty("baseURL");
			driver.get(url);
			utility.sendKeys(driver, 10, emailId, values.get(1).get(0));
			utility.sendKeys(driver, 10, password, values.get(1).get(1));
			utility.click(driver, 5, loginBtn);
			message = errorMsg.getText();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String verifyHomePageTitle() { 
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Facebook"));
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}
}

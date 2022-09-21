package pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void loginUserPropertyFile() {
		try {
			String url = properties.getProperty("baseURL");
			driver.get(url);
			Thread.sleep(1000);
			emailId.sendKeys(properties.getProperty("emailId"));
			Thread.sleep(1000);
			password.sendKeys(properties.getProperty("password"));
			Thread.sleep(1000);
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
			driver.findElement(By.id("email")).sendKeys(values.get(0).get(0));
			Thread.sleep(1000);
			driver.findElement(By.id("pass")).sendKeys(values.get(0).get(1));
			Thread.sleep(1000);
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
			driver.findElement(By.id("email")).sendKeys(values.get(0).get(0));
			Thread.sleep(1000);
			driver.findElement(By.id("pass")).sendKeys(values.get(0).get(1));
			Thread.sleep(1000);
			loginBtn.click();
			message = errorMsg.getText();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String verifyLoginPageTitle() { 
		String loginPageTitle = driver.getTitle();
		return loginPageTitle;
	}
}

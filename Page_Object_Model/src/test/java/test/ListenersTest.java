package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.Base;

public class ListenersTest extends Base{

//	Failed test
	@Test
	public void OpenBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String expectedTitle = "Facebook";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}
	
//	Success test
	@Test
	public void closeBrowser() {
		driver.close();
		System.out.println("Driver Closed After Testing");
	}
	
//	Skip test
	@Test
	public void SkipTest() {
		throw new SkipException("Skipping The Test Method ");
	}
}

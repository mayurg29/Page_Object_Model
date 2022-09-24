package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

/**
 * @author Mayur Gotad
 *
 */
public class Utility extends Base{
	
	/**
	 * Method to initialize the driver
	 */
	public static void initializeDriver(String browser) {
		try {
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new EdgeDriver();
			}
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Parameterized send keys method
	 */
	public static void sendKeys(WebDriver driver, int timeout, WebElement element, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	/**
	 * Parameterized click method
	 */
	public static void click(WebDriver driver, int timeout, WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	/**
	 * Method to read data from excel file
	 */
	public static List<List<String>> excelReader() throws IOException {
		
		List<List<String>> values = new LinkedList<List<String>>();
		File file = new File(FILE_PATH);
		fileInputStream = new FileInputStream(file);
		xWorkbook = new XSSFWorkbook(fileInputStream);
		xSheet = xWorkbook.getSheet("LoginData");
		
		int rowCount = xSheet.getLastRowNum();
		
		for (int i = 1; i <= rowCount; i++) {
			int cellCount = xSheet.getRow(i).getLastCellNum();
			List<String> val = new LinkedList<>();
			
			for (int j = 0; j < cellCount; j++) {
				val.add(xSheet.getRow(i).getCell(j).getStringCellValue());
			}
			values.add(val);
		}
		return values;
	}
	
	/**
	 * Method to take screenshot
	 */
	public static void takeScreenshot() {
		try {
			String date = new Date().toString().replaceAll(":", "_");
			System.out.println("Date is: " + date);
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir") + "\\screenshot\\" + date + "failed.png");
			FileUtils.copyFile(srcFile, destFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to close the driver
	 */
	public static void closeDriver() {
		try {
			Thread.sleep(4000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utility.Utility;

public class Base {

	protected static WebDriver driver;
	protected static WebElement element;
	protected static FileInputStream fileInputStream;
	protected static FileInputStream excelFile;
	protected static Properties properties;
	protected static Utility utility;
	protected static XSSFWorkbook xWorkbook;
	protected static XSSFSheet xSheet;
	protected static XSSFCell xCell;
	protected static XSSFRow xRow;
	protected static Object[][] data;
	
	protected static LoginPage loginPage;
	protected static String message;
	
	protected final static String FILE_PATH = System.getProperty("user.dir") + 
											  "\\src\\main\\resources\\repository\\LoginTestData.xlsx";
	
	static {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + 
													"\\src\\main\\resources\\drivers\\msedgedriver.exe");
	}
	
	public Base() {
		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir") + 
												  "\\src\\main\\resources\\repository\\config.properties");
			properties = new Properties();
			properties.load(fileInputStream);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

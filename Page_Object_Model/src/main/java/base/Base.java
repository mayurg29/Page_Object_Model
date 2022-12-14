package base;

import java.awt.Robot;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FindFriendsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MarketplacePage;
import pages.ProfilePage;
import utility.LoggerExample;
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
	protected static Robot robot;
	protected static String message;
	protected static Actions actions; 
	
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static ProfilePage profilePage;
	protected static MarketplacePage marketplacePage;
	protected static FindFriendsPage findFriendsPage;
	
	protected static Logger logger = Logger.getLogger(LoggerExample.class.getName());

	protected final static String FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\LoginTestData.xlsx";
	
	static {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\msedgedriver.exe");
	}
	
	public Base() {
		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\config.properties");
			properties = new Properties();
			properties.load(fileInputStream);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

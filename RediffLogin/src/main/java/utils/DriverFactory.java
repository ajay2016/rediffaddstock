package utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import pageObjects.AddStockToPortfolio_Page;
import pageObjects.BasePage;


public class DriverFactory {
	public static WebDriver driver ;
	public static BasePage basePage ;
	public static AddStockToPortfolio_Page addstocktoportfolioPage;
	

	@SuppressWarnings("deprecation")
	public static WebDriver getDriver() throws Exception {
		try {
			/*ReadConfigfile file = new ReadConfigfile();
			// System.out.println("****************");
			String browserName = file.getBrowser();*/
			// System.out.println(browserName);
			// String browserName= "chrome";
			Properties prop = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\Config.properties");
			prop.load(fi);
			String browserName = prop.getProperty("browserName") ;
			
			switch (browserName) {

			// firefox setup
			case "firefox":
				if (null == driver) {
					 System.setProperty("webdriver.gecko.drive",Constant.GECKO_DRIVER_DIRECTORY);
					 System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
					FirefoxOptions capabilities = new FirefoxOptions();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			// chrome setup
			case "chrome":
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					ChromeOptions options = new ChromeOptions();
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
				}
				break;

			// IE setup
			case "ie":
				if (null == driver) {
					DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
					// System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
					caps.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver(caps);
					driver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser! - Exception: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			/*We should initialize page objects using initElements() method from PageFactory Class as below, 
			 * Once we call initElements() method, 
			 * all elements will get initialized. PageFactory.initElements() 
			 * static method takes the driver instance of the given class and the class type, 
			 * and returns a Page Object with its fields fully initialized.*/
			//Created page object using page factory
		    addstocktoportfolioPage = PageFactory.initElements(driver, AddStockToPortfolio_Page.class);			
			basePage = PageFactory.initElements(driver,BasePage.class);
			
		}
		return driver;
	}
}

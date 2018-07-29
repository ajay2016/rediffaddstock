package stepdefinitions;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverFactory;

public class MasterHooks extends DriverFactory {

	@Before
	public void setup() throws Exception {
		driver = getDriver();

	}

	@After
	public void closeBrowserAndScreenshotOnFailure(Scenario scenario) {

		try {

			if (driver != null && scenario.isFailed()) {
				/*
				 * String screenshotName = scenario.getName().replaceAll(" ", "_"); File
				 * sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 * 
				 * // Building up the destination path for the screenshot to save // Also make
				 * sure to create a folder 'screenshots' with in the cucumber-report // folder
				 * File destinationPath = new File(System.getProperty("user.dir") +
				 * "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				 * 
				 * // Copy taken screenshot from source location to destination location
				 * Files.copy(sourcePath, destinationPath);
				 * 
				 * // This attach the specified screenshot to the test
				 * Reporter.addScreenCaptureFromPath(destinationPath.toString());
				 * 
				 * 
				 */

				/*final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");*/
				scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
				//To embed image in cucumber extent reports
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String screenshotName = "failshot";
				File destinationPath = new File("D:\\eclipseRepo\\ContactAndProduct\\target\\cucumber-extents\\" + screenshotName + ".png"); 
				FileUtils.copyFile(sourcePath, destinationPath); 				
				Reporter.addScreenCaptureFromPath("D:\\eclipseRepo\\ContactAndProduct\\target\\cucumber-extents\\"+screenshotName+".png");
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Method failed: closeBrowserAndScreenshotOnFailure, exception" + e.getMessage());
		}
	}

}

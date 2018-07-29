package stepdefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class AddStockToPortfolio extends DriverFactory {

	/*WebDriver driver;
	String browser = "Chrome";

	@Before
	// browser set up
	public void setup() {
		if (browser.equals("Mozilla")) {
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			driver = new FirefoxDriver();

		} else if (browser.equals("Chrome")) {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
			driver = new ChromeDriver();

		} else if (browser.equals("IE")) {
			System.setProperty(InternetExplorerDriver.LOG_FILE, "null");
			driver = new InternetExplorerDriver();

		} else if (browser.equals("Edge")) {
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "null");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

	}

	@After
	public void closeBrowser() {
		driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;

	}
*/
	@Given("^User access rediff\\.com website$")
	public void user_access_rediff_com_website() throws Throwable {
		//driver.get("http://in.rediff.com/");
	addstocktoportfolioPage.getRediffWebsite();

	}

	@Given("^User clicks on Money link$")
	public void user_clicks_on_Money_link() throws Throwable {
		//driver.findElement(By.xpath("//*[@id='homewrapper']/div[5]/a[3]/div/u")).click();
		addstocktoportfolioPage.clickMoneyLink();

	}

	@Given("^User clicks on Sign in link$")
	public void user_clicks_on_Sign_in_link() throws Throwable {
		//driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
		addstocktoportfolioPage.clickSigninLink();

	}

	@Given("^User enters valid username$")
	public void user_enters_valid_username() throws Throwable {
		//driver.findElement(By.id("useremail")).sendKeys("ashishthakur1983");
		addstocktoportfolioPage.enterUsername();

	}

	@Given("^User clicks on email submit button$")
	public void user_clicks_on_email_submit_button() throws Throwable {
		//driver.findElement(By.id("emailsubmit")).click();
		addstocktoportfolioPage.clickEmailSubmitButton();

	}

	@Given("^User enters valid password$")
	public void user_enters_valid_password() throws Throwable {
		// Explicit wait until password field is visible
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userpass"))));
		// enter valid password
		//driver.findElement(By.id("userpass")).sendKeys("pass@1234");
		addstocktoportfolioPage.enterPassword();
	}

	@When("^User clicks on Enter button$")
	public void user_clicks_on_Enter_button() throws Throwable {
		//driver.findElement(By.id("userpass")).sendKeys(Keys.ENTER);
		addstocktoportfolioPage.clickLoginSubmit();

	}

	@Then("^Username should be displayed on the page$")
	public void username_should_be_displayed_on_the_page() throws Throwable {
		//Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		//waitForPageToLoad();
		//boolean result = isElementPresent("//*[@id='username']/a");
		//System.out.println(result);
		//Assert.assertTrue(result, "Not able to login");
		addstocktoportfolioPage.confirmUserLoggedin();

	}

	@When("^User selects portfolio to add stock$")
	public void user_selects_portfolio_to_add_stock() throws Throwable {
		// select portfolio to add stock
		//Thread.sleep(5000);
		//WebElement e = driver.findElement(By.id("portfolioid"));
		//Select s = new Select(e);
		//s.selectByVisibleText("Ashi_29");
		addstocktoportfolioPage.selectPortfolio();

	}

	@When("^User clicks on add stock$")
	public void user_clicks_on_add_stock() throws Throwable {
	//	waitForPageToLoad();
		// click on add stock
		//driver.findElement(By.id("addStock")).click();
		addstocktoportfolioPage.clickAddStockButton();

	}

	@When("^User enters stock name$")
	public void user_enters_stock_name() throws Throwable {
		// enter stock name
		//driver.findElement(By.id("addstockname")).sendKeys("Tata Steel Ltd");
		//Thread.sleep(5000L);
		//driver.findElement(By.xpath("//div[text()='Tata Steel Ltd.']")).click();
		addstocktoportfolioPage.enterStockName();

	}

	@When("^User selects stock purchase date from the calendar$")
	public void user_selects_stock_purchase_date_from_the_calendar() throws Throwable {
		// Select stock purchase date from the calendar
		//driver.findElement(By.id("stockPurchaseDate")).click();
		//selectDate("12/04/2017");
		addstocktoportfolioPage.clickDateOfPurchaseCalender();

	}

	@When("^User enters quantity$")
	public void user_enters_quantity() throws Throwable {
		// Enter stock quantity
		//driver.findElement(By.id("addstockqty")).sendKeys("100");
		addstocktoportfolioPage.enterStockQuantity();

	}

	@When("^User enters purchase price$")
	public void user_enters_purchase_price() throws Throwable {
		// Enter stock purchase price
		//driver.findElement(By.id("addstockprice")).sendKeys("500");
		addstocktoportfolioPage.enterPurchasePrice();

	}

	@When("^User Clicks on add stock button$")
	public void user_Clicks_on_add_stock_button() throws Throwable {
		// click on add stock button
		//driver.findElement(By.id("addStockButton")).click();
		
		addstocktoportfolioPage.clickAddStock();

	}

	@Then("^Stock name should be added to the list$")
	public void stock_name_should_be_added_to_the_list() throws Throwable {
		//waitForPageToLoad();
		//int rNum = getRowWithCellData("Tata Steel Ltd.");
		//System.out.println("Row " + rNum);
		//if (rNum == -1)
		//	Assert.fail("Could not find the Stock");
		addstocktoportfolioPage.verifyStockNameTable();

	}

	/* All the methods used */
	// checking if element is present using size()
	/*public boolean isElementPresent(String xpathExp) {
		int s = driver.findElements(By.xpath(xpathExp)).size();
		if (s == 0)
			return false;
		else
			return true;
	}

	public void wait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i = 0;

		while (i != 10) {
			String state = (String) js.executeScript("return document.readyState;");
			System.out.println(state);

			if (state.equals("complete"))
				break;
			else
				wait(2);

			i++;
		}
		wait(2);// wait of 2 sec between page status and jquery
		// check for jquery status
		i = 0;
		while (i != 10) {

			Boolean result = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
			System.out.println(result);
			if (result)
				break;
			else
				wait(2);
			i++;

		}

	}

	public void selectDate(String d) {
		// day, month , year
		Date current = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date selected = sd.parse(d);
			String day = new SimpleDateFormat("dd").format(selected);
			String month = new SimpleDateFormat("MMMM").format(selected);
			String year = new SimpleDateFormat("yyyy").format(selected);
			System.out.println(day + " --- " + month + " --- " + year);
			String desiredMonthYear = month + " " + year;

			while (true) {
				String displayedMonthYear = driver.findElement(By.cssSelector(".dpTitleText")).getText();
				if (desiredMonthYear.equals(displayedMonthYear)) {
					// select the day
					driver.findElement(By.xpath("//td[text()='" + day + "']")).click();
					break;
				} else {

					if (selected.compareTo(current) > 0)
						driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
					else if (selected.compareTo(current) < 0)
						driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();

				}
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getRowWithCellData(String data) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='stock']/tbody/tr"));
		for (int rNum = 0; rNum < rows.size(); rNum++) {
			WebElement row = rows.get(rNum);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (int cNum = 0; cNum < cells.size(); cNum++) {
				WebElement cell = cells.get(cNum);
				if (!cell.getText().trim().equals("") && data.contains(cell.getText()))
					return ++rNum;
			}
		}

		return -1;// not found
	}
*/
}

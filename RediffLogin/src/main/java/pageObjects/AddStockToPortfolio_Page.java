package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddStockToPortfolio_Page extends BasePage {

	// Elements for AddStockToPortfolio_Page

	public @FindBy(xpath = "//*[@id='homewrapper']/div[5]/a[3]/div/u") WebElement link_Money;
	public @FindBy(xpath = "//*[@id='signin_info']/a[1]") WebElement link_Signin;
	public @FindBy(id = "useremail") WebElement textfield_Username;
	public @FindBy(id = "emailsubmit") WebElement button_EmailSubmit;
	public @FindBy(id = "userpass") WebElement textfield_Password;
	public @FindBy(id = "loginsubmit") WebElement button_LoginSubmit;
	public @FindBy(xpath = "//*[@id='username']/a") WebElement UsernameDiplayed;
	public @FindBy(id = "portfolioid") WebElement select_Portfolio;
	public @FindBy(id = "addStock") WebElement button_AddStock;
	public @FindBy(id = "addstockname") WebElement textfield_StockName;
	public @FindBy(xpath = "//div[text()='Tata Steel Ltd.']") WebElement StocknameDiplayed;
	public @FindBy(id = "stockPurchaseDate") WebElement calendar_DateOfPurchase;
	public @FindBy(id = "addstockqty") WebElement textfield_StockQuantity;
	public @FindBy(id = "addstockprice") WebElement textfield_PurchasePrice;
	public @FindBy(id = "addstockprice") WebElement button_AddStockButton;

	
	public AddStockToPortfolio_Page() throws IOException {
		super();

	}

	/* Methods for Contact us page using base page and driver factory */

	public AddStockToPortfolio_Page getRediffWebsite() throws Exception {
		// getDriver().get("http://in.rediff.com/");
		loadUrl("http://in.rediff.com/");
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page clickMoneyLink() throws Exception {
		waitAndClickElement(link_Money);
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page clickSigninLink() throws Exception {
		waitAndClickElement(link_Signin);
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page enterUsername() throws Exception {
		sendKeysToWebElement(textfield_Username, "ashishthakur1983");
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page clickEmailSubmitButton() throws Exception {
		waitAndClickElement(button_EmailSubmit);
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page enterPassword() throws Exception {
		sendKeysToWebElement(textfield_Password, "pass@1234");
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page clickLoginSubmit() throws Exception {
		waitAndClickElement(button_LoginSubmit);
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page confirmUserLoggedin() throws Exception {
		waitForPageToLoad();
		boolean result = isElementPresent("//*[@id='username']/a");
		System.out.println(result);
		Assert.assertTrue(result, "Not able to login");
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page selectPortfolio() throws Exception {
		waitForPageToLoad();
		// WebElement select_Portfolio = getDriver().findElement(By.id("portfolioid"));
		Select s = new Select(select_Portfolio);
		s.selectByVisibleText("Ashi_29");
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page clickAddStockButton() throws Exception {
		waitAndClickElement(button_AddStock);
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page enterStockName() throws Exception {
		sendKeysToWebElement(textfield_StockName, "Tata Steel Ltd");
		waitForPageToLoad();
		waitAndClickElement(StocknameDiplayed);
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page clickDateOfPurchaseCalender() throws Exception {
		waitAndClickElement(calendar_DateOfPurchase);
		selectDate("30/12/2018");
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page enterStockQuantity() throws Exception {
		sendKeysToWebElement(textfield_StockQuantity, "100");
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page enterPurchasePrice() throws Exception {
		sendKeysToWebElement(textfield_PurchasePrice, "500");
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page clickAddStock() throws Exception {
		waitAndClickElement(button_AddStockButton);
		return new AddStockToPortfolio_Page();
	}

	public AddStockToPortfolio_Page verifyStockNameTable() throws Exception {
		waitForPageToLoad();
		int rNum = getRowWithCellData("Tata Steel Ltd.");
		System.out.println("Added stockname is in the Row: " + rNum);
		if (rNum == -1)
			Assert.fail("Could not find the Stock");
		return new AddStockToPortfolio_Page();
	}
}

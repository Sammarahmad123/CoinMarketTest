package StepDefinations.test1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;

public class Test2 {
	WebDriver driver;

	@Given("I navigate to the URL")
	public void i_navigate_to_the_URL() {
		String path = "C:\\Users\\sammara\\eclipse-workspace\\CoinMarketTest\\src\\main\\resources\\chromedriver.exe";
		String URL = "https://coinmarketcap.com/";
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@And("add few random cryptocurrencies to wish list")
	public void add_few_random_cryptocurrencies_to_wish_list() throws InterruptedException {
		List<WebElement> rows = driver.findElements(By.xpath(
				"//table[@class=\"cmc-table cmc-table___11lFC cmc-table-homepage___2_guh\"]//span[@class=\"icon-Star\"]"));

		System.out.println("Size:" + rows.size());
		if (driver.findElement(By.className("cmc-cookie-policy-banner__close")).isDisplayed()) {
			driver.findElement(By.className("cmc-cookie-policy-banner__close")).click();
		}
		for (int i = 0; i <= 7; i++) {
			Thread.sleep(2000);
			rows.get(i).click();
		}

	}

	@And("open wish list in a new tab")
	public void open_wish_list_in_a_new_tab() {
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.linkText("Watchlist")).sendKeys(selectLinkOpeninNewTab);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	@Then("verify the added cryptocurrencies should be displayed")
	@Test
	public void verify_the_added_cryptocurrencies_should_be_displayed() {
		List<WebElement> addedRows = driver.findElements(By.className("icon-Star-Filled"));
		System.out.println("Added Cyrptos size:" + addedRows.size());
		assertEquals(addedRows.size(), 8);

	}

	@And("Closing the browser")
	public void closing_the_browser() {
		driver.close();
	}

}

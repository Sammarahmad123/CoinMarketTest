package StepDefinations.test1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;

public class Test1 {
	WebDriver driver;
	int rowCount;
	int colCount;

	@Given("I navigate to the given URL")
	public void i_navigate_to_the_given_URL() {
		String path = "C:\\Users\\sammara\\eclipse-workspace\\CoinMarketTest\\src\\main\\resources\\chromedriver.exe";
		String URL = "https://coinmarketcap.com/";
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@And("count number of rows")
	public void count_number_of_rows() {
		List<WebElement> rows = driver.findElements(
				By.xpath("//table[@class=\"cmc-table cmc-table___11lFC cmc-table-homepage___2_guh\"]/tbody/tr"));
		rowCount = rows.size();
		System.out.println("ROW COUNT : " + rowCount);
	}

	@Then("verify them to be hundred rows")
	@Test
	public void verify_them_to_be_hundred_rows() {
		assertEquals(rowCount, 101);
	}

	@And("close the browser")
	public void close_the_browser() {
		driver.close();
	}

	@And("count number of columns")
	public void count_number_of_columns() {
		List<WebElement> cols = driver.findElements(
				By.xpath("//table[@class=\"cmc-table cmc-table___11lFC cmc-table-homepage___2_guh\"]/thead/tr/th"));
		colCount = cols.size();
		System.out.println("Column COUNT : " + colCount);
	}

	@Then("verify them")
	@Test
	public void verify_them() {
		assertEquals(colCount, 11);
	}

}

package StepDefinations.test1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class Test3 {
	WebDriver driver;
	@Given("I open the URL")
	public void i_open_the_URL() {
		String path = "C:\\Users\\sammara\\eclipse-workspace\\CoinMarketTest\\src\\main\\resources\\chromedriver.exe";
		String URL = "https://coinmarketcap.com/";
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@And("Hoover on the Cryptocurrencies Tab")
	public void hoover_on_the_Cryptocurrencies_Tab() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("(//button[text() = 'Cryptocurrencies'])[1]"));
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("(//button[text() = 'Cryptocurrencies'])[1]"))).click().build().perform();
	}
	
}

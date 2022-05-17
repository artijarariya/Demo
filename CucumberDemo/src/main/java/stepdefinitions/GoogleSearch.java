package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch {

	WebDriver driver;

	@Given("browser is open")
	public void browser_open() {
		System.out.println("Browser is opening");

		String projectPath = System.getProperty("user.dir");
		System.out.println("project path is " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@Given("user is on google search page")
	public void search_page() {
		System.out.println("User is in google search page");

		driver.navigate().to("https://www.google.com/");
	}

	@When("user enters a text in search box")
	public void search_box() throws InterruptedException {
		System.out.println("User enter a test in search page");
		driver.findElement(By.name("q")).sendKeys("Iphone");
		Thread.sleep(2000);
	}

	@When("hits enter")
	public void hit_enter() throws InterruptedException {
		System.out.println(" user hit enter");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("user is navigated to search results")
	public void search_results() {
		System.out.println("user navigate to search results");
		driver.getPageSource().contains("Iphone-Apple Official Site");

		driver.close();
		driver.quit();
	}

}

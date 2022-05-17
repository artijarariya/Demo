package hooksstepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HooksSteps {

	WebDriver driver = null;

	@Before(order = 1)
	public void browserSetup() {
		System.out.println("Browser setup");
		String projectPath = System.getProperty("user.dir");
		System.out.println("project path is " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}

	@After
	public void teardown() {
		System.out.println("After hooks");
		driver.close();
		driver.quit();
	}

	// @After(order=1)
	// public void teardown2()
	// {
	// System.out.println("After 2 hooks");
	// driver.close();
	// driver.quit();
	// }
	@Before(order = 0)
	public void setup2() {
		System.out.println(" i am inside setup2");
	}

	@BeforeStep
	public void beforeSteps() {
		System.out.println(" i am inside Before steps");
	}

	@AfterStep
	public void afterSteps() {
		System.out.println(" i am inside After steps");
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("user is in login,,,,");
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
		System.out.println("user is in login1,,,,");
	}

	@When("click on login button")
	public void click_on_login_button() {
		System.out.println("user is in login2,,,,");
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
		System.out.println("user is in login3,,,,");
	}
}

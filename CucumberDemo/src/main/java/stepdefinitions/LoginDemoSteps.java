package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDemoSteps {
	WebDriver driver;

	@Given("browser is opening")
	public void browser_is_open() {
		System.out.println("Browser is opening");

		String projectPath = System.getProperty("user.dir");
		System.out.println("project path is " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		
		
	}
	@And("user on login page")
	public void login_page() throws InterruptedException {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		//driver.findElement(By.id("txtUsername")).sendKeys("");
		Thread.sleep(2000);
	}
	@When("^user enters (.*) and(.*)$")
	public void enter_credential(String username,String password) throws InterruptedException {
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
	}
	@Then("user click login")
	public void click_login() {
		driver.findElement(By.id("btnLogin")).click();
		
		driver.close();
		driver.quit();
	}
	
	
	
	
}

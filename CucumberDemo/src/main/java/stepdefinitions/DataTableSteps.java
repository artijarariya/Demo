package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSteps {
	WebDriver driver;
	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("Browser is opening");

		String projectPath = System.getProperty("user.dir");
		System.out.println("project path is " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	}
	@When("user navigate to login page")
	public void user_navigate_to_login_page() throws InterruptedException {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		//driver.findElement(By.id("txtUsername")).sendKeys("");
		Thread.sleep(2000);
	}
	@When("user enters credentials to login")
	public void user_enters_credentials_to_login(io.cucumber.datatable.DataTable usercredentials) {
		List<List<String>> data = usercredentials.asLists();
		driver.findElement(By.id("txtUsername")).sendKeys(data.get(0).get(0)); 
	    driver.findElement(By.id("txtPassword")).sendKeys(data.get(0).get(1));
	    driver.findElement(By.id("btnLogin")).click();
	    
	}
	@Then("meassage displayed login succesfully")
	public void meassage_displayed_login_succesfully() {
	    System.out.println("login Succsfull");
	}
}

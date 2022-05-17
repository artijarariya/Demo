package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	
	@Given("user is on login page$")
	public void verifyLoginPage() {
	    
	   System.out.println("User is in login page");
	   String projectPath = System.getProperty("user.dir");
		System.out.println("project path is " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	   
	   
	}

	@When("enters username and password")
	public void enterCredential() {
		System.out.println("User enter the credentials ");
		loginpom lg =new loginpom(driver);
            LoginSteps dm=new LoginSteps();
            dm.verifyLoginPage();
            lg.enterLoginDetails("admin","admin123");
     
        }

	@And("clicks on login button")
	public void clickOnButton() {
		loginpom lg =new loginpom(driver);
		System.out.println("Clicks on login buttonPage");
		
		lg.clickOnLogin();
	}

	@Then("user is navigated home page")
	public void homePage() {
	   
		System.out.println("User is navigated to Home Page");
	}

	
	
	
	

}

package pagestepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Assign_Leave_Page;
import pages.Home_Page;
import pages.Login_Page;

public class PageFactoryLogin {

	WebDriver driver=null;
	Login_Page lp;
	Home_Page hm;
	Assign_Leave_Page as;

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
		// driver.findElement(By.id("txtUsername")).sendKeys("");
		Thread.sleep(2000);
	}

	@When("^user enters (.*) and(.*)$")
	public void enter_credential(String username, String password) throws InterruptedException {
        lp=new Login_Page(driver);
		lp.enterUsername(username);
		lp.enterpassword(password);
		Thread.sleep(2000);
	}

	@Then("user click login")
	public void click_login() {
		lp.clickOnLogin();
		
	}
	@Then("user is in home Page")
	public void user_is_in_home_page() throws InterruptedException {
	    hm=new Home_Page(driver);
	    hm.checkAssignLeaveIsDisplayed();
	    Thread.sleep(4000);
	    
	}
	@Then("user is in assign leave page")
	public void user_is_in_assign_leave_page() throws InterruptedException {
		
		as=new Assign_Leave_Page(driver);
		as.enterEmpName();
		Thread.sleep(4000);
		driver.close();
		driver.quit();
		//Thread.sleep(4000);
	}


}

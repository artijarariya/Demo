package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pom {

	WebDriver driver;
	private WebElement username;
	private WebElement password;
	private WebElement loginBtn;

	public pom(WebDriver driver) {
		this.driver = driver;
		username = driver.findElement(By.id("txtUsername"));
		password = driver.findElement(By.id("txtPassword"));
		loginBtn = driver.findElement(By.name("Submit"));
	}

	public void enterUsername(String usernameValue) {
		username.sendKeys(usernameValue);

	}

	public void enterPassword(String passwordValue) {
		password.sendKeys(passwordValue);

	}

	public void clickOnLogin() {
		loginBtn.click();

	}

	public void enterLoginDetails(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
	}

}

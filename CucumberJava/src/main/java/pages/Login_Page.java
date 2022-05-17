package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	@FindBy(name="txtUsername")
	WebElement  txt_username;
	
	@FindBy(id="txtPassword")
	WebElement txt_password;
	
	@FindBy(id="btnLogin")
	WebElement btn_login;
	
	WebDriver driver;
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterUsername(String username)
	{
		txt_username.sendKeys(username);
	}
	
	public void enterpassword(String password)
	{
		txt_password.sendKeys(password);
	}
	public void clickOnLogin()
	{
		btn_login.click();
	}
	
}

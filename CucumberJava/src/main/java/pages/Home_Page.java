package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	@FindBy(linkText="Assign Leave")
	WebElement btn_assign;
	
	WebDriver driver=null;
	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void checkAssignLeaveIsDisplayed()
	{
		btn_assign.click();
	}
}

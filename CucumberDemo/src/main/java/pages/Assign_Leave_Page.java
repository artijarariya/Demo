package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Assign_Leave_Page {

	@FindBy(className="ac_input")
	WebElement txt_empName;
	
	WebDriver driver;
	public Assign_Leave_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterEmpName()
	{
		txt_empName.sendKeys("Arti");
	}
}

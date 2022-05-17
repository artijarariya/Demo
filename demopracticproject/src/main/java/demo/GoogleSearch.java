package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
        
	static WebDriver driver;
	public static void main(String[] args) {

        
		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectpath+"/driver/chromedriver.exe");
		driver = new ChromeDriver();
        driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Iphone");
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).sendKeys(Keys.RETURN);
		driver.close();

	}
}	
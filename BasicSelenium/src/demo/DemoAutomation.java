package demo;

import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAutomation {
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", ".\\harddriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}

}

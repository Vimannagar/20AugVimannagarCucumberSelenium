package qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
public static WebDriver driver;
	


	public WebDriver initDriver(String browser)
	{
		
		if(browser.equals("Chrome"))
		{
			 driver = new ChromeDriver();
		}

		else if(browser.equals("Firefox"))
		{
			 driver = new FirefoxDriver();
		}
		
		else
		{
			System.out.println("Please check the name of browser");
		}
		
		
		
			return driver;
	}
	
	
	
	public static WebDriver getDriver()
	{
		
		return driver;
	}

	
	
}

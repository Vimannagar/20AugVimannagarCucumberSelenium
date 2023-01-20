package parallel;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.factory.DriverFactory;
import qa.util.ReadProperty;

public class AppHooks {

	ReadProperty readproperty;
	
	DriverFactory driverfactory; 
	
	WebDriver driver;
	
	
	@Before
	public void launchBrowser()
	{
		readproperty = new ReadProperty();
		String url = readproperty.readConfig("testsiteurl");
		
		driverfactory = new DriverFactory();
		
		String browservalue = readproperty.readConfig("browsername");
		
		driver = driverfactory.initDriver(browservalue);
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
	}
	
	@After
	public void quitBrowser()
	{
		driver.quit();
	}
	
	
	
	@After
	public void tearDown(Scenario scenario)
	{
		
		if(scenario.isFailed())
		{
			
		}
		
	}
}

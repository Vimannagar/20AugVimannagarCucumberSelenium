package parallel;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		
		driver.manage().window().maximize();
		
	}
	
	@After(order = 0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	
	
	@After(order = 1)
	public void tearDown(Scenario scenario)
	{
		
		if(scenario.isFailed())
		{
			String scenarioname = scenario.getName();
			
			String scrname = scenarioname.replaceAll(" ", "_");
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			byte[] sourcepath = ts.getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcepath, "image/png", scrname);
			
			
			
		}
		
	}
}

package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		plugin = {"pretty"},
		features = {"src/test/resources/parallel"},
		
		glue = {"parallel"}
		
		
		
		)




public class RunCucumberTest extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel = false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	

}

package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failedrun.txt"
		
		},
//		features = {"src/test/resources/parallel"},
		
		features = {"@target/failedrun.txt"},
		
		glue = {"parallel"}
		
		
		
		)




public class AmazonRunnerTest extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel = false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	

}

package parallel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import qa.factory.DriverFactory;

public class LoginSteps {

	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	static String title;
	
	@Given("user is at the login page")
	public void user_is_at_the_login_page() {
	   
	WebDriver driver = DriverFactory.getDriver();
	
	driver.get("https://www.amazon.in/");
		
	}

	@When("user gets the title of page")
	public void user_gets_the_title_of_page() {
	   
		 title = loginpage.getTitleOfPage();
		
		System.out.println(title);
	}

	@Then("page should contain {string}")
	public void page_should_contain(String string) {
	    
		boolean ispresent = title.contains(string);
		
		Assert.assertTrue(ispresent);
	}

	@Then("order link should get display")
	public void order_link_should_get_display() {
	  boolean isdisplayed = loginpage.isElementDisplay();
	  
	  Assert.assertEquals(isdisplayed, true);
	}

	@When("user enters the username as {string}")
	public void user_enters_the_username_as(String string) {
	  
		loginpage.enterUsername(string);
	}

	@When("user enters the password as {string}")
	public void user_enters_the_password_as(String string) {
	    loginpage.enterPassword(string);
	}

	@When("user click on signin button")
	public void user_click_on_signin_button() {
	    loginpage.clickOnSignIn();
	}

	
}

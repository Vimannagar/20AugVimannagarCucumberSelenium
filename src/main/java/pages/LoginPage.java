package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	WebElement hoverelement;

	@FindBy(xpath = "//*[@id='nav-orders']")
	WebElement returnorderlink;
		
	private	By signinhover = By.xpath("//*[@id='nav-flyout-ya-signin']//*[@class='nav-action-button']");

	private	By mobilenumber = By.xpath("//*[@id='ap_email']");

	private	By continueformobile = By.xpath("//*[@type='submit']");

	private	By password = By.xpath("//*[@id='ap_password']");

	private	By finalsignin = By.xpath("//*[@id='signInSubmit']");
		
		
		public LoginPage(WebDriver driver)
		{
			this.driver = driver;
			
			PageFactory.initElements(driver, this);
		}
		
		
		public void enterUsername(String usname)
		{
			Actions act = new Actions(driver);
								
			act.moveToElement(hoverelement).perform();
			
			driver.findElement(signinhover).click();
			
			driver.findElement(mobilenumber).sendKeys(usname);
			
			driver.findElement(continueformobile).click();
				
		}
		
		public void enterPassword(String pwd)
		{
			driver.findElement(password).sendKeys(pwd);
			
			
		}
		
		public void clickOnSignIn()
		{
			driver.findElement(finalsignin).click();
		}
		
		
		public String getTitleOfPage()
		{
			String titleofpage = driver.getTitle();
			
			System.out.println(titleofpage);
			
			return titleofpage;
		
		}
		
		public boolean isElementDisplay()
		{
			boolean isdisp = returnorderlink.isDisplayed();
			
			return isdisp;
			
		}
		
	

}

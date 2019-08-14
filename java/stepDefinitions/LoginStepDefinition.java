package stepDefinitions;

import java.io.File;
import java.util.Random;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	
	static WebDriver driver;
	static String browsername="chrome";
	
	
	@Given("^user is already on login page$")
	public void user_is_already_on_login_page(){
		System.setProperty("webdriver.chrome.driver", "D:\\Kavitha\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
			driver.get("https://login.xero.com/");	
	}
	
	@When("^user enters username and enters password$")
	public void user_enters_username_and_enters_password() throws Throwable {
	   driver.findElement(By.name("userName")).sendKeys("wintertest1408@gmail.com"); 
	   driver.findElement(By.name("password")).sendKeys("Password1"); 
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		driver.findElement(By.id("submitButton")).click();
	   
	   
	}

	@Then("^user is on Account Dashboard$")
	public void user_is_on_Account_Dashboard() throws Throwable {
	    String actualtitle =driver.getTitle();
		Assert.assertEquals("Xero | Dashboard | Winter Org", actualtitle);;
	   
	}
	
	@And("^user clicks on Connect your bank accounts link$")
    public void user_clicks_on_connect_your_bank_accounts_link() throws Throwable {
		Thread.sleep(3000);		
        driver.findElement(By.linkText("Connect your bank accounts")).click();
        Thread.sleep(3000);
        
	}
	
	@And("^user enters Bank Account details$")
    public void user_enters_Bank_Account_details() throws Throwable {        
        driver.findElement(By.id("xui-searchfield-1018-inputEl")).sendKeys("ANZ");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='dataview-1025']/li")).click();        
        Random ra=new Random();
		int num =ra.nextInt(2000);
		String accname="firstname"+String.valueOf(num);
		Thread.sleep(4000);
		Actions action=new Actions(driver);
		action.click(driver.findElement(By.xpath("//input[@role='combobox']"))).sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.name("accountname-1037-inputEl")).sendKeys(accname);
		Thread.sleep(4000);		
		int accnum =ra.nextInt(20000);
         action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(String.valueOf(accnum)).build().perform(); 
		Thread.sleep(4000);  
	}
		
	@And("^user clicks on Continue$")
    public void user_clicks_on_Continue() throws Throwable {		
	    
	     driver.findElement(By.id("common-button-submit-1015")).click();
	     Thread.sleep(6000);	     
	 //#    String value =driver.findElement(By.xpath("//*[@id='bankaccounts-root']/div/main/div/div/div[1]/div/div/div[2]")).getText();
	   //#  Assert.assertEquals(accnum, value);
	//#     driver.findElement(By.xpath("//*[@id='bankaccounts-root']/div/main/footer/a/span")).click();
	     Thread.sleep(3000);
	     
	}
	     
	@And("^user is on Dashboard$")
    public void user_is_on_Dashboard() throws Throwable {  
	    
	     driver.findElement(By.linkText("Dashboard")).click();
	     File fi =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fi, new File("D:\\m1.png"));
		driver.close();
		
    }


	
	
	
	

}

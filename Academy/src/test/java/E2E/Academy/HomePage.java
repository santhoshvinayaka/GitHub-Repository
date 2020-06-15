package E2E.Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.forgotPassword;
import Resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
	}

@Test(dataProvider = "getInfo")
	
	public void basePageNavigation(String username, String password) throws IOException
	{
		//one is inheritance
		//creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		forgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
		//System.out.println(text);
		Log.info("Successfully Logged in");
		
		
	}
		
		@DataProvider
		public Object[][] getInfo()
		{
			//row stands for how many different data types test should run
			//column stands for how many values for each test
			Object[][] data= new Object[2][2];
			data[0][0] = "nonrestricteduser@qw.com";
			data[0][1] = "123456";
			//data[0][2] = "Restricted user";
			
			data[1][0] = "restricteduser@qw.com";
			data[1][1] = "456788";
			//data[1][2] = "Non restricted user";
			
			return data;
		}
		
		@AfterTest
		public void tearDown()
		{
			driver.close();
		}
		

}

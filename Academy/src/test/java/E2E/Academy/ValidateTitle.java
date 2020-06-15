package E2E.Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.base;

public class ValidateTitle extends base{
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = InitializeDriver();
		Log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to homepage");
	}

@Test
	
	public void basePageNavigation() throws IOException
	{
		//one is inheritance
		//creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		Log.info("Successfully Validated Text message");
		
		
		
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
		
		
		

}

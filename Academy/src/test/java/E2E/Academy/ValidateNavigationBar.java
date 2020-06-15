package E2E.Academy;

import static org.testng.Assert.assertTrue;

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

	public class ValidateNavigationBar extends base{
		public WebDriver driver;
		public static Logger Log = LogManager.getLogger(base.class.getName());
		@BeforeTest
		public void initialize() throws IOException
		{
			driver = InitializeDriver();
			driver.get(prop.getProperty("url"));
		}
@Test
	
	public void basePageNavigation() throws IOException
	{
		//one is inheritance
		//creating object to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.navBar().isDisplayed());
		Log.info("Navigation bar is displayed");
		
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
		
}

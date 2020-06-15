package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By Signin = By.xpath("//a[@href='http://qaclickacademy.usefedora.com/sign_in']");
	By title = By.xpath("//div/h2[text()='Featured Courses']");
	By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage getLogin()
	{
		 driver.findElement(Signin).click();
		 LoginPage lp = new LoginPage(driver);
		 return lp;
		
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
		
	}
	
	public WebElement navBar()
	{
		return driver.findElement(navbar);
		
	}
	
	}



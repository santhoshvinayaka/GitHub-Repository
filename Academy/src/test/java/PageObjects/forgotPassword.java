package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPassword {
	
	public WebDriver driver;
	By email = By.xpath("//input[@id='user_email']");
	By sendInstructions = By.xpath("//input[@type='submit']");


	
	public forgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement sendMeInstructions()
	{
		return driver.findElement(sendInstructions);
		
	}
	
	
	
	}



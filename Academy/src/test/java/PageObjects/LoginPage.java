package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	By email = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By login = By.xpath("//input[@type='submit']");
	By forgotPw = By.xpath("//center/a[text()='Forgot Password?']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
		
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
		
	}
	
	public PageObjects.forgotPassword forgotPassword()
	{
		driver.findElement(forgotPw).click();
		return new forgotPassword(driver);
		
	}
	
	}



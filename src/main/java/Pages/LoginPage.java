package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;

public class LoginPage {
	
	public static WebDriver driver;
	public CommonUtils com=new CommonUtils();
	public LoginPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	
	}
	
	
	
	/*
	 * 
	 * Elements
	 */
	
	@FindBy(id="input-username")
	public WebElement Username_field;
	
	@FindBy(id="input-password")
	public  WebElement password_field;
	
	@FindBy(css=".text-right > .btn-primary")
	public  WebElement loginButton;
	
	
	
	/*
	 * 
	 * Functions
	 */
	
	public void logintodashboard(String username, String pass) throws InterruptedException {
		
		Username_field.sendKeys(username);
		password_field.sendKeys(pass);
		com.SleepinSeconds(2);
		loginButton.click();
		com.SleepinSeconds(15);
		
	}

}

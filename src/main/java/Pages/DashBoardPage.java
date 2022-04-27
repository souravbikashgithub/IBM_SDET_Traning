package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;

public class DashBoardPage {
	
	public WebDriver driver;
	public Actions action;
	public CommonUtils com=new CommonUtils();
	public DashBoardPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	/*
	 * 
	 * Elements
	 */

	
	@FindBy(css="#column-left > #menu >li:nth-child(8) > .parent")
	public WebElement ShareIcon_Menu;
	
	@FindBy(css="#column-left > #menu >li:nth-child(8) > ul > li:nth-child(3) a")
	public WebElement CupponOption;
	
	
	/***
	 * 
	 * Functions
	 * @throws InterruptedException 
	 */
	
public void HovertheShareIConandClickOnCupon() throws InterruptedException {
	
	action= new Actions(driver);
	action.moveToElement(ShareIcon_Menu).build().perform();
	com.SleepinSeconds(2);
	CupponOption.click();
	com.SleepinSeconds(5);
	
}
}

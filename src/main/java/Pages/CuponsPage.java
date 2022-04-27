package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;

public class CuponsPage {
	
	public WebDriver driver;
	public Actions action;
	public CommonUtils com=new CommonUtils();
	public CuponsPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
/***
 * 
 * Elements
 */
	
	
	@FindBy(css="#content .pull-right > a")
	public WebElement AddCupponButton;
	
	@FindBy(id="input-name")
	public WebElement CuponName;
	
	@FindBy(id="input-code")
	public WebElement CuponCode;
	
	@FindBy(css=".fa-save")
	public WebElement SaveButton;
	
	
	
	/***
	 * 
	 * 
	 * Functions
	 * @throws InterruptedException 
	 */
	
	
	public void ClickOnAddButton() throws InterruptedException {
		
		AddCupponButton.click();
		com.SleepinSeconds(4);
	}
	
	public void FillCuponDetails(String CuponName_data ) throws InterruptedException {
		
		CuponName.sendKeys(CuponName_data);
		CuponCode.sendKeys("Code"+String.valueOf(System.currentTimeMillis()).substring(6,10));
		SaveButton.click();
		com.SleepinSeconds(7);
	}
}

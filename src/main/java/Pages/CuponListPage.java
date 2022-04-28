package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Utils.CommonUtils;

public class CuponListPage {
	
	public WebDriver driver;
	public Actions action;
	public CommonUtils com=new CommonUtils();
	public CuponListPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	/***
	 * 
	 * Elements
	 * 
	 */

	
	@FindBys(@FindBy(css=".table-responsive > .table-bordered > tbody > tr"))
	public List<WebElement> totalRow;
	
	@FindBy(id="input-name")
	public WebElement CuponName;
	
	@FindBy(css=".fa-save")
	public WebElement SaveButton;
	
	@FindBys(@FindBy(css=".pagination li"))
	public List<WebElement> pagenition;
	
	
	/*
	 * 
	 * Functions
	 */
	
	public void FindtheCuponNameFromListAndClickEdit(String CuponName) throws InterruptedException {
		
		for(int i=1;i<=totalRow.size();i++) {
			String val=driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr["+ i + "]/td[2]")).getText();
			System.out.println(">>>>>>CouponNameFound:"+val);
			if(driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr["+ i + "]/td[2]")).getText().contentEquals(CuponName)) {
				
				driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr["+ i + "]/td[8]/a")).click();
				com.SleepinSeconds(4);
				System.out.println("Click on Edit Button Successful!!");
				break;
				
			}
			
			while(i==totalRow.size()) {
				
				
for(int j=1;j<=pagenition.size();j++) {
	
					try {
						System.out.println("Pagenation Character:"+driver.findElement(By.xpath("//*[@class='panel-body']/div/div[1]/ul/li["+ j +"]/a")).getText());
					if(driver.findElement(By.xpath("//*[@class='panel-body']/div/div[1]/ul/li["+ j +"]/a")).getText().contentEquals(">")) {
						
						driver.findElement(By.xpath("//*[@class='panel-body']/div/div[1]/ul/li["+ j +"]/a")).click();
						com.SleepinSeconds(4);
						
						FindtheCuponNameFromListAndClickEdit(CuponName);
					}}
	catch(Exception e) {}
				}
			}
			
		}
	}
	
	public void UpdateNameandVerify() throws InterruptedException {
		String UpdatedName="SouravMOD"+String.valueOf(System.currentTimeMillis());
		CuponName.clear();
		CuponName.sendKeys(UpdatedName);
		SaveButton.click();
		com.SleepinSeconds(4);
for(int i=1;i<=totalRow.size();i++) {
			
			if(driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr["+ i +"]/td[2]")).getText().contentEquals(UpdatedName)) {
				
				Assert.assertTrue(true);
				System.out.println("Verification is Sucessfull for Modified Name");
				
				break;
			}
			
		}
		
	}
}

package Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;







public class Start_Browser {
	
	
	public static WebDriver Open_Browser() {
		
		System.setProperty("webdriver.chrome.driver",".//ChromeDriver//chromedriver.exe");
		
	WebDriver driver = new ChromeDriver();
	
	driver.get(Static_data.Data.URL);
	driver.manage().window().maximize();
	
	return driver;
		
	}

}

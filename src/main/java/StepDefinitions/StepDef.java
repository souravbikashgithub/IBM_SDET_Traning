package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Base.Start_Browser;
import Pages.CuponListPage;
import Pages.CuponsPage;
import Pages.DashBoardPage;
import Pages.LoginPage;
import Static_data.Data;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef {
	
	public WebDriver driver;
	public LoginPage Lp; 
	public DashBoardPage dp;
	public CuponsPage cp;
	public CuponListPage Clp;
	public String CuponName_data="SouravAutomation"+String.valueOf(System.currentTimeMillis()).substring(6,10);
	
	
		
		public StepDef() {
			
			
			this.driver=Start_Browser.Open_Browser();
			Lp= new LoginPage(driver);
			dp= new DashBoardPage(driver);
			cp= new CuponsPage(driver);
			Clp= new CuponListPage(driver);
			
			
		}

		
		

		@Given("User wants to login to dashBoard")
        public void user_wants_to_login_to_dash_board() throws InterruptedException {
		
           Lp.logintodashboard(Data.Username,Data.password);
	   
	}

 @Then("User hover the Share ICon from Menu and Click on Cupon Link")
 public void Cupon_option_click() throws InterruptedException {
	 dp.HovertheShareIConandClickOnCupon();
	 
	 
 }

 @Then("User Added a Cuppon details")
 public void FillNewCuponDetails() throws InterruptedException{
	 
	 cp.ClickOnAddButton();
	 cp.FillCuponDetails(CuponName_data);
	 
	 
 }
 
 @Then("Verify the Added Cuppon present in List and Click on Edit")
 public void EditCuppon() throws InterruptedException {
	 
	Clp.FindtheCuponNameFromListAndClickEdit(CuponName_data);
	
 }
 @And("User Update the Cupon Name and Verify in the list")
 public void updateCupon() throws InterruptedException {
	 
	 Clp.UpdateNameandVerify();
	 
 }
	
}

package testCases;

import org.testng.annotations.Test;
import pageObjects.*;
import utilities.DataProviders;

public class TC003_InvalidLogin extends TC002_UsedCars{
	
	@Test(dataProvider="InvalidEmail",dataProviderClass=DataProviders.class ,groups={"regression","sanity"})
	public void TC003_InvalidLogin_Message(String email) throws InterruptedException {
		
		LoginPage lp_obj=new LoginPage(driver);
		
		//NAVIGATING BACK TO THE HOME PAGE
		lp_obj.goBackHome();
		
		HomePage hp_obj=new HomePage(driver);
		
		//CLICK ON LOGIN 
		hp_obj.login();
		
		
		Thread.sleep(3000);
		//CHOOSE GOOGLE OPTION 
		lp_obj.chooseGoogle();
		
		//INPUT THE EMAIL ID
		lp_obj.inputEmail(email);
		
		//GET THE ERROR MESSAGE
		System.out.println(lp_obj.getErrorMsg());
		
		
		
	}

}

package testCases;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.*;
import utilities.ExcelUtility;



public class TC002_UsedCars extends TC001_UpcomingBikes {
	@Test(groups = {"regression"})
	public void TC002_UsedCarsDetails() throws IOException, InterruptedException {
		UsedCarsPage uc_obj=new UsedCarsPage(driver);
		
		//FROM USED CARS OPTION CHOOSE CHENNAI
		uc_obj.chooseChennai();
		
		
		//GETTING THE LIST OF POPULAR MODELS
		List<WebElement> popModels=uc_obj.popularModels();
		
		
		
		//****PRINTING THE OUT PUT IN THE CONSOLE*****
		
		System.out.println("\n\n******************POPULAR MODELS*********************\n\n");
		
		for(WebElement c :popModels) {
			System.out.println(c.getText());
		}
		
		
		

		//****PRINTING THE OUT PUT IN THE EXCEL SHEET*****
		
		
		ExcelUtility util=new ExcelUtility(p.getProperty("xlpath"));
		
		for(int i=0;i<popModels.size();i++) {
			
			util.setCellData("PopularModel", i, 0, popModels.get(i).getText());
			
			
			
			
		}
	}
	
	
	
	
	
	


}

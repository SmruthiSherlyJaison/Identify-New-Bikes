package testCases;


import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.UpcomingBikes;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC001_UpcomingBikes extends BaseClass {
	@Test(groups = { "regression" })
	public void TC001_UpcomingBikeDetails() throws InterruptedException, IOException {
		HomePage home_obj=new HomePage(driver);
		
		//HOVER OVER NEW BIKES OPTION
		home_obj.clickOnNewBikes();
		
		//CLICK ON UPCOMING BIKES
		home_obj.clickOnUpcomingBikes();
		
		
		UpcomingBikes upcoming_obj=new UpcomingBikes(driver);
		
		
		//SELECT THE MANUFACTURER AS "TVM"
		upcoming_obj.selectManufacturer();
		
	    //CLICK ON VIEWMORE TO SEE ALL THE BIKES
		upcoming_obj.viewMore();
		
		
		List<String> bikeLessThan4=upcoming_obj.getBikeDetailsLessThan4();
		
		
		
		
		//******ADD OUTPUT TO EXCEL SHEET******
		
		ExcelUtility util=new ExcelUtility(p.getProperty("xlpath"));
		
		for(int i=1; i<=bikeLessThan4.size(); i++) {
			 String[] data=bikeLessThan4.get(i-1).split(":");
			
			
				util.setCellData("CarsLessThan4Lakh", i,0,data[0]);
				util.setCellData("CarsLessThan4Lakh", i,1,data[1]);
				util.setCellData("CarsLessThan4Lakh", i,2,data[2]);
				
		
			
		}
		
			
	
		
		}
		
		
		
	}

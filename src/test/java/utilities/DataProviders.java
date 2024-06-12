package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import testBase.BaseClass;

public class DataProviders extends BaseClass{
	
	
	@DataProvider(name = "InvalidEmail")
	public String[][] getData1() throws IOException {
		// taking Excel file from testData
		//String path = ".\\testData\\zigwheels.xlsx";

		// creating an object for XLUtility
		ExcelUtility xlutil = new ExcelUtility(p.getProperty("xlpath"));

		// created for two dimension array which can store the data
		String Messagedata[][] = new String[1][1];

		// read the data from xl storing in two deminsional array
		
		
				Messagedata[0][0] = xlutil.getCellData("Input", 0, 0);
			
		// returning two dimension array
		return Messagedata;

	}

}

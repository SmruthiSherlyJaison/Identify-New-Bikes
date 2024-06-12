package pageObjects;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testBase.BaseClass;

public class UpcomingBikes extends BasePage {

	public UpcomingBikes(WebDriver driver) {
		super(driver);
		
	}
	
	//***************************************WEBELEMENTS***************************************
	
	
	
	
	// MANUFACTURER DROPDOWN
	@FindBy(xpath="//select[@id='makeId']")
	WebElement manufacturer;
	
	
	
	
	//GETTING THE BIKE DETAILS
	
	//BIKE NAME
	@FindBy(xpath="//a[@data-track-label='model-name']")
	List<WebElement> bikeName_list;
	
	//BIKE PRICE
	@FindBy(xpath="//div[@class='b fnt-15']")
	List<WebElement> bikePrice_list;
	
	//BIKE LAUNCH DATE
	@FindBy(xpath="//div[@class='clr-try fnt-14']")
	List<WebElement> launchDate_list;
	
	//VIEW MORE
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
	WebElement viewMore;
	
	
	
	
	
	//*************************************ACTIONS*************************************
	
	
	
	//SELECT MANUFATURER "HONDA"....
	public void selectManufacturer() {
		Select manufacturer_opt=new Select(manufacturer);
		manufacturer_opt.selectByVisibleText(BaseClass.p.getProperty("manufacturer"));
	}
	
	
	
	
	
	
	public List<String> getBikeDetailsLessThan4() {
		List<String> bikeLessThan4=new ArrayList<String>();
		
	try {
		for(int i=0;i<bikeName_list.size();i++) {
			
			String name=bikeName_list.get(i).getText();
			String price=bikePrice_list.get(i).getText();
			String date=launchDate_list.get(i).getText();
			String[] d=date.split(":");
			
			if(price.contains("Lakh")) {
				String[] p=price.split(" ");
				
				if(Float.parseFloat(p[1])<4.00) {
				
					System.out.println(name+"\t\t"+price+"\t\t"+date);
					bikeLessThan4.add(name+":"+price+":"+d[1]);
					
				
				}
				
			}
			else {
				System.out.println(name+"\t\t"+price+"\t\t"+date);
				
				bikeLessThan4.add(name+":"+price+":"+d[1]);
				
			}
			
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return bikeLessThan4;
	}
	
	
	
	
	
	
	
	//VIEWMORE
	public void viewMore() {
		
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", viewMore);
		js.executeScript("arguments[0].click()",viewMore);
		
	}
	


}

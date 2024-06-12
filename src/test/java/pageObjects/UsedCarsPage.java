package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UsedCarsPage extends BasePage {

	public UsedCarsPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	   @FindBy(xpath="//img[@alt='ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, QnA']")
	   WebElement logo;
	
	
	//USED CARS
		@FindBy(linkText="Used Cars")
		WebElement usedCars;
			
			
		//CHENNAI
		@FindBy(xpath="//a[@href='/used-car/Chennai']")
		WebElement loc_Chennai;
		
		//table//tr//td[1]
		
		//POPULAR MODELS LIST
        @FindBy(xpath="//table//tr//td[1]")	
        List<WebElement> popularModels_list;
        
        
        @FindBy(xpath="//table//tr")	
        WebElement view;
        
        
		
      //a[@class=\"fnt-22 zm-cmn-colorBlack n zw-sr-headingPadding clickGtm saveslotno\"]
		
		@FindBy(xpath="//*[@id=\"seoMore\"]/span")
		WebElement seeMore;
		
		
		
		//CHOOSE LOCATION "CHENNAI"...
		public void chooseChennai() {
			logo.click();
			Actions act=new Actions(driver);
			act.moveToElement(usedCars).perform();
			
			loc_Chennai.click();
		}
		
		//LIST OF POPULAR MODELS
		public List<WebElement> popularModels() throws InterruptedException {
			seeMore.click();
			Thread.sleep(3000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()",view );
			return popularModels_list;
			
		}

}

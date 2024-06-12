package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		}
	//************************************WEB ELEMENTS**********************************
	//WebElement newBikes=driver.findElement(By.linkText("New Bikes"));
	
	//NEW BIKES 
	@FindBy(linkText="New Bikes")
	 WebElement newBikes;
	
    //UPCOMING BIKES
	@FindBy(linkText="Upcoming Bikes")
	WebElement upcoming;
	
	
	//LOGIN OR SIGNUP
	@FindBy(id="forum_login_div_lg")
	WebElement login;
	
	
	
	//************************************ACTIONS***************************************
	
	//HOVER OVER NEW BIKES OPTION
	public void clickOnNewBikes(){
		Actions act=new Actions(driver);
		act.moveToElement(newBikes).perform();
		
		}
	
	//CLICK ON UPCOMING BIKES
	public void clickOnUpcomingBikes() {
		upcoming.click();
	}
	
	
	//CLICK ON LOGIN/SIGNUP
	public void login() throws InterruptedException {
		login.click();
		Thread.sleep(3000);
	}
	
	
}

package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

    //BACK HOME
	@FindBy(xpath="//img[@alt='ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, QnA']")
	WebElement home;
	
	//GOOGLE
	@FindBy(xpath="//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
	WebElement google;
	
	//EMAIL INPUT BOX
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement emailId;
	
	//NEXT
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement next;
	
	@FindBy(xpath="//div[@class='Ekjuhf Jj6Lae']")
	WebElement errMsg;
	
	
	//BACK TO THE HOME PAGE
	public void goBackHome() {
		home.click();
		
	}
	
	public void chooseGoogle(){
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(google));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", google);
		
		
		
	}
	
	public void inputEmail(String email) {
		Set<String> windowIdSet=driver.getWindowHandles();
		List<String> windowId_array=new ArrayList(windowIdSet);
		String childId=windowId_array.get(1);
       
		
		driver.switchTo().window(childId);
		emailId.click();
		emailId.sendKeys(email);
		next.click();
		
	}
	
	
	public String getErrorMsg() {
		
		System.out.println("\n********ERROR MESSAGE CAPTURED********");
		return errMsg.getText();
	}

}

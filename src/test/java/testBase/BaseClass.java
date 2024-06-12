package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;

	public static Properties p;
	public static TakesScreenshot takesScreenshot;

	@BeforeClass(groups = { "sanity", "regression"})
	@Parameters({"browser"})
	public void setup(String br) throws IOException

	{

		FileReader file = new FileReader(".//src/test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		
//***************************************CHOOSE BROWSER******************************************
		if(br.equalsIgnoreCase("chrome")) {
			
			

			driver = new ChromeDriver();
			}
			
			
		else if(br.equalsIgnoreCase("edge")) {
				
				driver = new EdgeDriver();
				}
		
		
		
		
		
		takesScreenshot = (TakesScreenshot)driver;
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();

	}

    @AfterClass(groups = { "sanity", "regression" })
	public void tearDown() {
		// Quit the window
		driver.quit();

	}

	// Screenshot Method

	public static String captureScreen(String tname) throws IOException {

		// Current Date and Time
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}


}

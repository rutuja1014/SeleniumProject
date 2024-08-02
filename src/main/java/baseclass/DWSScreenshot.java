package baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class DWSScreenshot {
	public static WebDriver driver;
	@BeforeClass
public void preCondition() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
}
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("Welcome to DWS site");
	}
	@AfterMethod
	public void afterMethod() {
		Reporter.log("Thank you for visiting");
	}
	@AfterClass
	public void postCondition() {
		driver.quit();
	}
	
	
	
}

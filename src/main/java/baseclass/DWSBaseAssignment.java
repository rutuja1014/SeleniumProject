package baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class DWSBaseAssignment {
	public   WebDriver driver;
    @Parameters({"browser","url"})
	@BeforeClass
	public void preCondition(String browser,String url) {
		
	   if (browser.equalsIgnoreCase("chrome")) { 
		   driver = new ChromeDriver();	
	   }
	   else if (browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	   else if (browser.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	}
	   else {
		driver = new ChromeDriver();
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to(url);
	}
	@BeforeMethod
	public void login() {
		//Login user
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys("rutujagaikwad433@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Rutuja@123");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}
	@AfterMethod
	public void logout() {
		
		driver.findElement(By.className("ico-logout"));
	}
	
	@AfterClass
	public void postCondition() {
		
		driver.quit();;
	}
}

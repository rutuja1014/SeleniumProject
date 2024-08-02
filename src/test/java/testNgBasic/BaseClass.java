package testNgBasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v114.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
public WebDriver driver;
@BeforeClass
public void preCondition(String browser) {
	if (browser.equals("chrome")) {
		driver=new ChromeDriver();
	} else if (browser.equals("edge")) {
		driver=new EdgeDriver();
	}
	else if (browser.equals("firefox")) {
		driver=new FirefoxDriver();
	} 
	else
	{
		driver=new ChromeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	
}
@BeforeMethod
public void Login() {
	driver.findElement(By.className("")).click();
	driver.findElement(By.id("Email")).sendKeys("rutujagaikwad433@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("Gaikwad07");
	driver.findElement(By.xpath("//input")).click();
}
@AfterMethod
public void LogOut() {
	driver.findElement(By.className("")).click();
}
@AfterClass
public void PostCondition() {
	driver.quit();
}
}

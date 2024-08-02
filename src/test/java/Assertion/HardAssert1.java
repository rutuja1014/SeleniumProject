package Assertion;
	import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
	public class HardAssert1 {
		@Test
	public void main() throws InterruptedException {
			String expectedURL="https://demowebshop.tricentis.cm/";
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://demowebshop.tricentis.com/");
			String currentURL = driver.getCurrentUrl();
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(expectedURL,currentURL,"url not matchingggggggggggg");
			Reporter.log("i am in dws",false);
			driver.findElement(By.id("small-searchterms")).sendKeys("Hiii",Keys.ENTER);
			WebElement advance = driver.findElement(By.id("As"));
			advance.click();
			Thread.sleep(2000);
			soft.assertTrue(advance.isSelected(),"Elemengt is not selected");
			WebElement advance2 = driver.findElement(By.id("Isc"));
			advance2.click();
			Thread.sleep(2000);
			soft.assertTrue(advance2.isSelected(),"Elemengt is not selected");
		
	}
	}

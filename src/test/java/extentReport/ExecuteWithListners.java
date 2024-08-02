package extentReport;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crm.Listerners1.ReportWithListerners.class)

public class ExecuteWithListners {
	

			@Test
			public void dominos()
			{
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get("https://pizzaonline.dominos.co.in/");
			}
			
			@Test(timeOut = 1000)
			public void rcb() throws InterruptedException
			{
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get("https://www.royalchallengers.com/");
				Thread.sleep(2000);
			}
			
			@Test(dependsOnMethods = "rcb")
			public void csk()
			{
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get("https://www.chennaisuperkings.com/");
			}

}

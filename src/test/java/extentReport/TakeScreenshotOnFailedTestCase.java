package extentReport;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.DWSScreenshot;


@Listeners(com.crm.Listerners1.ScreenshotWithFailed.class)

public class TakeScreenshotOnFailedTestCase extends DWSScreenshot {
	@Test
public void loginFunction() {
	driver.findElement(By.className("ico-login")).click();
	driver.findElement(By.id("Email")).sendKeys("rutujagaikwad4330@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("Rutuja@123");
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	driver.findElement(By.className("ico-logout")).click();
}

}

package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterFunction {
	@Test
	public void main() throws InterruptedException  {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://demowebshop.tricentis.com/");
		DWSRegister ref = new DWSRegister(driver);
		ref.register_link();
		Thread.sleep(2000);
		ref.gender();
		ref.firstname("rutuja");
		ref.lastName("gaikwad");
		ref.email("rutujagaikwad433@gmail.com");
		Thread.sleep(2000);
		ref.password("Rutuja@123");
		ref.confirm_password("Rutuja@123");
		Thread.sleep(2000);
		ref.register_button();
		Thread.sleep(2000);
		driver.close();
	}

}

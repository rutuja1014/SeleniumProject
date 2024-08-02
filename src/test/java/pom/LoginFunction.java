package pom;

import java.time.Duration;
import pom.DWSLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class LoginFunction {
	@Test
public void main() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	DWSLogin ref=new DWSLogin(driver);
	ref.login_link();
	Thread.sleep(2000);
	ref.username("rutujagaikwad433@gmail.com");
	Thread.sleep(2000);
	ref.password("Gaikwad07");
	ref.login_button();
	Thread.sleep(2000);
	driver.close();
	
	
	
	
}
}

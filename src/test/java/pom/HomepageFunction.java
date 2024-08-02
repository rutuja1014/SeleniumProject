package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomepageFunction {
	@Test
	public void Homepage() throws InterruptedException
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		HomepageFunction ref= new HomepageFunction() ;
		
		ref.getNewsletter("Welcome");
		Thread.sleep(2000);
		ref.getSearchTf("watch");
		Thread.sleep(2000);
		ref.getSearchButton();
		Thread.sleep(2000);
		driver.navigate().back();
		
		List<WebElement> poll = ref.getPoll();
		for (WebElement web : poll) {
			web.click();
			Thread.sleep(2000);
			
		}
		
		List<WebElement> navBar = ref.getNavBar();
		for (WebElement web : navBar) {
			web.click();
			Thread.sleep(2000);
			driver.navigate().back();
			
		}
		
		
		
	}

	private List<WebElement> getNavBar() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<WebElement> getPoll() {
		// TODO Auto-generated method stub
		return null;
	}

	private void getSearchButton() {
		// TODO Auto-generated method stub
		
	}

	private void getSearchTf(String string) {
		// TODO Auto-generated method stub
		
	}

	private void getNewsletter(String string) {
		// TODO Auto-generated method stub
		
	}

}

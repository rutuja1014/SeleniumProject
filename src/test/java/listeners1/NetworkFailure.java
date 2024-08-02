package listeners1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class NetworkFailure {
@Test(retryAnalyzer =com.crm.Listerners1.RetryNetwork.class)
public void executeOneMoreTime() {
	//when both the URL are correct then it will execute for only one time and
	//if the url are not correct it will execute for 5 times
	String expected_output="https://demowebshop.tricentis.com/";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
    String actual_output	=driver.getCurrentUrl();
    assertEquals(expected_output, actual_output);
//      String ref1="Mobile";
//      String ref2="Mobile1";
//      assertEquals(ref1, ref2,"both are not same");
}
}
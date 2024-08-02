package listeners1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.DWSBaseListeners;
@Listeners(com.crm.Listerners1.Basic.class)
public class TestCaseBasic extends DWSBaseListeners {
	 @Test
	    public void main1() {
	        String expectedResult = "https://demowebshop.tricentis.com/";
	        String actualResult = driver.getCurrentUrl();
	        assertEquals(actualResult, expectedResult, "URL does not match the expected result for main1.");
	    }

	    @Test
	    public void main2() {
	        String expectedResult = "https://demowebshop.tricentis.com/uiuui";
	        String actualResult = driver.getCurrentUrl();
	        assertEquals(actualResult, expectedResult, "URL does not match the expected result for main2.");
	    }
	}

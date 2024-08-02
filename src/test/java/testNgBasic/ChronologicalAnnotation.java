package testNgBasic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChronologicalAnnotation {
@BeforeSuite
public void beforeSuite() {
	System.out.println("BeforeSuite");
}
@BeforeTest
public void beforeTest() {
	System.out.println("BeforeTest");
}
@BeforeClass
public void beforeClass() {
	System.out.println("BeforeClass");
}
@BeforeMethod
public void beforeMethod() {
	System.out.println("BeforeMethod");
}
@Test  //acts as a main method
public void testcase() {
	System.out.println("testCase");
}
@AfterMethod
public void afterMethod() {
	System.out.println("afterMethod");
}
@AfterClass
public void afterClass() {
	System.out.println("afterClass");
}
@AfterTest
public void afterTest() {
	System.out.println("afterTest");
}
@AfterSuite
public void afterSuite() {
	System.out.println("AfterSuite");
}
}

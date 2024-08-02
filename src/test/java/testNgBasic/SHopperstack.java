package testNgBasic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SHopperstack {

	@DataProvider(name="data")
	public Object[][] sender() throws EncryptedDocumentException, IOException
	{
		Object[][] obj = new Object [2][2];
		FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\SSLogin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet .getPhysicalNumberOfRows();
		int colom = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 0; i < row; i++) {
			
			for (int j = 0; j <colom; j++) {
				
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj;
  }
	 @Test(dataProvider = "data")
	  public void reciver(String data1,String data2) throws InterruptedException
	  {
		    ChromeDriver driver =new ChromeDriver() ;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://www.shoppersstack.com/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));
			driver.findElement(By.id("loginBtn")).click();
			driver.findElement(By.id("Email")).sendKeys(data1);
			driver.findElement(By.id("Password")).sendKeys(data2);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			Thread.sleep(2000);
			driver.close();
}
	 }
package baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import DataProvider.JavaUtility;

public class DWSBaseListeners {
    public static WebDriver driver;

    @BeforeClass
    public void preCondition() throws IOException  {
        String browser = JavaUtility.logindata("browser");
        String url = JavaUtility.logindata("url");
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to(url);
    }

    @BeforeMethod
    public void login() throws IOException {
        // Login user
        String username = JavaUtility.logindata("username");
        String password = JavaUtility.logindata("password");
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    @AfterMethod
    public void logout() {
        driver.findElement(By.className("ico-logout")).click();  // Ensure the logout action is performed
    }

    @AfterClass
    public void postCondition() {
        if (driver != null) {
            driver.quit();
        }
    }
}

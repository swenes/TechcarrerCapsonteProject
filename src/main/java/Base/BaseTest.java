package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends BaseLibrary {
    public static WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(){
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
            driver.quit();
    }

}

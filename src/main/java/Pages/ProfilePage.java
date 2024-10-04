package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePage extends BaseTest {

    @Step("Giriş Yap mesajı alınır.")
    public String getLoginText(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div[1]/div/h3")).getText();
    }
}

package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class BasePage extends BaseTest {
    @Step("'Boş Alan' mesajı alınır.")
    public String getEmptyErrMessage(){
        return driver.findElement(By.cssSelector("[class='-errorMessage']")).getText();
    }
}

package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends BaseTest {

    @Step("Mail adresi ve parola doldurulur")
    public LoginPage fillMailAndPassword(String mail, String password) {
        WebElement mailElement = driver.findElement(By.id("customerEmail"));
        mailElement.sendKeys(mail);
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);
        return this;
    }

    @Step("Giriş Yap butonuna tıklanır.")
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginBtn\"]"));
        loginButton.submit();
    }

    public void goToLoginPage() {
        driver.get("https://www.beymen.com/tr/customer/login?returnUrl=/tr/customer");
    }


}
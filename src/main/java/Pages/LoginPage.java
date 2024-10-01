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

    @Step("Login sayfasına gidilir.")
    public void goToLoginPage() {
        driver.get("https://www.beymen.com/tr/customer/login?returnUrl=/tr/customer");
    }
    @Step("'En az 6 karakter olmalı.' mesajı alınır.")
    public String getInvalidPasswordErrorMessage(){
        return driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[2]/div/span")).getText();
    }
    @Step("'Lütfen bilgilerinizi kontrol edip yeniden deneyiniz.' mesajı alınır.")
    public String getWrongMailErrorMessage(){
        return driver.findElement(By.xpath("//*[@id=\"notifyMessage\"]")).getText();
    }

    @Step("'Lütfen geçerli bir eposta adresi giriniz' mesajı alınır.")
    public String getInvalidMailErrorMessage(){
        return driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div/span[2]")).getText();
    }


}
package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage extends BaseTest {

    @Step("Çerezler kabul edilir")
    public BasePage acceptCookies() {
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptCookiesButton.click();
        return this;
    }
    @Step("'Bu alan boş bırakılamaz' mesajı alınır.")
    public String getEmptyErrorMessage(){
        return driver.findElement(By.cssSelector("[class='-errorMessage']")).getText();
    }

    @Step("'Lütfen geçerli bir eposta adresi giriniz' mesajı alınır.")
    public String getInvalidMailErrorMessage(){
        return driver.findElement(By.xpath("//*[@id=\"js-registerScroll\"]/span[2]")).getText();
    }

    @Step("'En az 6 karakter olmalı.' mesajı alınır.")
    public String getInvalidPasswordErrorMessage(){
            return driver.findElement(By.xpath("//*[@id=\"registerForm\"]/div[1]/div[7]/span")).getText();
    }

    @Step("'Yanlış Cep Telefon Numarası Formatı' mesajı alınır.")
    public String getInvalidPhoneNumberErrorMessage(){
        return driver.findElement(By.xpath("//*[@id=\"registerForm\"]/div[1]/div[4]/span[2]")).getText();
    }

    @Step("'Üye Girişi Yapılamadı' mesajı alınır")
    public String getWrongPaswordErrorMessage(){
        return driver.findElement(By.xpath("//*[@id=\"notifyMessage\"]")).getText();
    }
}

package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyCartPage extends BaseTest {

    @Step
    public void goToProductPage(){
        driver.get("https://www.beymen.com/tr/p_scotch-soda-siyah-dis-gomlek_1560316");
    }

    @Step("'Ürün sepetinize eklenmiştir.' mesajı alınır")
    public String getAddedToCartMessage(){
       return driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div")).getText();
    }

    @Step("'Ürün sepetinize eklenmiştir.' mesajı alınır")
    public String getDeletedToCartMessage(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/span/div/div/div")).getText();
    }
}

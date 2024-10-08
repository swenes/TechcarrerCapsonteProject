import Base.BaseTest;
import Pages.BasePage;
import Pages.MyCartPage;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.BaseTest.driver;

@Feature("Base Page Test Senaryoları")
public class BasePageTest extends BaseTest {

    BasePage basePage = new BasePage();


    @BeforeMethod
    public void setUp() throws InterruptedException {
        sleep(3000);
    }

    @Test(description = "Geçerli Ürün Adı ile Arama Yapma")
    public void searchSuccessful() throws InterruptedException {
        basePage.acceptCookies();
        basePage.selectGender("male");
        WebElement searchBox = driver.findElement(By.cssSelector("[class='o-header__search--input']"));
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.ENTER);
        sleep(2000);
        //actualValue'da akıllı tırnakları düz tırnaklarla değiştiriyoruz
        String actualValue = basePage.getProductFoundErrorMessage();
        actualValue = actualValue.replace("“", "\"").replace("”", "\"");
        assertEquals(actualValue, productFoundMessage);
    }
    @Test(description = "Geçersiz Ürün Adı ile Arama Yapma")
    public void searchFailCase() throws InterruptedException {
        basePage.acceptCookies();
        basePage.selectGender("male");
        WebElement searchBox = driver.findElement(By.cssSelector("[class='o-header__search--input']"));
        searchBox.sendKeys(invalidSearchText);
        searchBox.sendKeys(Keys.ENTER);
        sleep(2000);
        //actualValue'da akıllı tırnakları düz tırnaklarla değiştiriyoruz
        String actualValue = basePage.getProductNotFoundErrorMessage();
        actualValue = actualValue.replace("“", "\"").replace("”", "\"");
        assertEquals(actualValue, productNotFoundMessage);
    }


}

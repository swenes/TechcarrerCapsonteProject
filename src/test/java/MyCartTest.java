import Base.BaseTest;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.MyCartPage;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("My Cart Test Senaryoları")

public class MyCartTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    MyCartPage myCartPage = new MyCartPage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        sleep(3000);
    }

    @Test(description = "Hesaba giriş yapılır ve ürün sepete başarılı bir şekilde eklenir.")
    public void addToMyCartWithLogin() throws InterruptedException {
        basePage.acceptCookies();
        loginPage.goToLoginPage();
        loginPage.fillMailAndPassword(mail,password)
                .clickLoginButton();
        sleep(2000);
        myCartPage.goToProductPage();
        sleep(3000);
        WebElement selectSize = driver.findElement(By.cssSelector("[class='m-variation__item']")); // ürün tükendiğinde(s-m-l-xl seçimi yapılamadığında) patlıyor buraya update gerekecek.
        selectSize.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"addBasket\"]"));
        addToCartButton.click();
        sleep(1000);
        String actualValue =myCartPage.getAddedToCartMessage();
        assertEquals(actualValue,addedToCardMessage);
    }

    @Test(description = "Hesaba giriş yapılmadan ürün sepete başarılı bir şekilde eklenir.")
    public void addToMyCartWithoutLogin() throws InterruptedException {
        basePage.acceptCookies();
        myCartPage.goToProductPage();
        sleep(3000);
        WebElement selectSize = driver.findElement(By.cssSelector("[class='m-variation__item']"));
        sleep(1000);
        selectSize.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"addBasket\"]"));
        addToCartButton.click();
        sleep(1000);
        String actualValue =myCartPage.getAddedToCartMessage();
        assertEquals(actualValue,addedToCardMessage);
    }

    @Test(description = "Hesaba giriş yapılır, sepetime gidilir ve sepetteki ürün silinir.")
    public void deleteFromMyCart() throws InterruptedException {
        loginPage.goToLoginPage();
        sleep(3000);
        loginPage.fillMailAndPassword(mail,password)
                .clickLoginButton();
        sleep(2000);
        basePage.acceptCookies();
        sleep(2000);
        WebElement myCartButton = driver.findElement(By.xpath("//*[@id=\"headerJs\"]/header/div/div/div[3]/div/a[3]"));
        sleep(2000);
        myCartButton.click();
        sleep(3000);
        WebElement deleteProductButton = driver.findElement(By.xpath("//*[@id=\"removeCartItemBtn0-key-0\"]"));
        deleteProductButton.click();
        sleep(2000);
        String actualValue =myCartPage.getDeletedToCartMessage();
        assertEquals(actualValue,deletedFromCartMessage);
    }
}

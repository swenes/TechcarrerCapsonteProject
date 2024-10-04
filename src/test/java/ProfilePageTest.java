import Base.BaseTest;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(ProfilePage.class);
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    ProfilePage profilePage = new ProfilePage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        sleep(3000);
    }

    @Test
    public void logout() throws InterruptedException {
        loginPage.goToLoginPage();
        sleep(1000);
        loginPage.fillMailAndPassword(mail,password)
                .clickLoginButton();
        basePage.acceptCookies();
        WebElement myProfileButton = driver.findElement(By.xpath("//*[@id=\"headerJs\"]/header/div/div/div[3]/div/a[1]"));
        myProfileButton.click();
        sleep(1000);
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"exitBtnTop\"]"));
        logoutButton.click();
        WebElement areYouSureButton = driver.findElement(By.xpath("//*[@id=\"sendBtn\"]"));
        areYouSureButton.click();
        sleep(1000);
        WebElement myProfileButton2 = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/a[1]"));
        myProfileButton2.click();
        String actualValue = profilePage.getLoginText();
        assertEquals(actualValue,loginText);
    }
}

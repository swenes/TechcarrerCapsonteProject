import Base.BaseTest;
import Pages.BasePage;
import Pages.LoginPage;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Feature("Login Page Test Senaryoları")

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        loginPage.goToLoginPage();
        sleep(1000);
        basePage.acceptCookies();
    }

    @Test(description = "Başarılı Kullanıcı Girişi")
    public void loginSuccessful() throws InterruptedException {
        loginPage.fillMailAndPassword(mail, password)
                .clickLoginButton();
    }

    @Test(description = "Başarısız Kullanıcı Girişi (Geçersiz Şifre Formatı Denemesi)")
    public void loginFailCase1() throws InterruptedException {
        loginPage.fillMailAndPassword(mail, invalidFormatPassword)
                .clickLoginButton();
        String actualValue = loginPage.getInvalidPasswordErrorMessage();
        assertEquals(actualValue, invalidPasswordMessage);
    }

    @Test(description = "Başarısız Kullanıcı Girişi (Yanlış Şifre Denemesi)")
    public void loginFailCase2() throws InterruptedException {
        loginPage.fillMailAndPassword(mail, invalidPassword)
                .clickLoginButton();
        sleep(1000);
        String actualValue = basePage.getWrongPaswordErrorMessage();
        assertEquals(actualValue, wrongPasswordMessage);
    }

    @Test(description = "Başarısız Kullanıcı Girişi (Yanlış E-posta Denemesi)")
    public void loginFailCase3() throws InterruptedException {
        loginPage.fillMailAndPassword(wrongMail, password)
                .clickLoginButton();
        sleep(1000);
        String actualValue = loginPage.getWrongMailErrorMessage();
        assertEquals(actualValue, wrongMailMessage);
    }

    @Test(description = "Başarısız Kullanıcı Girişi (Hatalı E-posta Formatı Denemesi)")
    public void loginFailCase4() throws InterruptedException {
        loginPage.fillMailAndPassword(invalidFormatMail, password)
                .clickLoginButton();
        sleep(1000);
        String actualValue = loginPage.getInvalidMailErrorMessage();
        assertEquals(actualValue, invalidMailFormatMessage);
    }

    @Test(description = "Başarısız Kullanıcı Girişi (Boş E-posta Denemesi)")
    public void loginFailCase5() throws InterruptedException {
        loginPage.fillMailAndPassword(empty, password)
                .clickLoginButton();
        sleep(1000);
        String actualValue = basePage.getEmptyErrorMessage();
        assertEquals(actualValue, emptyErrorMessage);
    }
    @Test(description = "Başarısız Kullanıcı Girişi (Boş Şifre Denemesi)")
    public void loginFailCase6() throws InterruptedException {
        loginPage.fillMailAndPassword(mail,empty)
                .clickLoginButton();
        sleep(1000);
        String actualValue = basePage.getEmptyErrorMessage();
        assertEquals(actualValue, emptyErrorMessage);
    }

}

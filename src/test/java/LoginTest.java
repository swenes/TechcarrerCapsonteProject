import Base.BaseTest;
import Pages.LoginPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


@Feature("Login Test Senaryoları")

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(description = "Başarılı Kullanıcı Girişi")
    public void loginSuccessful() throws InterruptedException {
        loginPage.goToLoginPage();
        sleep(5000);
        loginPage.fillMailAndPassword(mail, password)
                .clickLoginButton();
    }

}

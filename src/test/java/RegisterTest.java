import Base.BaseTest;
import Pages.RegisterPage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage = new RegisterPage();

    @Test
    public void RegisterSuccess() throws InterruptedException {
        registerPage.goToRegisterPage();
        sleep(3000);
        registerPage.acceptCookies();
        registerPage.fillRegisterForm(name, surname, mail, phoneNumber, password)
                .selectDateOfBirth("07", "Aralık", "2000")
                .selectGender("male")
                .acceptAgreement()
                .clickRegisterButton();
        sleep(10000);
        registerPage.withoutPermission();
    }
}

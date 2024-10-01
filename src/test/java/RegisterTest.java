import Base.BaseTest;
import Pages.BasePage;
import Pages.RegisterPage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage = new RegisterPage();
    BasePage basePage = new BasePage();

    @Test(description = "Başarılı Kullanıcı Kaydı")
    public void registerSuccess() throws InterruptedException {
        registerPage.goToRegisterPage();
        sleep(3000);
        registerPage.acceptCookies();
        registerPage.fillRegisterForm(name, surname, mail, phoneNumber, password)
                .selectDateOfBirth("07", "Aralık", "2000")
                .selectGender("male")
                .acceptAgreement()
                .clickRegisterButton();
        sleep(2000);
        registerPage.withoutPermission(); // İleti gönderimine izin vermeden devam et seçimi
        sleep(5000);
    }

    @Test(description = "Başarısız Kayıt (Zorunlu alanın boş bırakılması)")
    public void registerFail() throws InterruptedException {
        registerPage.goToRegisterPage();
        sleep(3000);
        registerPage.acceptCookies();
        registerPage.fillRegisterForm(empty, surname, mail, empty, password)
                .selectDateOfBirth("07", "Aralık", "2000")
                .selectGender("male")
                .acceptAgreement()
                .clickRegisterButton();
        String actualValue = basePage.getEmptyErrMessage();
        assertEquals(actualValue, emptyError);
    }


}

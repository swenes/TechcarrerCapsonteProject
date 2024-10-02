import Base.BaseTest;
import Pages.BasePage;
import Pages.RegisterPage;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Feature("Register Page Test Senaryoları")

public class RegisterTest extends BaseTest {

    RegisterPage registerPage = new RegisterPage();
    BasePage basePage = new BasePage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        registerPage.goToRegisterPage();
        sleep(1000);
        basePage.acceptCookies();
    }

    @Test(description = "Başarılı Kullanıcı Kaydı")
    public void registerSuccess() throws InterruptedException {
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
    public void registerFailCase1() throws InterruptedException {
        registerPage.fillRegisterForm(empty, surname, mail, empty, password)
                .selectDateOfBirth("07", "Aralık", "2000")
                .selectGender("male")
                .acceptAgreement()
                .clickRegisterButton();
        String actualValue = basePage.getEmptyErrorMessage();
        assertEquals(actualValue, emptyErrorMessage);
    }

    @Test(description = "Başarısız Kayıt (Geçersiz mail formatı)")
    public void registerFailCase2() throws InterruptedException {
        registerPage.fillRegisterForm(name, surname, invalidFormatMail, phoneNumber, password)
                .selectDateOfBirth("07", "Aralık", "2000")
                .selectGender("male")
                .acceptAgreement()
                .clickRegisterButton();
        String actualValue = basePage.getInvalidMailErrorMessage();
        assertEquals(actualValue, invalidMailFormatMessage);
    }

    @Test(description = "Başarısız Kayıt (Zayıf Şifre ile Kayıt Olma)")
    public void registerFailCase3() throws InterruptedException {
        registerPage.fillRegisterForm(name, surname, mail, phoneNumber, invalidFormatPassword)
                .selectDateOfBirth("07", "Aralık", "2000")
                .selectGender("male")
                .acceptAgreement()
                .clickRegisterButton();
        String actualValue = basePage.getInvalidPasswordErrorMessage();
        assertEquals(actualValue, invalidPasswordMessage);
    }
    @Test(description = "Başarısız Kayıt (Sözleşme Kabul Edilmeden Kayıt Olma)")
    public void registerFailCase4() throws InterruptedException {
        registerPage.fillRegisterForm(name, surname, mail, phoneNumber, password)
                .selectDateOfBirth("07", "Aralık", "2000")
                .selectGender("male")
                .clickRegisterButton();
        String actualValue = basePage.getEmptyErrorMessage();
        assertEquals(actualValue, emptyErrorMessage);
    }
    @Test(description = "Başarısız Kayıt (Yanlış Telefon Numarası ile Kayıt Olma)")
    public void registerFailCase5() throws InterruptedException {
        registerPage.fillRegisterForm(name, surname, mail, invalidPhoneNumber, password)
                .selectDateOfBirth("07", "Aralık", "2000")
                .selectGender("male")
                .clickRegisterButton();
        String actualValue = basePage.getInvalidPhoneNumberErrorMessage();
        assertEquals(actualValue, invalidPhoneMessage);
    }


}

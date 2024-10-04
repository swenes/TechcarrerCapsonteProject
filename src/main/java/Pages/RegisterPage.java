package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BaseTest {

    public void goToRegisterPage() {
        driver.get("https://www.beymen.com/tr/customer/register?returnUrl=/tr/customer");
    }

    @Step("Kayıt için gerekli bilgiler doldurulur")
    public RegisterPage fillRegisterForm(String name, String surname, String email, String phoneNumber, String password) {
        WebElement personelName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        personelName.click();
        personelName.sendKeys(name);
        WebElement personelSurname = driver.findElement(By.xpath("//*[@id=\"surname\"]"));
        personelSurname.sendKeys(surname);
        WebElement personelEmail = driver.findElement(By.xpath("//*[@id=\"customerEmail\"]"));
        personelEmail.sendKeys(email);
        WebElement personelPhoneNumber = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        personelPhoneNumber.sendKeys(phoneNumber);
        WebElement personelPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        personelPassword.sendKeys(password);
        return this;
    }

    @Step("Register butonuna tıklanır")
    public RegisterPage clickRegisterButton() {
        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"registerbtn\"]"));
        registerButton.submit();
        return this;
    }
    @Step("Doğum tarihi seçilir.")
    public RegisterPage selectDateOfBirth(String day, String month, String year) {
        // Gün seçimi
        WebElement dayDropdown = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByVisibleText(day);  // Örneğin "5" olarak girilebilir

        // Ay seçimi
        WebElement monthDropdown = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);  // Örneğin "Ocak" olarak girilebilir

        // Yıl seçimi
        WebElement yearDropdown = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);  // Örneğin "2000" olarak girilebilir
        return this;
    }

    @Step("Cinsiyet seçimi yapılır.")
    public RegisterPage selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            WebElement maleRadioButton = driver.findElement(By.xpath("//*[@id=\"registerForm\"]/div[1]/div[6]/div[2]/div/label"));
            maleRadioButton.click();
            return this;
        } else if (gender.equalsIgnoreCase("female")) {
            WebElement femaleRadioButton = driver.findElement(By.xpath("//*[@id=\"registerForm\"]/div[1]/div[6]/div[1]/div/label"));
            femaleRadioButton.click();
            return this;
        } else {
            throw new IllegalArgumentException("Invalid gender option: " + gender);
        }
    }

    @Step("Sözleşme kabul edilir")
    public RegisterPage acceptAgreement() {
        // Checkbox'ı bul
        WebElement termsCheckbox = driver.findElement(By.id("MembershipAgreement"));

        // JavaScriptExecutor ile checkbox'ı işaretle
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", termsCheckbox);
        return this;
    }

    @Step("Ticari elektronik izin verme butonuna tıklanır.")
    public RegisterPage withoutPermission(){
        WebElement withoutPermissionButton = driver.findElement(By.xpath("//*[@id=\"noAllowBtn\"]"));
        withoutPermissionButton.click();
        return this;
    }

}

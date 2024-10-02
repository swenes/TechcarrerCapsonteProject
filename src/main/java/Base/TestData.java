package Base;

public class TestData {


    public String URL = "https://www.beymen.com/tr";
    public String name = "Enes";
    public String surname = "Aydogdu";
    public String phoneNumber = "5436234972";
    public String mail = "enes.aydogdu2488@gmail.com";
    public String password = "enes4116";
    public String wrongMail = "1aydogduenes@gmail.com";
    public String invalidFormatMail = "testmail.com";
    public String invalidPassword = "123456789";
    public String invalidFormatPassword = "123";
    public String invalidPhoneNumber = "12345678910";
    public String empty = "";
    public String invalidSearchText = "abcdefghijklmnopqrst";
    public String searchText = "Gömlek";
    //expected error messages
    public String emptyErrorMessage = "Bu alan boş bırakılamaz";
    public String invalidMailFormatMessage = "Lütfen geçerli bir eposta adresi giriniz";
    public String invalidPasswordMessage = "En az 6 karakter olmalı.";
    public String wrongPasswordMessage = "Lütfen bilgilerinizi kontrol edip yeniden deneyiniz.";
    public String invalidPhoneMessage = "Lütfen cep telefonu numaranızı kontrol ediniz. 10 haneli numaranızı, başında 0 olmadan ve 5 ile başlayacak şekilde giriniz.";
    public String wrongMailMessage = "Lütfen bilgilerinizi kontrol edip yeniden deneyiniz.";
    public String productNotFoundMessage = "\"" + invalidSearchText + "\" için bir sonuç bulunamadı.";
    public String productFoundMessage = "\"" + searchText + "\" için en uygun sonuçlar";


}

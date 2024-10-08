# Techcarrer QA Bootcamp Bitirme Projesi

Bu projede, **Beymen.com.tr** platformunda kullanıcıların gerçekleştirdiği temel işlemleri otomatikleştirmeyi hedefledim. Kayıt olma, kullanıcı girişi, ürün arama, sepete ekleme ve çıkış yapma gibi kritik kullanıcı senaryolarını kapsamlı bir şekilde test etmek için otomasyon süreçleri geliştirdim. 

Projemi, **Page Object Model (POM) Design Pattern** kullanılarak yapılandırdım. Bu sayede kodun modülerliğini ve okunabilirliğini artırarak, daha kolay yönetilebilir ve sürdürülebilir bir test altyapısı oluşturmayı başardım.

Bu yapıyla birlikte, testlerin bakımını çok daha pratik hale getirip, farklı senaryoların eklenmesini de kolaylaştırmayı planladım.


## Projede Kullanılan Teknolojiler

- **Java**
- **Selenium**
- **TestNG**
- **Allure Report** (Test sonuçlarını raporlamak için)


# Test Senaryoları
![excel](https://github.com/user-attachments/assets/7a22d9f9-8c32-48dd-ab66-5150ecae0700)

### 1. Kayıt Olma Testleri

- **Başarılı Kayıt:** Tüm zorunlu alanlar doğru doldurularak başarılı bir kayıt işlemi yapılması.
- **Başarısız Kayıt - Zorunlu Alanların Boş Bırakılması:** Kayıt formunda gerekli alanların doldurulmaması.
- **Başarısız Kayıt - Geçersiz E-posta Formatı:** Yanlış formatta e-posta girilmesi.
- **Başarısız Kayıt - Zayıf Şifre ile Kayıt Denemesi:** Güvenlik açısından yetersiz bir şifre ile kayıt denemesi.
- **Başarısız Kayıt - Yanlış Telefon Numarası Formatı:** Yanlış formatta telefon numarası girilmesi.
- **Başarısız Kayıt - Kullanıcı Şartlarını Kabul Etmeden:** Kullanıcı şartlarını kabul etmeden kayıt denemesi.

### 2. Kullanıcı Giriş Testleri

- **Başarılı Giriş:** Doğru e-posta ve doğru şifre ile giriş.
- **Başarısız Giriş - Yanlış Şifre:** Doğru e-posta ile yanlış şifre girilmesi.
- **Başarısız Giriş - Yanlış E-posta:** Yanlış e-posta ile doğru şifre girilmesi.
- **Başarısız Giriş - Geçersiz E-posta Formatı:** Geçersiz formatta e-posta ile giriş denemesi.
- **Başarısız Giriş - Boş E-posta Alanı:** Şifre girildiği halde e-posta alanının boş bırakılması.
- **Başarısız Giriş - Boş Şifre Alanı:** E-posta girildiği halde şifre alanının boş bırakılması.

### 3. Ürün Arama Testleri

- **Geçerli Ürün Arama:** Doğru ve geçerli ürün adı ile ürün araması yapılması.
- **Geçersiz Ürün Arama:** Hatalı veya geçersiz ürün adı ile arama yapılması.

### 4. Sepete Ürün Ekleme ve Silme Testleri

- **Giriş Yapmadan Sepete Ürün Ekleme:** Kullanıcı giriş yapmadan bir ürünü sepete ekleme işlemi.
- **Giriş Yaparak Sepete Ürün Ekleme:** Kullanıcı giriş yaptıktan sonra bir ürünü sepete ekleme işlemi.
- **Sepetten Ürün Silme:** Sepetteki bir ürünü silme işlemi.

### 5. Kullanıcı Çıkış Testi

- **Kullanıcı Çıkışı:** Kullanıcı hesabından başarıyla çıkış yapabiliyor olmalı.

# Test Sonuçları (Allure Reports)

![allure_results2](https://github.com/user-attachments/assets/2a10b9a0-faeb-4134-a760-fd6ac388f783)
Bir login testinin fail olma durumu ise, Beymen web sitesinin rastgele olarak iki farklı uyarı mesajı döndürmesinden kaynaklıdır.

 • "Lütfen bilgilerinizi kontrol edip yeniden deneyiniz."


 • "Girdiğiniz karakterler hatalı. Lütfen tekrar yazınız."

 
Bu yüzden test, %50 olasılık ile fail vermektedir.  


![allure_results](https://github.com/user-attachments/assets/058c0b3e-e046-4d44-abcc-976d9ee7e210)






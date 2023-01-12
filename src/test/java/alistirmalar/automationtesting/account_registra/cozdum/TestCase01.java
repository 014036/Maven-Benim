package alistirmalar.automationtesting.account_registra.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase01 extends TestBase {

    /*
TEST CASE    1
Registration-Sign-in
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter registered Email Address in Email-Address textbox
5) Enter your own password in password textbox
6) Click on Register button
7) User will be registered successfully and will be navigated to the Home page


TEST DURUMU 1
Kayıt-Giriş-Giriş
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) E-posta Adresi metin kutusuna kayıtlı E-posta Adresini girin
5) Şifre metin kutusuna kendi şifrenizi girin
6) Kayıt Ol düğmesine tıklayın
7) Kullanıcı başarıyla kaydedilecek ve Ana sayfaya yönlendirilecektir.

     */

    @Test
    public void kayitGiris() {

    //2) "http://practice.automationtesting.in/" URL'sini girin
        driver.get("http://practice.automationtesting.in/");

    //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

    //4) E-posta Adresi metin kutusuna kayıtlı E-posta Adresini girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='reg_email']"));
         emailGir.sendKeys("geci.ici@hotmail.com");

    //5) Şifre metin kutusuna kendi şifrenizi girin
        WebElement passwordGir = driver.findElement(By.xpath("//input[@id='reg_password']"));
       passwordGir.sendKeys("Mustafa1.?!");

    //6) Kayıt Ol düğmesine tıklayın
      driver.findElement(By.xpath("//input[@name='register']")).click();

    //7) Kullanıcı başarıyla kaydedilecek ve Ana sayfaya yönlendirilecektir.
        String girisBasariliMi= driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText();
        String arananDeger="Hello";
        Assert.assertTrue(girisBasariliMi.contains(arananDeger));
    }
}

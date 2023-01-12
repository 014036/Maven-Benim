package alistirmalar.automationtesting.account_registra.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase02 extends TestBase {

    /*
TEST CASE   2
 Registration with invalid Email-id
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter invalid Email Address in Email-Address textbox
5) Enter your own password in password textbox
6) Click on Register button
7) Registration must fail with a warning message(ie You must enter a valid email address)


TEST DURUMU 2
  Geçersiz E-posta kimliği ile kayıt
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) E-posta Adresi metin kutusuna geçersiz E-posta Adresi girin
5) Şifre metin kutusuna kendi şifrenizi girin
6) Kayıt Ol düğmesine tıklayın
7) Kayıt, bir uyarı mesajı ile başarısız olmalıdır (ör. Geçerli bir e-posta adresi girmelisiniz)

     */
    @Test
    public void invalidEmail_Id() {

        //2) "http://practice.automationtesting.in/" URL'sini girin
        driver.get("http://practice.automationtesting.in/");

        //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

        //4) E-posta Adresi metin kutusuna geçersiz E-posta Adresi girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailGir.sendKeys("geci.ici@hotmail");

        //5) Şifre metin kutusuna kendi şifrenizi girin
        WebElement passwordGir = driver.findElement(By.xpath("//input[@id='reg_password']"));
        passwordGir.sendKeys("Mustafa1.?!");

        //6) Kayıt Ol düğmesine tıklayın
        driver.findElement(By.xpath("//input[@name='register']")).click();

        //7) Kayıt, bir uyarı mesajı ile başarısız olmalıdır (ör. Geçerli bir e-posta adresi girmelisiniz)
        String emailHatasiDogrulama= driver.findElement(By.xpath("//li[.='Error: Please provide a valid email address.']")).getText();
        System.out.println("emailHatasiDogrulama = " + emailHatasiDogrulama);
        String arananDeger="Error: Please provide a valid email address.";
        Assert.assertTrue(emailHatasiDogrulama.contains(arananDeger));
    }
}

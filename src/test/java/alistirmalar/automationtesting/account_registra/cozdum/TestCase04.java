package alistirmalar.automationtesting.account_registra.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase04 extends TestBase {

    /*
TEST CASE 4
4. Registration with empty password
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter valid Email Address in Email-Address textbox
5) Enter empty password in password textbox
6) Click on Register button
7) Registration must fail with a warning message(ie please enter an account password)



TEST DURUMU 4
4. Boş şifre ile kayıt
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) E-posta Adresi metin kutusuna geçerli E-posta Adresini girin
5) Şifre metin kutusuna boş şifreyi girin
6) Kayıt Ol düğmesine tıklayın
7) Kayıt, bir uyarı mesajı ile başarısız olmalıdır (ör. lütfen bir hesap şifresi giriniz)

     */

    @Test
    public void emptyPassword() {

        //2) "http://practice.automationtesting.in/" URL'sini girin
        driver.get("http://practice.automationtesting.in/");

        //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

        //4) E-posta Adresi metin kutusuna geçerli E-posta Adresini girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailGir.sendKeys("ggecc.ici@hotmail.com");

        //5) Şifre metin kutusuna boş şifreyi girin
        WebElement passwordGir = driver.findElement(By.xpath("//input[@id='reg_password']"));
        passwordGir.sendKeys("");

        //6) Kayıt Ol düğmesine tıklayın
        driver.findElement(By.xpath("//input[@name='register']")).click();

        //7)  Kayıt, bir uyarı mesajı ile başarısız olmalıdır (ör. lütfen bir hesap şifresi giriniz)
        String bosSifreDogrulama = driver.findElement(By.xpath("//li[.='Error: Please enter an account password.']")).getText();
        System.out.println("bosSifreDogrulama = " + bosSifreDogrulama);
        String arananDeger = "Error: Please enter an account password.";
        Assert.assertTrue(bosSifreDogrulama.contains(arananDeger));
    }
}

package alistirmalar.automationtesting.account_login.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase03 extends TestBase {
    /*

TEST CASE  3
3. Log-in with correct username and empty password.
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter valid username in username textbox
5) Now enter empty password in the password textbox
6) Click on login button.
7) Proper error must be displayed(ie Invalid password) and prompt to enter login again

TEST DURUMU 3
3. Doğru kullanıcı adı ve boş şifre ile oturum açın.
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) Kullanıcı adı metin kutusuna geçerli kullanıcı adını girin
5) Şimdi şifre metin kutusuna boş şifreyi girin
6) Oturum aç düğmesine tıklayın.
7) Uygun hata görüntülenmeli (ör. Geçersiz şifre) ve tekrar oturum açmanız istenmelidir
     */

    @Test
    public void bosSifreGirme() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

//3) Click on My Account Menu  //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

//4) Kullanıcı adı metin kutusuna geçerli kullanıcı adını girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='username']"));
        emailGir.sendKeys("gec.ici@hotmail.com");

//5) Şimdi şifre metin kutusuna boş şifreyi girin
        WebElement passwordGir = driver.findElement(By.xpath("//*[@class='login']/p[2]/input"));
        passwordGir.sendKeys("");

//6) Oturum aç düğmesine tıklayın.
        WebElement logineBas = driver.findElement(By.xpath("//input[@name='login']"));
        logineBas.click();

//7)  Uygun hata görüntülenmeli (ör. Geçersiz şifre) ve tekrar oturum açmanız istenmelidir
        String bosSifreDogrulama= driver.findElement(By.xpath("//li[.='Error: Password is required.']")).getText();
        System.out.println("bosSifreDogrulama = " + bosSifreDogrulama);
        String arananDeger="Error: Password is required.";
        Assert.assertTrue(bosSifreDogrulama.contains(arananDeger));

    }
}

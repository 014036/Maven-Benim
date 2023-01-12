package alistirmalar.automationtesting.account_login.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase02 extends TestBase {
    /*


TEST CASE  2
 2. Log-in with incorrect username and incorrect password.
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter incorrect username in username textbox
5) Enter incorrect password in password textbox.
6) Click on login button
7) Proper error must be displayed(ie Invalid username) and prompt to enter login again



TEST DURUMU 2
  2. Yanlış kullanıcı adı ve yanlış şifre ile giriş yapın.
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) Kullanıcı adı metin kutusuna yanlış kullanıcı adı girin
5) Şifre metin kutusuna yanlış şifreyi girin.
6) Giriş düğmesine tıklayın
7) Uygun hata görüntülenmeli (ör. Geçersiz kullanıcı adı) ve tekrar giriş yapılması istenmelidir

     */

    @Test
    public void yanlisVeriGirme() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

//3) Click on My Account Menu  //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

//4) Kullanıcı adı metin kutusuna yanlış kullanıcı adı girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='username']"));
        emailGir.sendKeys("gecc.ici@hotmail.com");

//5) Şifre metin kutusuna yanlış şifreyi girin.n
        WebElement passwordGir = driver.findElement(By.xpath("//*[@class='login']/p[2]/input"));
        passwordGir.sendKeys("Mustafa1.?!H");

//6) Click on login button //6) Giriş düğmesine tıklayın
        WebElement logineBas = driver.findElement(By.xpath("//input[@name='login']"));
        logineBas.click();

//7)  Uygun hata görüntülenmeli (ör. Geçersiz kullanıcı adı) ve tekrar giriş yapılması istenmelidir.
        String girisBasarisizligiDogrulama= driver.findElement(By.xpath("//li[.='Error: A user could not be found with this email address.']")).getText();
        System.out.println("girisBasarisizligiDogrulama = " + girisBasarisizligiDogrulama);
        String arananDeger="Error: Password is required.";
        Assert.assertTrue(girisBasarisizligiDogrulama.contains(arananDeger));

    }
}

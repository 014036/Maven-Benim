package alistirmalar.automationtesting.account_login.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase07 extends TestBase {
    /*
TEST CASE  7
 7. Login-Handles case sensitive
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter the case changed username in username textbox
5) Enter the case chenged password in the password tetxbox
6) Now click on login button
7) Login must fail saying incorrect username/password.

TEST DURUMU 7
  7. Oturum Açma-Büyük/küçük harfe duyarlı işler
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) Kullanıcı adı metin kutusuna durum değiştirilen kullanıcı adını girin
5) Parola tetxbox'ına büyük/küçük harf değiştirilen parolayı girin
6) Şimdi giriş düğmesine tıklayın
7) Giriş yanlış kullanıcı adı/şifre söyleyerek başarısız olmalıdır.

     */

    @Test
    public void LoginHandlesCaseSensitive() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

//3) Click on My Account Menu  //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

//4) Kullanıcı adı metin kutusuna durum değiştirilen kullanıcı adını girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='username']"));
        emailGir.sendKeys("Gec.ici@hotmail.com");

//5) Parola tetxbox'ına büyük/küçük harf değiştirilen parolayı girin
        WebElement passwordGir = driver.findElement(By.xpath("//*[@class='login']/p[2]/input"));
        passwordGir.sendKeys("mustafa1.?!");

//6) Şimdi giriş düğmesine tıklayın
        WebElement logineBas = driver.findElement(By.xpath("//input[@name='login']"));
        logineBas.click();

//7) Giriş yanlış kullanıcı adı/şifre söyleyerek başarısız olmalıdır.
        String girisBasariliMi= driver.findElement(By.xpath("//li[strong]")).getText();
        String arananDeger="Error: the password you entered for the username Gec.ici@hotmail.com is incorrect.";
        Assert.assertTrue(girisBasariliMi.contains(arananDeger));
  }
}

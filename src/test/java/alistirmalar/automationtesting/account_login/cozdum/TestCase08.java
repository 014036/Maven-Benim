package alistirmalar.automationtesting.account_login.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase08 extends TestBase {
    /*
TEST CASE  8
 8. Login-Authentication
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter the case changed username in username textbox
5) Enter the case chenged password in the password tetxbox
6) Now click on login button
7) Once your are logged in, sign out of the site
8) Now press back button
9) User shouldn’t be signed in to his account rather a general webpage must be visible

TEST DURUMU 8
  8. Oturum Açma-Kimlik Doğrulama
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) Kullanıcı adı metin kutusuna durum değiştirilen kullanıcı adını girin
5) Parola tetxbox'ına büyük/küçük harf değiştirilen parolayı girin
6) Şimdi giriş düğmesine tıklayın
7) Giriş yaptıktan sonra siteden çıkış yapın
8) Şimdi geri düğmesine basın
9) Kullanıcı hesabında oturum açmamalı, bunun yerine genel bir web sayfası görünür olmalıdır
     */

    @Test
    public void loginAuthentication() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

//3) Click on My Account Menu  //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

//4)  Kullanıcı adı metin kutusuna durum değiştirilen kullanıcı adını girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='username']"));
        emailGir.sendKeys("gec.ici@hotmail.com");

//5) Parola tetxbox'ına büyük/küçük harf değiştirilen parolayı girin
        WebElement passwordGir = driver.findElement(By.xpath("//*[@class='login']/p[2]/input"));
        passwordGir.sendKeys("Mustafa1.?!");

//6) Şimdi giriş düğmesine tıklayın
        WebElement logineBas = driver.findElement(By.xpath("//input[@name='login']"));
        logineBas.click();

//7) Giriş yaptıktan sonra siteden çıkış yapın
        driver.findElement(By.xpath("//li/a[@href='https://practice.automationtesting.in/my-account/customer-logout/']")).click();

//8) Şimdi geri düğmesine basın
        driver.navigate().back();

//9) Kullanıcı hesabında oturum açmamalı, bunun yerine genel bir web sayfası görünür olmalıdır
        WebElement homePageGorunurMu = driver.findElement(By.xpath("//div[@id='content']"));

        Assert.assertTrue(homePageGorunurMu.isDisplayed());
    }
}

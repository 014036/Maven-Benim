package alistirmalar.automationtesting.my_account.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase01 extends TestBase {

    /*

TEST CASE 1
1. My Accounts-Dashboard
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter registered username in username textbox
5) Enter password in password textbox
6) Click on login button
7) User must successfully login to the web page
8) Click on Myaccount link which leads to Dashboard
9) User must view Dashboard of the site


TEST DURUMU 1
1. Hesaplarım-Dashboard
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) Kullanıcı adı metin kutusuna kayıtlı kullanıcı adını girin
5) Şifre metin kutusuna şifreyi girin
6) Giriş düğmesine tıklayın
7) Kullanıcı web sayfasına başarılı bir şekilde giriş yapmalıdır.
8) Gösterge Tablosuna götüren Hesabım bağlantısına tıklayın
9) Kullanıcı, sitenin Gösterge Tablosunu görüntülemelidir


     */

    @Test
    public void kullaniciKayit() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

//3) Click on My Account Menu  //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

//4) Enter registered username in username textbox //4) Kullanıcı adı metin kutusuna kayıtlı kullanıcı adını girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='username']"));
        emailGir.sendKeys("gec.ici@hotmail.com");

//5) Enter password in password textbox //5) Şifre metin kutusuna şifreyi girin
        WebElement passwordGir = driver.findElement(By.xpath("//*[@class='login']/p[2]/input"));
        passwordGir.sendKeys("Mustafa1.?!");

//6) Click on login button //6) Giriş düğmesine tıklayın
        WebElement logineBas = driver.findElement(By.xpath("//input[@name='login']"));
        logineBas.click();
//7) User must successfully login to the web page //7) Kullanıcı web sayfasına başarılı bir şekilde giriş yapmalıdır.
        String girisBasariliMi= driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText();
        String arananDeger="Hello";
        Assert.assertTrue(girisBasariliMi.contains(arananDeger));

//8) Click on Myaccount link which leads to Dashboard //8) Gösterge Tablosuna götüren Hesabım bağlantısına tıklayın
        driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/my-account/']")).click();


//9) User must view Dashboard of the site  //9) Kullanıcı, sitenin Gösterge Tablosunu görüntülemelidir

WebElement dashboardGorunurMu= driver.findElement(By.xpath("//nav[@class='woocommerce-MyAccount-navigation']"));
Assert.assertTrue(dashboardGorunurMu.isDisplayed());





    }


}

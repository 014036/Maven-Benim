package alistirmalar.automationtesting.my_account.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase02 extends TestBase {

    /*
TEST CASE 2
2. My Accounts-Orders
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter registered username in username textbox
5) Enter password in password textbox
6) Click on login button
7) User must successfully login to the web page
8) Click on Myaccount link
9) Click on Orders link
10) User must view their orders on clicking orders link




TEST DURUMU 2
2. Hesaplarım-Siparişlerim
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) Kullanıcı adı metin kutusuna kayıtlı kullanıcı adını girin
5) Şifre metin kutusuna şifreyi girin
6) Giriş düğmesine tıklayın
7) Kullanıcı web sayfasına başarılı bir şekilde giriş yapmalıdır.
8) Hesabım bağlantısına tıklayın
9) Siparişler bağlantısını tıklayın
10) Kullanıcı, siparişler bağlantısını tıklayarak siparişlerini görmelidir.
     */

    @Test
    public void test01() {

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
        String girisBasariliMi=driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText();
        String arananDeger="Hello";
        Assert.assertTrue(girisBasariliMi.contains(arananDeger));

        //8) Hesabım bağlantısına tıklayın
        driver.findElement(By.xpath("//div/div/nav/ul/li/a[@href='https://practice.automationtesting.in/my-account/']")).click();




//        //BU ASAMADA DAHA ONCE GIRILEN BILGILERI ALMADIGI ICIN TEKRAR GIRMEK ADINA 18 TESCASEYI TEKRAR ETMEK ICIN KOPYALA
//        driver.findElement(By.xpath("//p/a[@href='https://practice.automationtesting.in/my-account/edit-address/']")).click();//adresguncelleme sayfasi
//        driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/my-account/edit-address/billing']")).click();//adresguncelleme sayfasi-2
//        WebElement billingsDetailName = driver.findElement(By.id("billing_first_name"));
//        billingsDetailName.sendKeys("Kemal");
//        WebElement billingsDetailLastName = driver.findElement(By.id("billing_last_name"));
//        billingsDetailLastName.sendKeys("Can");
//        WebElement billingsDetailCompany = driver.findElement(By.id("billing_company"));
//        billingsDetailCompany.sendKeys("Turkey");
////        WebElement billingsDetailEmail = driver.findElement(By.id("billing_email"));
////        billingsDetailEmail.sendKeys("gec.ici@hotmail.com");
//        WebElement billingsDetailPhone = driver.findElement(By.id("billing_phone"));
//        billingsDetailPhone.sendKeys("053615823700");
//
//        driver.findElement(By.xpath("//*[@role='presentation']")).click();
//
//        driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]")).sendKeys("Turkey", Keys.ENTER);
//
//        WebElement adress = driver.findElement(By.xpath("//input[@name='billing_address_1']"));
//        adress.sendKeys("Kutahya");
//        WebElement adress2 = driver.findElement(By.xpath("//input[@id='billing_address_2']"));
//        adress2.sendKeys("Merkez");
//        WebElement postaCode = driver.findElement(By.xpath("//input[@id='billing_postcode']"));
//        postaCode.sendKeys("43200");
//        WebElement townCity = driver.findElement(By.xpath("//input[@id='billing_city']"));
//        townCity.sendKeys("Herhangi bir yer");
//        townCity.sendKeys(Keys.TAB, Keys.ENTER, "Balıkesir", Keys.ENTER); //Province *
//    driver.findElement(By.xpath("//input[@name='save_address']")).click();


        //9) Siparişler bağlantısını tıklayın
        driver.findElement(By.xpath("//li/a[@href='https://practice.automationtesting.in/my-account/orders/']")).click();

        //10) Kullanıcı, siparişler bağlantısını tıklayarak siparişlerini görmelidir.
        WebElement siparislerGorunurMu= driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
        Assert.assertTrue(siparislerGorunurMu.isDisplayed());
    }
}





package alistirmalar.automationtesting.account_registra.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase05 extends TestBase {

    /*
TEST CASE 5
5. Registration with empty Email-id & password
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter empty Email Address in Email-Address textbox
5) Enter empty password in password textbox
6) Click on Register button
7) Registration must fail with a warning message(ie please provide valid email address)


TEST DURUMU 5
5. Boş E-posta kimliği ve şifre ile kayıt
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) E-posta Adresi metin kutusuna boş E-posta Adresi girin
5) Şifre metin kutusuna boş şifreyi girin
6) Kayıt Ol düğmesine tıklayın
7) Kayıt, bir uyarı mesajı ile başarısız olmalıdır (örn. lütfen geçerli bir e-posta adresi girin)

     */

    @Test
    public void emptyEmailAndPassword() {

        //2) "http://practice.automationtesting.in/" URL'sini girin
        driver.get("http://practice.automationtesting.in/");

        //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

        //4) E-posta Adresi metin kutusuna boş E-posta Adresi girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailGir.sendKeys("");

        //5) Şifre metin kutusuna boş şifreyi girin
        WebElement passwordGir = driver.findElement(By.xpath("//input[@id='reg_password']"));
        passwordGir.sendKeys("");

        //6) Kayıt Ol düğmesine tıklayın
        driver.findElement(By.xpath("//input[@name='register']")).click();

        //7)  Kayıt, bir uyarı mesajı ile başarısız olmalıdır (örn. lütfen geçerli bir e-posta adresi girin)
        String emptyEmailAndPassword = driver.findElement(By.xpath("//li[.='Error: Please provide a valid email address.']")).getText();
        System.out.println("emptyEmailAndPassword = " + emptyEmailAndPassword);
        String arananDeger = "Error: Please provide a valid email address.";
        Assert.assertTrue(emptyEmailAndPassword.contains(arananDeger));
    }
}

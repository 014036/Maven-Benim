package alistirmalar.automationtesting.account_login.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase05 extends TestBase {
    /*
TEST CASE  5
5. Log-in with empty username and empty password.
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter empty username in username textbox
5) Now enter valid password in the password textbox
6) Click on login button.
7) Proper error must be displayed(ie required username) and prompt to enter login again

TEST DURUMU 5
5. Boş kullanıcı adı ve boş şifre ile oturum açın.
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) Kullanıcı adı metin kutusuna boş kullanıcı adını girin
5) Şimdi şifre metin kutusuna bos şifreyi girin
6) Oturum aç düğmesine tıklayın.
7) Uygun hata görüntülenmeli (örn. gerekli kullanıcı adı) ve tekrar giriş yapılması istenmelidir
     */
    @Test
    public void emptyUsernameAndEmptyPassword() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

//3) Click on My Account Menu  //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();

//4) Kullanıcı adı metin kutusuna boş kullanıcı adını girin
        WebElement emailGir = driver.findElement(By.xpath("//input[@id='username']"));
        emailGir.sendKeys("");

//5) Şimdi şifre metin kutusuna bos şifreyi girin
        WebElement passwordGir = driver.findElement(By.xpath("//*[@class='login']/p[2]/input"));
        passwordGir.sendKeys("");

//6) Oturum aç düğmesine tıklayın.
        WebElement logineBas = driver.findElement(By.xpath("//input[@name='login']"));
        logineBas.click();
//7) Uygun hata görüntülenmeli (örn. gerekli kullanıcı adı) ve tekrar giriş yapılması istenmelidir
        String bosUserName= driver.findElement(By.xpath("//li[.='Error: Username is required.']")).getText();
        System.out.println("bosUserName = " + bosUserName);
        String arananDeger="Error: Username is required.";
        Assert.assertTrue(bosUserName.contains(arananDeger));

    }

}

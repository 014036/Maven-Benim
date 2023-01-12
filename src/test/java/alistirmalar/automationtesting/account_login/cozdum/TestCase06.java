package alistirmalar.automationtesting.account_login.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase06 extends TestBase {
    /*
TEST CASE  6
 6. Log-in -Password should be masked
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on My Account Menu
4) Enter the password field with some characters.
5) The password field should display the characters in asterisks or bullets such that the password is not visible on
 the screen

TEST DURUMU 6
  6. Oturum açma -Şifre maskelenmelidir
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Hesabım Menüsüne tıklayın
4) Bazı karakterlerle şifre alanına girin.
5) Parola alanında, parola ekranda görünmeyecek şekilde yıldız veya madde işareti içindeki karakterler gösterilmelidir.
     */

    @Test
    public void passwordShouldBeMasked() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

//3) Click on My Account Menu  //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();



//4) Bazı karakterlerle şifre alanına girin.
        WebElement passwordGir = driver.findElement(By.xpath("//*[@class='login']/p[2]/input"));
        passwordGir.sendKeys("Mustafa1.?!");


//5) Parola alanında, parola ekranda görünmeyecek şekilde yıldız veya madde işareti içindeki karakterler gösterilmelidir.
        WebElement sifreGizliGorunurMu= driver.findElement(By.xpath("//input[@id='password']"));
        Assert.assertTrue(sifreGizliGorunurMu.isDisplayed());

    }
}

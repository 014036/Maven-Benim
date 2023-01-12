package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Sayfa_109Handle extends TestBase {
    /*
    ● Tests package’inda yeni bir class olusturun: WindowHandle2
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
doğrulayın.
     */

    @Test
    public void windowHandle2() {

//https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String windowHandle1 = driver.getWindowHandle();

// Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expextedText = "Opening a new window";
        Assert.assertEquals(expextedText, actualText);

// Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

// Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

// Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        //ONCE YENI SAYFAYA GECELIM
        Set<String> allHandles= driver.getWindowHandles();
        for (String w: allHandles){
            if (!w.equals(windowHandle1)){
                driver.switchTo().window(w);
                break;
            } }

// Sayfadaki textin “New Window” olduğunu doğrulayın.
    String actualTextWindow2=    driver.findElement(By.xpath("//h3")).getText();
        String expectedText2= "New Window";
        Assert.assertEquals(expectedText2,actualTextWindow2);

// Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowHandle1);
        String actualTitleSon = driver.getTitle();
        String expectedTitleSon = "The Internet";
        Assert.assertEquals(expectedTitleSon, actualTitleSon);
    }
}

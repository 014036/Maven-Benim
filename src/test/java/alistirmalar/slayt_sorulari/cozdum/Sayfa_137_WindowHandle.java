package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Sayfa_137_WindowHandle extends TestBase {

    /*
    1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin
     */



    @Test
    public void windowHandleTest(){
//1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

//2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        WebElement loginPortal= driver.findElement(By.xpath("//h1[.='LOGIN PORTAL']"));
        actions.scrollToElement(loginPortal).build().perform();
     String windowHandle1= driver.getWindowHandle();

//3."Login Portal" a tiklayin
        actions.click(loginPortal).build().perform();

//4.Diger window'a gecin
  List<String> allWindowHandles= new ArrayList<>(driver.getWindowHandles());
  driver.switchTo().window(allWindowHandles.get(1));
 // allWindowHandles.stream().filter(t->!t.equals(windowHandle1)).forEach(t->driver.switchTo().window(t));
//        for (String w: allWindowHandles){
//            if (!w.equals(windowHandle1)){
//                driver.switchTo().window(w);
//            }
//        }
//5."username" ve "password" kutularina deger yazdirin
        //ACTION METHODU PEKISTIRMEK ICIN ONUNLA YAPACAGIM
      WebElement userName=   driver.findElement(By.id("text"));
      actions.sendKeys(userName,"mustafa").build().perform();

     WebElement password=   driver.findElement(By.id("password"));
     actions.sendKeys(password,"01234").build().perform();


//6."login" butonuna basin
        WebElement loginButton=   driver.findElement(By.id("login-button"));
        actions.click(loginButton).build().perform();

//7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualAlertMessage= driver.switchTo().alert().getText();
        System.out.println("actualAlertMessage = " + actualAlertMessage);
        String expectedAlertMessage= "validation failed";
        Assert.assertEquals(expectedAlertMessage, actualAlertMessage);

//8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
waitFor(3);
//9.Ilk sayfaya geri donun
        driver.switchTo().window(windowHandle1);
waitFor(2);
//10.Ilk sayfaya donuldugunu test edin
        WebElement anasayfa= driver.findElement(By.id("udemy-promo-thumbnail"));
        Assert.assertTrue(anasayfa.isDisplayed());
    }
}






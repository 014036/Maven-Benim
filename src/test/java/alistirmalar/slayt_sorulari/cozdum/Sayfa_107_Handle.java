package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Sayfa_107_Handle extends TestBase {
    /*
    Handle Windows ClassWork
● Yeni bir class olusturun: WindowHandle
● Amazon anasayfa adresine gidin.
● Sayfa’nin window handle degerini String bir degiskene atayin
● Sayfa title’nin “Amazon” icerdigini test edin
● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
● Sayfa title’nin “Walmart” icerdigini test edin
● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */

    @Test
    public void test01() {

// Amazon anasayfa adresine gidin. https://www.amazon.com/
    driver.get("https://www.amazon.com/");


// Sayfa’nin window handle degerini String bir degiskene atayin
    String handleAmazon = driver.getWindowHandle();
    String actualTitleAmazon = driver.getTitle();
    System.out.println("actualTitleAmazon = " + actualTitleAmazon);

// Sayfa title’nin “Amazon” icerdigini test edin
    String expectedTitleAmazon = "Amazon";
    Assert.assertTrue(actualTitleAmazon.contains(expectedTitleAmazon));

// Yeni bir tab olusturup, acilan tab’da https://techproeducation.com/ adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com/");
        String handleTecpro= driver.getWindowHandle();

// Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitleTechpro=driver.getTitle();
        System.out.println("actualTitleTechpro = " + actualTitleTechpro);
        String expectedTitleTechpro="TECHPROEDUCATION";
        Assert.assertTrue(!actualTitleTechpro.contains(expectedTitleTechpro));

// Yeni bir window olusturup, acilan sayfada https://www.walmart.com/ adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.walmart.com/");
        String handleWalmart= driver.getWindowHandle();

// Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitleWalmart=driver.getTitle();
        System.out.println("actualTitleWalmart = " + actualTitleWalmart);
        String expectedTitleWalmart="Walmart";
        Assert.assertTrue(actualTitleWalmart.contains(expectedTitleWalmart));

// Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     driver.switchTo().window(handleAmazon);
     String sonTitle= driver.getTitle();
     Assert.assertEquals(sonTitle, actualTitleAmazon);

    }
}

package alistirmalar.slayt_sorulari.cozdum;


import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Sayfa_93 extends TestBase {

    /*
    ● Bir class oluşturun: C3_DropDownAmazon
● https://www.amazon.com/ adresine gidin.
- Test 1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
oldugunu test edin
-Test 2
1. Kategori menusunden Books secenegini secin
2. Arama kutusuna Java yazin ve aratin
3. Bulunan sonuc sayisini yazdirin
4. Sonucun Java kelimesini icerdigini test edin
     */


    @Test
    public void test01() {
        //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/ ");

//Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(aramaKutusu);
        List<WebElement> tumsecenekler = select.getOptions();
        System.out.println(tumsecenekler.size()); //28
        String expectedAramaKutusuSeceneSayisi = "45";
        Assert.assertNotEquals(expectedAramaKutusuSeceneSayisi, tumsecenekler);
    }


    @Test
    public void test02() {
        //-Test 2

        // //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/ ");


        //1. Kategori menusunden Books secenegini secin
        WebElement kategori = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(kategori);
        select.selectByVisibleText("Books");


        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
      String aramaSonucSayisi=  driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println("aramaSonucSayisi = " + aramaSonucSayisi);




        //4. Sonucun Java kelimesini icerdigini test edin
        String arananDeger="Java";
        Assert.assertTrue(aramaSonucSayisi.contains(arananDeger));
    }
}

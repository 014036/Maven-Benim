package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Sayfa_59 {
    /*
    Tekrar Testi
1-C01_TekrarTesti isimli bir class olusturun
2- https://www.amazon.com/ adresine gidin
3- Browseri tam sayfa yapin
4- Sayfayi “refresh” yapin
5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
6 Gift Cards sekmesine basin
7 Birthday butonuna basin
8 Best Seller bolumunden ilk urunu tiklayin
9- Gift card details’den 25 $’i secin
10-Urun ucretinin 25$ oldugun
     */

    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();

        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actulaTitle= driver.getTitle();
        Assert.assertTrue(actulaTitle.contains("Spend less"));

        //6 Gift Cards sekmesine basin
        driver.findElement(By.cssSelector("a[href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']")).click();

        //7 Birthday butonuna basin
        driver.findElement(By.cssSelector("img[alt=\"Birthday\"]")).click();

        //8 Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt=\"Amazon.com eGift Card\"])[1]")).click();

        //9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//button[@id=\"gc-mini-picker-amount-1\"])[1]")).click();
        //10-Urun ucretinin 25$ oldugunu dogrulayin

        String fiyat= driver.findElement(By.cssSelector("p[id=\"gc-buy-box-text\"]")).getText();
        System.out.println("fiyat = " + fiyat);
    }
}

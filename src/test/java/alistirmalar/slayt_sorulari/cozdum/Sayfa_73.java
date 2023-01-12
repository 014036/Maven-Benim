package alistirmalar.slayt_sorulari.cozdum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Sayfa_73 {

    /*
    SAYFA 73
1-
2-https://www.google.com/ adresine gidin
3-cookies uyarisini kabul ederek kapatin
4-Sayfa basliginin “Google ”ifadesi icerdigini test edin
5-Arama cubuguna “Nutella” yazip aratin
6-Bulunan sonuc sayisini yazdirin
7-sonuc sayisinin 10milyon’dan fazla oldugunu test edin
8-Sayfayi kapatin
     */
    static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//    2-https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
    }


    @Test
    public void test01() {
        //    4-Sayfa basliginin “Google ”ifadesi icerdigini test edin
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Google"));

        //    5-Arama cubuguna “Nutella” yazip aratin
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaSonucu.sendKeys("Nutella", Keys.ENTER);

        //    6-Bulunan sonuc sayisini yazdirin
        String aramaSonucSayisi= driver.findElement(By.xpath("//*[@id='result-stats']")).getText().replace(".","").split(" ")[1];
       // System.out.println("aramaSonucSayisi[1] = " + aramaSonucSayisi[1]);
//        String sonuc= aramaSonucSayisi[1];
//        sonuc=sonuc.replaceAll("\\D","");
        int expected= Integer.valueOf(aramaSonucSayisi);
        System.out.println("expected = " + expected);


//
//        //    7-sonuc sayisinin 10milyon’dan fazla oldugunu test edin

Assert.assertTrue(expected>10000000);

//sayfayi kapatin
        driver.close();
    }
}

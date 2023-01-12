package alistirmalar.automationtesting.anasayfa.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class TestCase01 extends TestBase {
/*
TEST CASE 1
 1. Home Page with three Sliders only
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Sliders only
6) The Home page must contains only three sliders

  1. Yalnızca üç Sürgü içeren Ana Sayfa
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Şimdi Ana menü düğmesine tıklayın
5) Ana sayfada yalnızca Üç Kaydırıcı olup olmadığını test edin
6) Ana sayfa yalnızca üç kaydırıcı içermelidir

 */


    @Test
    public void test01() throws InterruptedException {
//        2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");


//        3) Click on Shop Menu
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in/shop/'])[1]")).click();


//        4) Now click on Home menu button
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in'])[2]")).click();


//        5) Test whether the Home page has Three Sliders only
        int sliderSayisi = driver.findElements(By.xpath("//div[@class='n2-ss-slider-3']/div")).size();
        System.out.println("sliderSayisi = " + sliderSayisi);
        int expected = 3;
//        6) The Home page must contains only three sliders
        Assert.assertEquals(expected, sliderSayisi);
    }


}

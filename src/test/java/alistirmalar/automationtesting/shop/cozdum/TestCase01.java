package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestCase01 extends TestBase {

    /*
TEST CASE 1
1. Shop-Filter By Price Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Adjust the filter by price between 150 to 450 rps
5) Now click on Filter button
6) User can view books only between 150 to 450 rps price




TEST DURUMU 1
1. Fiyat İşlevselliğine Göre Mağaza Filtresi
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Filtreyi fiyata göre 150 ila 450 rps arasında ayarlayın
5) Şimdi Filtre düğmesine tıklayın
6) Kullanıcı sadece 150 ila 450 rps fiyatı arasındaki kitapları görüntüleyebilir.


     */

    @Test
    public void filterByPriceFunctionality() {

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Filtreyi fiyata göre 150 ila 450 rps arasında ayarlayın
//
        WebElement slidersol = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[1]"));
        WebElement slidersag = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        WebElement ads = driver.findElement(By.xpath("//*[@id='max_price']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", ads);
        ads.clear();
        ads.sendKeys("450");
   //5) Şimdi Filtre düğmesine tıklayın
        driver.findElement(By.xpath("//button[@class='button']")).click();
    //6) Kullanıcı sadece 150 ila 450 rps fiyatı arasındaki kitapları görüntüleyebilir.
        List<WebElement> price = driver.findElements(By.xpath("//*[@class=\"price\"]/*"));
        price.stream().filter(t -> !t.getTagName().equals("del")).forEach(t -> System.out.println(t.getText()));

    }
}
package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase08 extends TestBase {

    /*
TEST CASE 8
8. Shop-Read More Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Click on read more button in home page
5) Read More option indicates the Out Of Stock.
6) User cannot add the product which has read more option as it was out of stock.




TEST DURUMU 8
8. Mağaza-Daha Fazla Oku İşlevselliği
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Ana sayfadaki devamını oku düğmesine tıklayın
5) Devamını Oku seçeneği Tükendi'yi gösterir.
6) Kullanıcı, devamını oku seçeneği olan ürünü stokta kalmadığı için ekleyemez.
     */


    @Test
    public void readMoreFunctionality() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Ana sayfadaki devamını oku düğmesine tıklayın
        driver.findElement(By.xpath("//nav/a[@href='https://practice.automationtesting.in']")).click();//anasayfaya git
        driver.findElement(By.xpath("//a[@data-product_id='160']")).click();//Devamini oku'ya tiklar

        //5) Devamını Oku seçeneği Tükendi'yi gösterir.
        String stokDurumu = driver.findElement(By.xpath("//div[@class='summary entry-summary']/p")).getText();
        System.out.println("stokDurumu = " + stokDurumu);
        String expected = "Out of stock";
        Assert.assertEquals(expected, stokDurumu);

        //6) Kullanıcı, devamını oku seçeneği olan ürünü stokta kalmadığı için ekleyemez.

//        WebElement addToBasketButton= driver.findElement(By.xpath("//button[.='Add to basket']"));
//        Assert.assertFalse(!addToBasketButton.isDisplayed());
        String addToBasketVarmi = driver.findElement(By.id("content")).getText();
        System.out.println("addToBasketVarmi = " + addToBasketVarmi);
        Assert.assertTrue(!addToBasketVarmi.contains("ADD TO BASKET"));
    }
}

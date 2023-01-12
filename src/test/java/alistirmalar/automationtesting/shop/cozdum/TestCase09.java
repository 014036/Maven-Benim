package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class TestCase09 extends TestBase {

    /*
TEST CASE 9
9. Shop-Sale Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Click on Sale written product in home page
5) User can clearly view the actual price with old price striken for the sale written products



TEST DURUMU 9
9. Mağaza-Satış İşlevselliği
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Ana sayfada Satış yazan ürüne tıklayın
5) Kullanıcı, satış yazılı ürünler için eski fiyat ile gerçek fiyatı net bir şekilde görüntüleyebilir


     */

    @Test
    public void shopSaleFunctionality() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Ana sayfada Satış (Sale) yazan ürüne tıklayın
        //ONCE ANASAYFAYA GIDELIM
        driver.findElement(By.xpath("//nav/a[@href='https://practice.automationtesting.in']")).click();//anasayfaya git

//        //ANASAYFADAKI URUNLERI ALALIM
//        List<WebElement>  anaSayfadakiUrunler= driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
//        System.out.println("anaSayfadakiUrunler.size() = " + anaSayfadakiUrunler.size());
//        List<String>urunler= new ArrayList<>();
//        for (WebElement w: anaSayfadakiUrunler){
//            urunler.add(w.getText());
//        }
//        System.out.println("urunler = " + urunler);

        //SALE YAZAN urune tiklamak icin
        driver.findElement(By.xpath("//span[@class='onsale']")).click();
        //5) Kullanıcı, satış yazılı ürünler için eski fiyat ile gerçek fiyatı net bir şekilde görüntüleyebilir
        WebElement priceGorunurMu = driver.findElement(By.xpath("//*[@class='price']"));
        Assert.assertTrue(priceGorunurMu.isDisplayed());

        String price = driver.findElement(By.xpath("//*[@class='price']")).getText();
        System.out.println("price = " + price);
    }
}

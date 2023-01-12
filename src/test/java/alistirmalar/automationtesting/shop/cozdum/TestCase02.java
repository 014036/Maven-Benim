package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCase02 extends TestBase {

    /*
TEST CASE  2
2. Shop-Product Categories Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Click any of the product links available in the product category
5) Now user can view only that particular product




TEST DURUMU 2
2. Mağaza-Ürün Kategorileri İşlevselliği
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Ürün kategorisinde bulunan ürün bağlantılarından herhangi birine tıklayın
5) Artık kullanıcı yalnızca söz konusu ürünü görüntüleyebilir
  */


    @Test
    public void categoriesFunctionality() {
        //2) Enter the URL "http://practice.automationtesting.in/"
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Ürün kategorisinde bulunan ürün bağlantılarından herhangi birine tıklayın
        WebElement categorie = driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/product-category/html/']"));
        String ctg = categorie.getText();
        categorie.click();

        //5) Artık kullanıcı yalnızca söz konusu ürünü görüntüleyebilir
        List<WebElement> elemanSayisi = driver.findElements(By.xpath("//h3"));   //h3[contains(text(),'"+ctg+"')] --> isDisplayed
        for(int i=0; i<elemanSayisi.size(); i++){
            Assert.assertTrue(elemanSayisi.get(i).getText().contains(ctg));
        }
    }
}

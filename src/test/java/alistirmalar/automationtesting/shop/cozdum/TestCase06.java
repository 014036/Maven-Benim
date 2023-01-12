package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase06 extends TestBase {

    /*

TEST CASE 6
6. Shop-Default Sorting Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Click on Sort by Low to High Item in Default sorting dropdown
5) Now user can view the popular products only


TEST DURUMU 6
6. Shop-Varsayılan Sıralama İşlevselliği
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Varsayılan sıralama açılır menüsünde Düşükten Yükseğe Öğeye Göre Sırala'ya tıklayın
5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir

     */



    @Test
    public void sortingFunctionality()  {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Varsayılan sıralama açılır menüsündeki Yenilik derecelerine göre sırala seçeneğine tıklayın

        WebElement ddm = driver.findElement(By.xpath("//select[@name='orderby']"));
        Select select = new Select(ddm);

        select.selectByVisibleText("Sort by price: low to high");

        String actualPriceLowToHighSorting = driver.findElement(By.xpath("//option[.='Sort by price: low to high']")).getText();
        System.out.println("actualPriceLowToHighSorting = " + actualPriceLowToHighSorting);

        //5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir
        String expectedPriceLowToHighSorting = "Sort by price: low to high";
        Assert.assertEquals(expectedPriceLowToHighSorting, actualPriceLowToHighSorting);

    }
}

package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase07 extends TestBase {

    /*
TEST CASE 7
7. Shop-Default Sorting Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Click on Sort by High to Low Item in Default sorting dropdown
5) Now user can view the popular products only



TEST DURUMU 7
7. Shop-Varsayılan Sıralama İşlevselliği
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Varsayılan sıralama açılır menüsünde Yüksekten Alçak Öğeye Göre Sırala'ya tıklayın
5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir
    */

    //Sort by price: high to low


    @Test
    public void sortingFunctionality()  {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Varsayılan sıralama açılır menüsünde Yüksekten Alçak Öğeye Göre Sırala'ya tıklayın

        WebElement ddm = driver.findElement(By.xpath("//select[@name='orderby']"));
        Select select = new Select(ddm);

        select.selectByVisibleText("Sort by price: high to low");

        String actualPriceHighToLowSorting = driver.findElement(By.xpath("//option[.='Sort by price: high to low']")).getText();
        System.out.println("actualPriceHighToLowSorting = " + actualPriceHighToLowSorting);

        //5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir
        String expectedPriceHighToLowSorting = "Sort by price: high to low";
        Assert.assertEquals(expectedPriceHighToLowSorting, actualPriceHighToLowSorting);

    }
}

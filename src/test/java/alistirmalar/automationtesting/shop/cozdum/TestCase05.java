package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase05 extends TestBase {

    /*
TEST CASE 5
5. Shop-Default Sorting Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Click on Sort by Newness ratings in Default sorting dropdown
5) Now user can view the popular products only




TEST DURUMU 5
5. Shop-Varsayılan Sıralama İşlevselliği
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Varsayılan sıralama açılır menüsündeki Yenilik derecelerine göre sırala seçeneğine tıklayın
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

        select.selectByVisibleText("Sort by newness");

        String newnessSorting = driver.findElement(By.xpath("//option[.='Sort by newness']")).getText();
        System.out.println("averageRatingSorting = " + newnessSorting);

        //5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir
        String expectedNewnessSorting = "Sort by newness";
        Assert.assertEquals(expectedNewnessSorting, newnessSorting);

    }
}

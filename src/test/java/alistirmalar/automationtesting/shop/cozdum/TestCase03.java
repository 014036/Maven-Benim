package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase03 extends TestBase {

    /*
TEST CASE  3
3. Shop-Default Sorting Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Click on Sort by Popularity item in Default sorting dropdown
5) Now user can view the popular products only




TEST DURUMU 3
3. Shop-Varsayılan Sıralama İşlevselliği
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Varsayılan sıralama açılır menüsünde Popülerliğe Göre Sırala öğesine tıklayın
5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir

     */

    @Test
    public void sortingFunctionality()  {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");
        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();
        //4) Varsayılan sıralama açılır menüsünde Popülerliğe Göre Sırala öğesine tıklayın
        WebElement ddm = driver.findElement(By.xpath("//select[@name='orderby']"));
        Select select = new Select(ddm);
        String actualYazi = select.getFirstSelectedOption().getText();
        System.out.println(actualYazi);
        String expectedDefaultYazisi = "Default sorting";
        Assert.assertEquals(expectedDefaultYazisi, actualYazi);
        //populerlige gore siralamak icin
        select.selectByVisibleText("Sort by popularity");
        WebElement ddm1 = driver.findElement(By.xpath("//select[@name='orderby']"));
        Select select1 = new Select(ddm1);
        System.out.println(select1.getFirstSelectedOption().getText());
        String populartYazisi = driver.findElement(By.xpath("//*[@id=\"content\"]/form/select/option[2]")).getText();
        System.out.println("populartYazisi = " + populartYazisi);
        //5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir
        String expectedPopulerYazisi = "Sort by popularity";
        Assert.assertEquals(expectedPopulerYazisi, populartYazisi);
    }
}

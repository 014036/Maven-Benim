package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TestCase04 extends TestBase {

    /*
TEST CASE 4
4. Shop-Default Sorting Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Click on Sort by Average ratings in Default sorting dropdown
5) Now user can view the popular products only



TEST DURUMU 4
4. Shop-Varsayılan Sıralama İşlevselliği
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Varsayılan sıralama açılır menüsündeki Ortalama derecelendirmelere göre sırala seçeneğine tıklayın
5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir
 */


    @Test
    public void sortingFunctionality()  {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Varsayılan sıralama açılır menüsündeki Ortalama derecelendirmelere göre sırala seçeneğine tıklayın

        WebElement ddm = driver.findElement(By.xpath("//select[@name='orderby']"));
        Select select = new Select(ddm);

        select.selectByVisibleText("Sort by average rating");

        String averageRatingSorting = driver.findElement(By.xpath("//*[@id=\"content\"]/form/select/option[3]")).getText();
        System.out.println("averageRatingSorting = " + averageRatingSorting);

        //5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir


        String expectedAverageRatingSorting = "Sort by average rating";
        Assert.assertEquals(expectedAverageRatingSorting, averageRatingSorting);

    }
}

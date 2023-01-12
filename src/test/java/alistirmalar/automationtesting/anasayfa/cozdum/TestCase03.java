package alistirmalar.automationtesting.anasayfa.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase03 extends TestBase {

    /*



TEST CASE 3
 3. Home page - Images in Arrivals should navigate

1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket





TEST DURUMU 3
  3. Ana sayfa - Varışlardaki resimler gezinmelidir

1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Şimdi Ana menü düğmesine tıklayın
5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
6) Ana sayfa yalnızca üç Varış içermelidir
7) Şimdi Gelenler bölümündeki resme tıklayın
8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
9)  kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
  */


    @Test
    public void test01() throws InterruptedException {

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //  3) Click on Shop Menu
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in/shop/'])[1]")).click();

        clickOutside();
        Thread.sleep(3000);

        //4) Now click on Home menu button
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in'])[2]")).click();

        //5) Test whether the Home page has Three Arrivals only
        int arrivals = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
        System.out.println("arrivals = " + arrivals);

        //6) The Home page must contains only three Arrivals
        Assert.assertTrue(arrivals == 3);

        //7) Now click the image in the Arrivals
        driver.findElement(By.xpath("//*[@href='https://practice.automationtesting.in/product/selenium-ruby/']")).click();

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        WebElement urunEkliMi = driver.findElement(By.xpath("//*[@id='product-160']"));
        Assert.assertTrue(urunEkliMi.isDisplayed());

        //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        WebElement urunUlasilabilirMi = driver.findElement(By.xpath("//*[@href='https://practice.automationtesting.in/product/selenium-ruby/']"));
        Assert.assertTrue(urunUlasilabilirMi.isEnabled());
        //  driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();//sepete ekleme(bunu mu soruyor anlamadim)
    }

}

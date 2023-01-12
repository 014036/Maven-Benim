package alistirmalar.automationtesting.anasayfa.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase05 extends TestBase {

  /*
TEST CASE 5
 5. Home page - Arrivals-Images-Reviews
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
10) Now clock on Reviews tab for the book you clicked on.
11) There should be a Reviews regarding that book the user clicked on

TEST DURUMU 5
  5. Ana sayfa - Gelenler-Resimler-İncelemeler
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Şimdi Ana menü düğmesine tıklayın
5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
6) Ana sayfa yalnızca üç Varış içermelidir
7) Şimdi Gelenler bölümündeki resme tıklayın
8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
10) Şimdi tıkladığınız kitap için İncelemeler sekmesinde saat.
11) Kullanıcının tıkladığı kitapla ilgili bir İnceleme olmalı


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

        //7) Now click the image in the Arrivals --Şimdi Gelenler bölümündeki resme tıklayın
        driver.findElement(By.xpath("//*[@href='https://practice.automationtesting.in/product/selenium-ruby/']")).click();

        //8) Image should be clickable and shoul navigate to next page where user can add that book to his basket
        //Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
        WebElement urunUlasilabilirMi = driver.findElement(By.xpath("//*[@href='https://practice.automationtesting.in/product/selenium-ruby/']"));
        Assert.assertTrue(urunUlasilabilirMi.isEnabled());

        //9)   Test whether it is navigating to next page where the user can add that book into his basket.
        //Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
        WebElement urunEkliMi = driver.findElement(By.xpath("//*[@id='content']"));
        Assert.assertTrue(urunEkliMi.isDisplayed());

//10) Now clock on Reviews tab for the book you clicked on.
        //10) Şimdi tıkladığınız kitap için İncelemeler sekmesinde saat.
        driver.findElement(By.xpath("//a[@href='#tab-reviews']")).click();

//11) There should be a Reviews regarding that book the user clicked on
        //11) Kullanıcının tıkladığı kitapla ilgili bir İnceleme olmalı
        WebElement urunReviews= driver.findElement(By.id("tab-reviews"));
        Assert.assertTrue(urunReviews.isDisplayed());
    }
}

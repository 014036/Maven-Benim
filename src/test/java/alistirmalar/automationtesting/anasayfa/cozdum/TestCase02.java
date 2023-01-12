package alistirmalar.automationtesting.anasayfa.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCase02 extends TestBase {

/*
    TEST CASE2
 2. Home page with three Arrivals only
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
            3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals




TEST VAKA2
  2. Yalnızca üç Varış içeren ana sayfa
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Şimdi Ana menü düğmesine tıklayın
5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
6) Ana sayfa yalnızca üç Varış içermelidir
*/

    @Test
    public void test01() throws InterruptedException {
        //        2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");


//        3) Click on Shop Menu
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in/shop/'])[1]")).click();

        clickOutside();
        Thread.sleep(3000);

        //4) Now click on Home menu button
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in'])[2]")).click();

        //5) Test whether the Home page has Three Arrivals only
        int arrivals= driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
        System.out.println("arrivals = " + arrivals);

        //6) The Home page must contains only three Arrivals
        Assert.assertTrue(arrivals==3);

    }
}

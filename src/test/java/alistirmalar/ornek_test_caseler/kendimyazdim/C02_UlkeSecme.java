package alistirmalar.ornek_test_caseler.kendimyazdim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_UlkeSecme extends TestBase {

    /*
     1- https://testcenter.techproeducation.com/index.php adresine git
     2- Autocomplete basligina tikla
     3- gelen ekranda Autocomplete yazisinin varligini dogrula
     4-Country yazan kutucuga  deger yazma
     5-Submit butonuna tikla
     6- 'You selected:' yazisini varligini dogrula
     */

     /*
     TEST 2
     1- https://testcenter.techproeducation.com/index.php adresine git
     2- Autocomplete basligina tikla
     3- gelen ekranda Autocomplete yazisinin varligini dogrula
     4-Country yazan kutucuga 'Turkey' yazisini gonder
     5-Submit butonuna tikla
     6- 'You selected: Turkey' yazisini varligini dogrula
     */

    @Test
    public void test01() {

  //     1- https://testcenter.techproeducation.com/index.php adresine git
       driver.get("https://testcenter.techproeducation.com/index.php");

//     2- Autocomplete basligina tikla
        driver.findElement(By.xpath("//a[@href='index.php?page=autocomplete']")).click();

//     3- gelen ekranda Autocomplete yazisinin varligini dogrula
        String actualYazi1= driver.findElement(By.xpath("//h3")).getText();
        String expectedYazi1="Autocomplete";
        Assert.assertEquals(expectedYazi1,actualYazi1);

//     4-Country yazan kutucuga  deger yazma
        WebElement country= driver.findElement(By.id("myCountry"));
        country.sendKeys("");

//     5-Submit butonuna tikla
        driver.findElement(By.xpath("//input[@onclick='log()']")).click();

//     6- 'You selected:' yazisini varligini dogrula
        String actualResult= driver.findElement(By.id("result")).getText();
        String expectedResult= "You selected:";
        Assert.assertEquals(expectedResult, actualResult);

    }



    @Test
    public void test02() {

        //     1- https://testcenter.techproeducation.com/index.php adresine git
        driver.get("https://testcenter.techproeducation.com/index.php");

//     2- Autocomplete basligina tikla
        driver.findElement(By.xpath("//a[@href='index.php?page=autocomplete']")).click();

//     3- gelen ekranda Autocomplete yazisinin varligini dogrula
        String actualYazi1= driver.findElement(By.xpath("//h3")).getText();
        String expectedYazi1="Autocomplete";
        Assert.assertEquals(expectedYazi1,actualYazi1);

//     4-Country yazan kutucuga 'Turkey' yazisini gonder
        WebElement country= driver.findElement(By.id("myCountry"));
        country.sendKeys("Turkey");

//     5-Submit butonuna tikla
        driver.findElement(By.xpath("//input[@onclick='log()']")).click();

//     6- 'You selected: Turkey' yazisini varligini dogrula
        String actualResult= driver.findElement(By.id("result")).getText();
        String expectedResult= "You selected: Turkey";
        Assert.assertEquals(expectedResult, actualResult);

    }
}

package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase09 {

    /*
    Test Case 9: Search Product
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
****************************************************

     */
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu= driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()){
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        }else  System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

        //4. Click on 'Products' button
        driver.findElement(By.cssSelector("a[href='/products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsYazisiVarMi= driver.findElement(By.xpath("//*[text()='All Products']"));
        System.out.println("allProductsYazisiVarMi.getText() = " + allProductsYazisiVarMi.getText());
        if (allProductsYazisiVarMi.isDisplayed()){
            System.out.println("allProductsYazisiVarMi Tetsi PASSED");
        }else  System.out.println("allProductsYazisiVarMi Tetsi FAILED");


        //6. Enter product name in search input and click search button
       WebElement aranacakUrunGir=driver.findElement(By.cssSelector("input[id='search_product']")) ;
       aranacakUrunGir.sendKeys("Men Tshirt");
       driver.findElement(By.cssSelector("button[id='submit_search']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProductGorunurMu= driver.findElement(By.cssSelector("h2[class='title text-center']"));

        if (searchedProductGorunurMu.isDisplayed()){
            System.out.println("searchedProductGorunurMu Testi PASSED");
        }else             System.out.println("searchedProductGorunurMu Testi FAILED");


        //8. Verify all the products related to search are visible

        WebElement allTheProductGorunurMu= driver.findElement(By.cssSelector("div[class='features_items']"));
        if (allTheProductGorunurMu.isDisplayed()){
            System.out.println("allTheProductGorunurMu Testi PASSED");
        }else System.out.println("allTheProductGorunurMu Testi FAILED");

    }
}

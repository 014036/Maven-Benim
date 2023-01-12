package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase07 {

    /*
    Test Case 7: Verify Test Cases Page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
****************************************************

     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu= driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()){
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        }else  System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

//        4. Click on 'Test Cases' button
        driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a")).click();

 //        5. Verify user is navigated to test cases page successfully
        WebElement basiliYonlendirmeYapildiMi=driver.findElement(By.cssSelector("h2[class='title text-center']"));

        if (basiliYonlendirmeYapildiMi.isDisplayed()){
            System.out.println("basiliYonlendirmeYapildiMi Testi PASSED");
        }else   System.out.println("basiliYonlendirmeYapildiMi Testi FAILED");
    }
}

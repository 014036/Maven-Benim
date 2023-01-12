package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase10 {

    /*
    Test Case 10: Verify Subscription in home page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
7. Verify success message 'You have been successfully subscribed!' is visible
     */

    public static void main(String[] args) throws InterruptedException {

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

        //4. Scroll down to footer
        driver.findElement(By.cssSelector("body[style]")).sendKeys( Keys.END);

        //5. Verify text 'SUBSCRIPTION'
        WebElement subscriptionYazisiGorunurMu= driver.findElement(By.xpath("//*[text()='Subscription']"));
        if (subscriptionYazisiGorunurMu.isDisplayed()){
            System.out.println("subscriptionYazisiGorunurMu Testi PASSED");
        }else             System.out.println("subscriptionYazisiGorunurMu Testi FAILED");

        //6. Enter email address in input and click arrow button
        driver.findElement(By.cssSelector("input[id='susbscribe_email']")).sendKeys("kusulua@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[id='subscribe']")).click();


        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement basariylaKaydoldunuzMesajiEnSon= driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        if (basariylaKaydoldunuzMesajiEnSon.isDisplayed()){
            System.out.println("basariylaKaydoldunuzMesajiEnSon Testi PASSED");
        }else System.out.println("basariylaKaydoldunuzMesajiEnSon Testi FAILED");
    }
}

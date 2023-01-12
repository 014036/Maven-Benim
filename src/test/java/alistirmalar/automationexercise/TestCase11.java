package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase11 {

    /*
    Test Case 11: Verify Subscription in Cart page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
8. Verify success message 'You have been successfully subscribed!' is visible
*/
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu = driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()) {
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        } else System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

    //4. Click 'Cart' button
      driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();

    //5. Scroll down to footer
        //driver.findElement(By.cssSelector("header[id='header']")).sendKeys(Keys.DOWN);


    //6. Verify text 'SUBSCRIPTION'
        WebElement subscriptionYazisiGorunurMu= driver.findElement(By.xpath("//*[text()='Subscription']"));
        if (subscriptionYazisiGorunurMu.isDisplayed()){
            System.out.println("subscriptionYazisiGorunurMu Testi PASSED");
        }else             System.out.println("subscriptionYazisiGorunurMu Testi FAILED");

    // 7. Enter email address in input and click arrow button
        driver.findElement(By.cssSelector("input[id='susbscribe_email']")).sendKeys("kusulua@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[id='subscribe']")).click();

    //8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement basariylaKaydoldunuzMesajiEnSon= driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        if (basariylaKaydoldunuzMesajiEnSon.isDisplayed()){
            System.out.println("basariylaKaydoldunuzMesajiEnSon Testi PASSED");
        }else System.out.println("basariylaKaydoldunuzMesajiEnSon Testi FAILED");
    }
}

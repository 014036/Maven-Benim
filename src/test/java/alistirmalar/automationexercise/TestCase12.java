package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class TestCase12 {
 /*
    Test Case 12: Add Products in Cart
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
            6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
            8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
  */

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu = driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()) {
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        } else System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

        //4. Click 'Products' button
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

        Thread.sleep(3000);
        clickOutside();


        //5. Hover over first product and click 'Add to cart'
        driver.findElement(By.xpath("(//*[@data-product-id=\"1\"])[1]")).click();


        // 6. Click 'Continue Shopping' button

        driver.findElement(By.xpath("//*[@class=\"btn btn-success close-modal btn-block\"]")).click();


        //7. Hover over second product and click 'Add to cart'

        driver.findElement(By.xpath("(//*[@data-product-id=\"2\"])[1]")).click();


        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[@href=\"/view_cart\"])[2]")).click();

        //9. Verify both products are added to Cart --Her iki ürünün de Sepete eklendiğini doğrulayın

        //10. Verify their prices, quantity and total price
        //10. Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın

        String ilkUrunPrice = driver.findElement(By.xpath("(//*[@class='cart_price'])[1]")).getText();
        String expectedPrice1 = "500";
        String ilkUrunQuantity = driver.findElement(By.xpath("//*[@class='cart_quantity'])[1]")).getText();
        String expectedQuantity1 = "1";
        String ilkUrunTotal = driver.findElement(By.xpath("//*[@class='cart_total_price'])[1]")).getText();
        String expectedTotal1 = "500";
        Assert.assertTrue(ilkUrunPrice.equals(expectedPrice1)&&ilkUrunQuantity.equals(expectedQuantity1)&&ilkUrunTotal.equals(expectedTotal1));

        String ikinciUrunPrice = driver.findElement(By.xpath("(//*[@class='cart_price'])[2]")).getText();
        String expectedPrice2 = "400";
        String ikinciUrunQuantity = driver.findElement(By.xpath("//*[@class='cart_quantity'])[2]")).getText();
        String expectedQuantity2 = "1";
        String ikinciUrunTotal = driver.findElement(By.xpath("//*[@class='cart_total_price'])[2]")).getText();
        String expectedTotal2 = "400";
        Assert.assertTrue(ikinciUrunPrice.equals(expectedPrice2)&&ikinciUrunQuantity.equals(ikinciUrunQuantity)&&ikinciUrunTotal.equals(ikinciUrunTotal));

    }

    public static void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
}

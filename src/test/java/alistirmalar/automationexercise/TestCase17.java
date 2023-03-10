package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase17 {

    /*
        Test Case 17: Remove Products From Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart
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

//4. Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='12'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//*[@data-product-id='20'])[1]")).click();
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();


//5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();


//6. Verify that cart page is displayed
        WebElement sepetGorunurMu = driver.findElement(By.cssSelector("div[id='cart_info']"));
        if (sepetGorunurMu.isDisplayed()) {
            System.out.println("sepetGorunurMu Testi PASSED");
        } else System.out.println("sepetGorunurMu Testi FAILED");

//7. Click 'X' button corresponding to particular product --Belirli bir ??r??ne kar????l??k gelen 'X' d????mesini t??klay??n
        driver.findElement(By.xpath("(//*[@class='cart_quantity_delete'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='cart_quantity_delete'])[2]")).click();

//8. Verify that product is removed from the cart --??r??n??n sepetten kald??r??ld??????n?? do??rulay??n
        Thread.sleep(5000);
        String sepetBosMu= driver.findElement(By.xpath("(//*[@class='text-center'])[3]/b")).getText();
        System.out.println("sepetBosMu = " + sepetBosMu);

        String expected= "Cart is empty!";
        Assert.assertEquals(sepetBosMu, expected);


    }


}

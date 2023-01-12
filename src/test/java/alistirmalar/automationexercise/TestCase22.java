package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase22 {

    /*
        Test Case 22: Add to cart from Recommended items
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
 3. Scroll to bottom of page
4. Verify 'RECOMMENDED ITEMS' are visible
5. Click on 'Add To Cart' on Recommended product
6. Click on 'View Cart' button
7. Verify that product is displayed in cart page
     */

    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

    @Test
    public void test01() {
  // 3. Scroll to bottom of page --Sayfanın en altına kaydır
        driver.findElement(By.cssSelector("body[style]")).sendKeys(Keys.END);

//4. Verify 'RECOMMENDED ITEMS' are visible --'ÖNERİLEN ÖĞELER'in görünür olduğunu doğrulayın
        WebElement recommedItemGorunuyorMu= driver.findElement(By.cssSelector("div[class='recommended_items']"));
        Assert.assertTrue(recommedItemGorunuyorMu.isDisplayed());

//5. Click on 'Add To Cart' on Recommended product --Önerilen üründe 'Sepete Ekle'ye tıklayın
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();


//6. Click on 'View Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();

//7. Verify that product is displayed in cart page --Ürünün sepet sayfasında görüntülendiğini doğrulayın
        WebElement ilkUrunGorunuyorMu= driver.findElement(By.cssSelector("a[href='/product_details/1']"));
        WebElement ikinciUrunGorunuyorMu= driver.findElement(By.cssSelector("a[href='/product_details/2']"));

        Assert.assertTrue(ilkUrunGorunuyorMu.isDisplayed()&& ikinciUrunGorunuyorMu.isDisplayed());


    }


}

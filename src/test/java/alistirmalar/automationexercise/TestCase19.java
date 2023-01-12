package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase19 {


    /*
        Test Case 19: View & Cart Brand Products
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
 3. Click on 'Products' button
4. Verify that Brands are visible on left side bar
5. Click on any brand name
6. Verify that user is navigated to brand page and brand products are displayed
7. On left side bar, click on any other brand link
8. Verify that user is navigated to that brand page and can see products
     */
static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    }

    @Test
    public void name() throws InterruptedException {
        // 3. Click on 'Products' button
        driver.findElement(By.cssSelector("a[href='/products']")).click();

        clickOutside();


//4. Verify that Brands are visible on left side bar --Markaların sol taraftaki çubukta göründüğünü doğrulayın
        Thread.sleep(8000);
        WebElement markalarGorunurMu= driver.findElement(By.cssSelector("div[class='brands_products']"));
        Assert.assertTrue(markalarGorunurMu.isDisplayed());

//5. Click on any brand name --Herhangi bir marka adına tıklayın
        driver.findElement(By.cssSelector("a[href='/brand_products/Kookie Kids']")).click();

//6. Verify that user is navigated to brand page and brand products are displayed
        //Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın
       WebElement markaUrunleriGorunurMu= driver.findElement(By.cssSelector("div[class='features_items']"));
       Assert.assertTrue(markaUrunleriGorunurMu.isDisplayed());

//7. On left side bar, click on any other brand link
        //Sol taraftaki çubukta, herhangi bir başka marka bağlantısına tıklayın
        driver.findElement(By.cssSelector("a[href='/brand_products/Madame']")).click();

//8. Verify that user is navigated to that brand page and can see products
        //Kullanıcının o marka sayfasına yönlendirildiğini ve ürünleri görebildiğini doğrulayın
        WebElement yeniMarkaUrunleriGorunurMu= driver.findElement(By.cssSelector("div[class='features_items']"));
        Assert.assertTrue(yeniMarkaUrunleriGorunurMu.isDisplayed());

    }


    public static void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
}

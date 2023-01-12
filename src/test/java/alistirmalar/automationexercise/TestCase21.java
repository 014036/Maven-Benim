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
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase21 {

  /*
    Test Case 21: Add review on product
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Click on 'View Product' button
6. Verify 'Write Your Review' is visible
7. Enter name, email and review
8. Click 'Submit' button
9. Verify success message 'Thank you for your review.'
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
    public void test01() throws InterruptedException {

        // 3. Click on 'Products' button
        driver.findElement(By.cssSelector("a[href='/products']")).click();

        clickOutside();
        Thread.sleep(4000);

//4. Verify user is navigated to ALL PRODUCTS page successfully
        //Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement allProductGorunurMu = driver.findElement(By.cssSelector("div[class='features_items']"));
        Assert.assertTrue(allProductGorunurMu.isDisplayed());

//5. Click on 'View Product' button
        driver.findElement(By.cssSelector("body[style]")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
       driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]")).click();

//6. Verify 'Write Your Review' is visible --Write Your Review' yazisinin gorunur old dogrula
        String writeYourReviewYazisiVarMi = driver.findElement(By.xpath("//*[text()='Write Your Review']")).getText();
        System.out.println("writeYourReviewYazisiVarMi = " + writeYourReviewYazisiVarMi);
        String beklenenYazi="WRITE YOUR REVIEW";
        Assert.assertEquals(writeYourReviewYazisiVarMi,beklenenYazi);

//7. Enter name, email and review --Adı, e-postayı girin ve review'i gir

        driver.findElement(By.id("name")).sendKeys("Mustafa");
        driver.findElement(By.id("email")).sendKeys("kusulua@gmail.com");
        driver.findElement(By.id("review")).sendKeys("Ilk Alisveris");


//8. Click 'Submit' button
        driver.findElement(By.id("button-review")).click();

//9. Verify success message 'Thank you for your review.'
        String sonucYazisi= driver.findElement(By.xpath("(//*[@class='alert-success alert'])[1]")).getText();
        System.out.println("sonucYazisi = " + sonucYazisi);
        String beklenenSonucYazisi="Thank you for your review.";
        Assert.assertEquals(sonucYazisi, beklenenSonucYazisi);


    }


    public static void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

}

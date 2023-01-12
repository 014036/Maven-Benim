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

public class TestCase26 {


    /*
    //    Test Case 26:
//    Verify Scroll Up without 'Arrow' button and Scroll Down functionality
        //'Ok' düğmesi olmadan Yukarı Kaydırmayı ve Aşağı Kaydırma işlevini doğrulayın
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
// 3. Verify that home page is visible successfully
//4. Scroll down page to bottom --Sayfayı aşağıya doğru kaydır
//5. Verify 'SUBSCRIPTION' is visible
//6. Scroll up page to top
//7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
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

        //3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu = driver.findElement(By.cssSelector("body[style]"));
        Assert.assertTrue(anaSayfaTusuGorunuyorMu.isDisplayed());


        //4. Scroll down page to bottom --Sayfayı aşağıya doğru kaydır
        driver.findElement(By.cssSelector("body[style]")).sendKeys(Keys.END);

//5. Verify 'SUBSCRIPTION' is visible --'ABONELİK'in görünür olduğunu doğrulayın
        WebElement subscriptionGorunurMu= driver.findElement(By.cssSelector("div[class='single-widget']"));
        Assert.assertTrue(subscriptionGorunurMu.isDisplayed());

        Thread.sleep(3000);
//6. Scroll up page to top
        driver.findElement(By.id("scrollUp")).sendKeys(Keys.HOME);

//7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers'
// text is visible on screen
        //(Sayfanın yukarı kaydırıldığını ve 'Full-Fledged practice website for Automation Engineers'
        // metninin ekranda göründüğünü doğrulayın)



        WebElement fullFledgedYazisiGorunurmu= driver.findElement(By.xpath("(//div[@class='col-sm-6'])[1]"));
        Assert.assertTrue(fullFledgedYazisiGorunurmu.isDisplayed());
    }








}


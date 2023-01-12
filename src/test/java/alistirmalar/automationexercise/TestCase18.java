package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase18 {

    /*
        Test Case 18: View Category Products
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that categories are visible on left side bar
4. Click on 'Women' category
5. Click on any category link under 'Women' category, for example: Dress
6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
 7. On left side bar, click on any sub-category link of 'Men' category
8. Verify that user is navigated to that category page
     */
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that categories are visible on left side bar --Kategorilerin sol kenar çubuğunda göründüğünü doğrulayın
        WebElement categryGorunurMu = driver.findElement(By.cssSelector("div[class='left-sidebar']"));
        if (categryGorunurMu.isDisplayed()) {
            System.out.println("categryGorunurMu Testi PASSED");
        } else System.out.println("categryGorunurMu Testi FAILED");

//4. Click on 'Women' category
        driver.findElement(By.xpath("(//a[@class='test_cases_list'])[1]")).sendKeys(Keys.PAGE_DOWN);
     //   driver.findElement(By.xpath("//*[@href='#Women']")).click();
        driver.findElement(By.xpath("(//*[@data-parent='#accordian'])[1]")).click();

//5. Click on any category link under 'Women' category, for example: Dress
        //'Kadınlar' kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
        driver.findElement(By.cssSelector("a[href='/category_products/1']")).click();

        Thread.sleep(4000);
        clickOutside();

//6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        //Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - TOPS ÜRÜNLERİ' metnini onaylayın
        WebElement kadinElbiseSayfasiGorunurMu = driver.findElement(By.cssSelector("div[class='features_items']"));
        if (kadinElbiseSayfasiGorunurMu.isDisplayed()) {
            System.out.println("kadinElbiseSayfasiGorunurMu Testi PASSED");
        } else System.out.println("kadinElbiseSayfasiGorunurMu Testi FAILED");


//'KADIN - TOPS ÜRÜNLERİ' metnini onaylayın

        WebElement womenDressYazisiVarmi = driver.findElement(By.xpath("//*[text()='Women - Dress Products']"));
        if (womenDressYazisiVarmi.isDisplayed()){
            System.out.println("womenDressYazisiVarmi Testi PASSED");
        }else System.out.println("womenDressYazisiVarmi Testi FAILED");

        String womenDressYazisiDogruMu = driver.findElement(By.xpath("//*[text()='Women - Dress Products']")).getText();
        String expected="WOMEN - DRESS PRODUCTS";
        if (womenDressYazisiDogruMu.equals(expected)){
            System.out.println("womenDressYazisiDogruMu Testi PASSED");
        }else System.out.println("womenDressYazisiDogruMu Testi FAILED");

       // System.out.println("womenDressYazisiVarmi = " + womenDressYazisiVarmi);

      //  Assert.assertEquals("WOMEN - DRESS PRODUCTS",womenDressYazisiVarmi);

// 7. On left side bar, click on any sub-category link of 'Men' category
        //Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
        driver.findElement(By.cssSelector("a[href='#Men']")).click();

        driver.findElement(By.cssSelector("a[href='/category_products/3']")).click();

//8. Verify that user is navigated to that category page
        //Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın

        WebElement menTshirtsYazisiVarmi = driver.findElement(By.xpath("//*[text()='Men - Tshirts Products']"));
        if (menTshirtsYazisiVarmi.isDisplayed()){
            System.out.println("menTshirtsYazisiVarmi Testi PASSED");
        }else System.out.println("menTshirtsYazisiVarmi Testi FAILED");

        String menTshirtsYazisiDogruMu = driver.findElement(By.xpath("//*[text()='Women - Dress Products']")).getText();
        String expectedMen="MEN - TSHIRTS PRODUCTS";
        System.out.println("expectedMen = " + expectedMen);

        if (menTshirtsYazisiDogruMu.equals(expected)){
            System.out.println("menTshirtsYazisiDogruMu Testi PASSED");
        }else System.out.println("menTshirtsYazisiDogruMu Testi FAILED");

    }

    public static void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
}

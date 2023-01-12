package alistirmalar.slayt_sorulari.cozdum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Sayfa_74 {

    /*
    1. “https://www.saucedemo.com” Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin
     */
static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

    }

    @Test
    public void test01() {
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");


        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");


        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("(//div[@class='inventory_item'])[1]")).click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();


        //7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();


        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       WebElement sepetGorunurMu= driver.findElement(By.id("item_4_title_link"));
        Assert.assertTrue(sepetGorunurMu.isDisplayed());
        String spett=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals("Sauce Labs Backpack",spett);
    }

    @After
    public void tearDown() throws Exception {
        //9. Sayfayi kapatin
        driver.close();
        driver.quit();
    }


}

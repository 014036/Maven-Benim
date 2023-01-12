package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase08 {

    /*
    Test Case 8: Verify All Products and product detail page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
****************************************************

     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu = driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()) {
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        } else System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

        //4. Click on 'Products' button
        driver.findElement(By.cssSelector("a[href='/products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsYazisiVarMi = driver.findElement(By.xpath("//*[text()='All Products']"));
        System.out.println("allProductsYazisiVarMi.getText() = " + allProductsYazisiVarMi.getText());
        if (allProductsYazisiVarMi.isDisplayed()) {
            System.out.println("allProductsYazisiVarMi Tetsi PASSED");
        } else System.out.println("allProductsYazisiVarMi Tetsi FAILED");

        //6. The products list is visible --Ürün listesi görünür
        WebElement listVisible = driver.findElement(By.cssSelector("[class=\"features_items\"]"));
        if (listVisible.isDisplayed()) {
            System.out.println("listVisible Testi PASSED");
        } else System.out.println("listVisible Testi FAILED");

        //7. Click on 'View Product' of first product --İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        driver.findElement(By.xpath("(//*[@class=\"product-image-wrapper\"])[1]")).click();

        //8. User is landed to product detail page --Kullanıcı, ürün detay sayfasına ulaştı
        driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement detayBilgilerGorunuyorMu = driver.findElement(By.cssSelector("div[class='product-information']"));
        if (detayBilgilerGorunuyorMu.isDisplayed()) {
            System.out.println("detayBilgilerGorunuyorMu Testi PASSED");
        } else System.out.println("detayBilgilerGorunuyorMu Testi FAILED");
    }
}

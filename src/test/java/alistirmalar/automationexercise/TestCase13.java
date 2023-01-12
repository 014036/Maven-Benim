package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase13 {
    /*
    Test Case 13: Verify Product quantity in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
 7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
*/
    public static void main(String[] args) {


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


//4. Click 'View Product' for any product on home page //Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'yi tıklayın

        driver.findElement(By.cssSelector("a[href='/product_details/18']")).click();

//5. Verify product detail is opened --Ürün detayının açıldığını doğrulayın

        WebElement urunDetayiDogrulama= driver.findElement(By.cssSelector("div[class='product-information']"));

        if (urunDetayiDogrulama.isDisplayed()){
            System.out.println("urunDetayiDogrulama Testi PASSED");
        }else System.out.println("urunDetayiDogrulama Testi FAILED");

//6. Increase quantity to 4 --Miktarı 4'e çıkar

//    WebElement miktariArtir= driver.findElement(By.cssSelector("input[id=quantity]"));
//        Select miktar= new Select(miktariArtir);
//        miktar.selectByValue("4");

// 7. Click 'Add to cart' button

        driver.findElement(By.cssSelector("button[class='btn btn-default cart']")).click();

//8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();

//9. Verify that product is displayed in cart page with exact quantity
     //Ürünün sepet sayfasında tam miktarla görüntülendiğini doğrulayın
driver.findElement(By.cssSelector("button[class='disabled']"));

    }


}

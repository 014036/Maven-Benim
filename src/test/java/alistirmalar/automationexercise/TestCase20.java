package alistirmalar.automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class TestCase20 extends TestBase {

    /*
        Test Case 20: Search Products and Verify Cart After Login
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well
     */


    @Test
    public void test01() {
    //Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");

    // 3. Click on 'Products' button
    driver.findElement(By.xpath("//li/a[@href='/products']")).click();

    //4. Verify user is navigated to ALL PRODUCTS page successfully
    //Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
    WebElement allProductGorunurMu = driver.findElement(By.cssSelector("div[class='features_items']"));
    Assert.assertTrue(allProductGorunurMu.isDisplayed());
    //5. Enter product name in search input and click search button
    //Arama girişine ürün adını girin ve ara düğmesine tıklayın
    driver.findElement(By.id("search_product")).sendKeys("Dress");
    driver.findElement(By.id("submit_search")).click();

//6. Verify 'SEARCHED PRODUCTS' is visible --'ARANAN ÜRÜNLER'in görünür olduğunu doğrulayın
        WebElement searchedProductGorunurMu = driver.findElement(By.cssSelector("div[class='features_items']"));
        Assert.assertTrue(searchedProductGorunurMu.isDisplayed());

//7. Verify all the products related to search are visible
        //Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın

//8. Add those products to cart --Bu ürünleri sepete ekle
        driver.findElement(By.xpath("(//a[@data-product-id='16'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//a[@data-product-id='19'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//a[@data-product-id='20'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//a[@data-product-id='22'])[1]")).click();
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();


//9. Click 'Cart' button and verify that products are visible in cart
        //'Cart' düğmesini tıklayın ve ürünlerin sepette göründüğünü doğrulayın
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();

        WebElement ilkUrunGorunuyorMu = driver.findElement(By.xpath("//*[@href='/product_details/16']"));
        WebElement ikinciUrunGorunuyorMu = driver.findElement(By.xpath("//*[@href='/product_details/19']"));
        WebElement ucuncuUrunGorunuyorMu = driver.findElement(By.xpath("//*[@href='/product_details/20']"));
        WebElement dorduncuUrunGorunuyorMu = driver.findElement(By.xpath("//*[@href='/product_details/22']"));

        Assert.assertTrue(ilkUrunGorunuyorMu.isDisplayed() && ikinciUrunGorunuyorMu.isDisplayed() &&
                ucuncuUrunGorunuyorMu.isDisplayed() && dorduncuUrunGorunuyorMu.isDisplayed());

//10. Click 'Signup / Login' button and submit login details --düğmesine basın ve giriş bilgilerini gönderin
        driver.findElement(By.xpath("(//*[@href='/login'])[1]")).click();
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("kusulua@gmail.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("014036");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

//11. Again, go to Cart page --Tekrar, Sepet sayfasına gidin
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();

//12. Verify that those products are visible in cart after login as well
        //Giriş yaptıktan sonra bu ürünlerin de sepette göründüğünü doğrulayın

        WebElement ilkUrunGorunuyorMuSon = driver.findElement(By.xpath("//*[@href='/product_details/16']"));
        WebElement ikinciUrunGorunuyorMuSon = driver.findElement(By.xpath("//*[@href='/product_details/19']"));
        WebElement ucuncuUrunGorunuyorMuSon = driver.findElement(By.xpath("//*[@href='/product_details/20']"));
        WebElement dorduncuUrunGorunuyorMuSon = driver.findElement(By.xpath("//*[@href='/product_details/22']"));

        Assert.assertTrue(ilkUrunGorunuyorMuSon.isDisplayed() && ikinciUrunGorunuyorMuSon.isDisplayed() &&
                ucuncuUrunGorunuyorMuSon.isDisplayed() && dorduncuUrunGorunuyorMuSon.isDisplayed());
    }


}

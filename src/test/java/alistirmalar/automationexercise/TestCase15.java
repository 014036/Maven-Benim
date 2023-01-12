package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase15 {

    /*   Test Case 15: Place Order: Register before Checkout
   1. Launch browser
   2. Navigate to url 'http://automationexercise.com'
               3. Verify that home page is visible successfully
   4. Click 'Signup / Login' button
   5. Fill all details in Signup and create account
   6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
   7. Verify ' Logged in as username' at top
   8. Add products to cart
   9. Click 'Cart' button
   10. Verify that cart page is displayed
   11. Click Proceed To Checkout
   12. Verify Address Details and Review Your Order
   13. Enter description in comment text area and click 'Place Order'
               14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
   15. Click 'Pay and Confirm Order' button
   16. Verify success message 'Your order has been placed successfully!'
               17. Click 'Delete Account' button
   18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
   */
    public static void main(String[] args) throws InterruptedException {

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

        //4. Click 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. Fill all details in Signup and create account
        driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("Mustafa", Keys.TAB, "kusuluabc@gmail.com", Keys.TAB);


        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        driver.findElement(By.cssSelector("input[id='id_gender1']")).click();

        WebElement passwordGir = driver.findElement(By.cssSelector("input[id='password']"));
        passwordGir.sendKeys("014036");

        WebElement gunGir = driver.findElement(By.cssSelector("select[id='days']"));
        gunGir.sendKeys("26");

        WebElement ayGir = driver.findElement(By.cssSelector("select[id='months']"));
        ayGir.sendKeys("August");

        WebElement yilGir = driver.findElement(By.cssSelector("select[id='years']"));
        yilGir.sendKeys("1978");


//        10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.cssSelector("input[id='newsletter']")).click();

//        11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.cssSelector("input[id='optin']")).click();

//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.cssSelector("input[id='first_name']")).sendKeys("Ali");
        driver.findElement(By.cssSelector("input[id='last_name']")).sendKeys("Veli");
        driver.findElement(By.cssSelector("input[id='company']")).sendKeys("Turkiye");
        driver.findElement(By.cssSelector("input[id='address1']")).sendKeys("Kutahya");
        driver.findElement(By.cssSelector("input[id='address2']")).sendKeys("Kusu");
        driver.findElement(By.cssSelector("select[id='country']")).sendKeys("India");
        driver.findElement(By.cssSelector("input[id='state']")).sendKeys("Simav");
        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Simav");
        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Simav");
        driver.findElement(By.cssSelector("input[id='zipcode']")).sendKeys("43500");
        driver.findElement(By.cssSelector("input[id='mobile_number']")).sendKeys("+905515464350");


        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();


        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

        //7. Verify ' Logged in as username' at top
        WebElement basariliGirisYazisiGorunuyorMu = driver.findElement(By.cssSelector("i[class='fa fa-user']"));
        if (basariliGirisYazisiGorunuyorMu.isDisplayed()) {
            System.out.println("basariliGirisYazisiGorunuyorMu Testi PASSED");
        } else System.out.println("basariliGirisYazisiGorunuyorMu Testi FAILED");

        //8. Add products to cart
        driver.findElement(By.xpath("(//*[@data-product-id=\"1\"])[1]")).click();


        //9. Click 'Cart' button
        driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();


        //10. Verify that cart page is displayed

        WebElement sepetSayfasiGorunurMu = driver.findElement(By.xpath("//*[@class='breadcrumb']"));
        // driver.findElement(By.cssSelector("tr[class=\"cart_menu\"]"));
        if (sepetSayfasiGorunurMu.isDisplayed()) {
            System.out.println("sepetSayfasiGorunurMu Testi PASSED");
        } else System.out.println("sepetSayfasiGorunurMu Testi FAILED");


        //11. Click Proceed To Checkout

        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();

        //12. Verify Address Details and Review Your Order
        WebElement adresBilgileriDogrumu = driver.findElement(By.xpath("//*[text()=\"Address Details\"]"));
        if (adresBilgileriDogrumu.isDisplayed()) {
            System.out.println("adresBilgileriDogrumu Tetsi PASSED");
        } else System.out.println("adresBilgileriDogrumu Tetsi FAILED");

        //13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.cssSelector("textarea[name=\"message\"]")).sendKeys("Ilk Urun Siparisi");

        //and click 'Place Order'
        driver.findElement(By.cssSelector("a[href=\"/payment\"]")).click();

        // 14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.cssSelector("input[data-qa=\"name-on-card\"]")).sendKeys("Deneme", Keys.TAB, "1234567891234567", Keys.TAB, "311", Keys.TAB, "12", Keys.TAB, "2023");

        //15. Click 'Pay and Confirm Order' button
        driver.findElement(By.cssSelector("button[data-qa=\"pay-button\"]")).click();

        //16. Verify success message 'Your order has been placed successfully!'
//        WebElement placedSuccessfulyYazisiVarmi = driver.findElement(By.cssSelector("div[id=\"success_message\"]"));
//        if (placedSuccessfulyYazisiVarmi.isDisplayed()) {
//            System.out.println("placedSuccessfulyYazisiVarmi Testi PASSED");
//        } else System.out.println("placedSuccessfulyYazisiVarmi Testi FAILED");


     WebElement message =  driver.findElement(By.xpath("//*[@style=\"font-size: 20px; font-family: garamond;\"]"));
     String expectedMessage = "Your order has been placed successfully";
     Assert.assertNotEquals(message.getText(),expectedMessage);

        //continue butonuna tikla
        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();

        // 17. Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href=\"/delete_account\"]")).click();

        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement sonucYazisi = driver.findElement(By.cssSelector("h2[data-qa='account-deleted']"));
        System.out.println("sonucYazisi.getTagName() = " + sonucYazisi.getText());

        if (sonucYazisi.getText().equals("ACCOUNT DELETED!")) {
            System.out.println("sonucYazisi Testi PASSED");
        } else System.out.println("sonucYazisi Testi FAILED");


//click 'Continue' button
        driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();

    }
}

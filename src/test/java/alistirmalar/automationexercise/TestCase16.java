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

public class TestCase16 {

    /*
        Test Case 16: Place Order: Login before Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
            13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
            16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button

     */

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
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

//5. Fill email, password and click 'Login' button



        WebElement eMailKutusuVeriGir = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        eMailKutusuVeriGir.sendKeys("kusulub@gmail.com");

        WebElement passwordGir = driver.findElement(By.cssSelector("input[data-qa='login-password']"));
        passwordGir.sendKeys("014036");


//         Click 'Signup' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

//6. Verify 'Logged in as username' at top
        WebElement loggedInUserNameGorunuyorMu =driver.findElement(By.cssSelector("i[class='fa fa-user']"));
        if (loggedInUserNameGorunuyorMu.isDisplayed()){
            System.out.println("loggedInUserNameGorunuyorMu Testi PASSED");
        }else System.out.println("loggedInUserNameGorunuyorMu Testi FAILED");

//7. Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='4'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

//8. Click 'Cart' button
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

//9. Verify that cart page is displayed
        WebElement sepetGorunurMu= driver.findElement(By.xpath("//tbody"));
        if (sepetGorunurMu.isDisplayed()){
            System.out.println("sepetGorunurMu Testi PASSED");
        }else System.out.println("sepetGorunurMu Testi FAILED");


//10. Click Proceed To Checkout
        driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();

//11. Verify Address Details and Review Your Order
        WebElement adresBilgileri= driver.findElement(By.xpath("(//h2[@class='heading'])[1]"));
        if (adresBilgileri.isDisplayed()){
            System.out.println("adresBilgileri Testi PASSED");
        }else  System.out.println("adresBilgileri Testi FAILED");

//12. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Cok cAlismaliyim");
        driver.findElement(By.cssSelector("a[href='/payment']")).click();

Thread.sleep(3000);

clickOutside();

//13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.cssSelector("input[data-qa=\"name-on-card\"]")).sendKeys("Deneme", Keys.TAB, "1234567891234567", Keys.TAB, "311", Keys.TAB, "12", Keys.TAB, "2023");

//14. Click 'Pay and Confirm Order' button
        driver.findElement(By.cssSelector("button[id='submit']")).click();

//15. Verify success message 'Your order has been placed successfully!'
        WebElement placedSuccessfulyYazisiVarmi = driver.findElement(By.cssSelector("div[id='success_message'] div[class='alert-success alert']"));

        Assert.assertEquals("Your order has been placed successfully!",placedSuccessfulyYazisiVarmi);

        //continue butonuna bas
        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

//16. Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href=\"/delete_account\"]")).click();

//17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement sonucYazisi = driver.findElement(By.cssSelector("h2[data-qa='account-deleted']"));
        System.out.println("sonucYazisi.getTagName() = " + sonucYazisi.getText());

        if (sonucYazisi.getText().equals("ACCOUNT DELETED!")) {
            System.out.println("sonucYazisi Testi PASSED");
        } else System.out.println("sonucYazisi Testi FAILED");


//click 'Continue' button
        driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();

    }

    public static void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

}

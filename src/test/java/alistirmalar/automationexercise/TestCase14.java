package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase14 {

    /*
        Test Case 14: Place Order: Register while Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
 3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
            16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
            19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
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

//4. Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='4'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

//5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

//6. Verify that cart page is displayed
        WebElement sepetGorunurMu= driver.findElement(By.xpath("//tbody"));
        if (sepetGorunurMu.isDisplayed()){
            System.out.println("sepetGorunurMu Testi PASSED");
        }else System.out.println("sepetGorunurMu Testi FAILED");

//7. Click Proceed To Checkout
driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();

//8. Click 'Register / Login' button

        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();

//9. Fill all details in Signup and create account

   WebElement nameKutusuVeriGir = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        nameKutusuVeriGir.sendKeys("Mustafa");


        WebElement eMailKutusuVeriGir = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        eMailKutusuVeriGir.sendKeys("kusulub@gmail.com");



//         Click 'Signup' button
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

//         Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInferGorunuyorMu = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (enterAccountInferGorunuyorMu.isDisplayed()) {
            System.out.println("ENTER ACCOUNT INFORMATION Testi PASSED");
        } else System.out.println("ENTER ACCOUNT INFORMATION Testi FAILED");

//         Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.cssSelector("input[id='id_gender1']")).click();

        WebElement passwordGir = driver.findElement(By.cssSelector("input[id='password']"));
        passwordGir.sendKeys("014036");

        WebElement gunGir = driver.findElement(By.cssSelector("select[id='days']"));
        gunGir.sendKeys("26");

        WebElement ayGir = driver.findElement(By.cssSelector("select[id='months']"));
        ayGir.sendKeys("August");

        WebElement yilGir = driver.findElement(By.cssSelector("select[id='years']"));
        yilGir.sendKeys("1978");


//         Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.cssSelector("input[id='newsletter']")).click();

//         Select checkbox 'Receive special offers from our partners!'
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

//        10. Click 'Create Account button'
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

//         Click 'Continue' button

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        Thread.sleep(3000);

        clickOutside();//tam sayfa reklam kapatmak icin


//11. Verify ' Logged in as username' at top
       // Verify that 'Logged in as username' is visible
        WebElement loggedInUserNameGorunuyorMu =driver.findElement(By.cssSelector("i[class='fa fa-user']"));
        if (loggedInUserNameGorunuyorMu.isDisplayed()){
            System.out.println("loggedInUserNameGorunuyorMu Testi PASSED");
        }else System.out.println("loggedInUserNameGorunuyorMu Testi FAILED");


//12.Click 'Cart' button
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

//13. Click 'Proceed To Checkout' button
        driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();

//14. Verify Address Details and Review Your Order //Adres bilgilerini dogrulayin
WebElement adresBilgileri= driver.findElement(By.xpath("(//h2[@class='heading'])[1]"));
if (adresBilgileri.isDisplayed()){
    System.out.println("adresBilgileri Testi PASSED");
}else  System.out.println("adresBilgileri Testi FAILED");

//15. Enter description in comment text area and click 'Place Order'
        //Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Cok cAlismaliyim");
        driver.findElement(By.cssSelector("a[href='/payment']")).click();

//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.cssSelector("input[data-qa=\"name-on-card\"]")).sendKeys("Deneme", Keys.TAB, "1234567891234567", Keys.TAB, "311", Keys.TAB, "12", Keys.TAB, "2023");

//17. Click 'Pay and Confirm Order' button
        driver.findElement(By.cssSelector("button[id='submit']")).click();

//18. Verify success message 'Your order has been placed successfully!'
//        WebElement placedSuccessfulyYazisiVarmi = driver.findElement(By.cssSelector("div[id=\"success_message\"]"));
//        if (placedSuccessfulyYazisiVarmi.isDisplayed()) {
//            System.out.println("placedSuccessfulyYazisiVarmi Testi PASSED");
//        } else System.out.println("placedSuccessfulyYazisiVarmi Testi FAILED");


//19. Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href=\"/delete_account\"]")).click();

//20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
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

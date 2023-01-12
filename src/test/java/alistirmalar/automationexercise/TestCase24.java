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

public class TestCase24 {

    /*
        Test Case 24: Download Invoice after purchase order
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
            19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
20. Click 'Continue' button
21. Click 'Delete Account' button
22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
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
        if (anaSayfaTusuGorunuyorMu.isDisplayed()) {
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        } else System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

        //4. Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//a[@data-product-id='11'])[1]")).click();
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();


//5. Click 'Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();

//6. Verify that cart page is displayed --Sepet sayfasının görüntülendiğini doğrulayın
  WebElement sepetSayfasiGornurMu= driver.findElement(By.id("cart_info"));
        Assert.assertTrue(sepetSayfasiGornurMu.isDisplayed());

//7. Click Proceed To Checkout
        driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();

//8. Click 'Register / Login' button
        driver.findElement(By.xpath("(//*[@href='/login'])[2]")).click();

//9. Fill all details in Signup and create account
        //Kayıttaki tüm ayrıntıları doldurun ve hesap oluşturun

        //        5. Verify 'New User Signup!' is visible
        WebElement NewUserSignupGorunuyorMu = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (NewUserSignupGorunuyorMu.isDisplayed()) {
            System.out.println("New User Signup Testi PASSED");
        } else System.out.println("New User Signup Testi FAILED");

        //   6. Enter name and email address
        WebElement nameKutusuVeriGir = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        nameKutusuVeriGir.sendKeys("Mustafa");


        WebElement eMailKutusuVeriGir = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        eMailKutusuVeriGir.sendKeys("kusulua@gmail.com");

        //VEYA
        // driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("Mustafa", Keys.TAB,"kusuluabc@gmail.com", Keys.TAB;


//        7. Click 'Signup' button
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInferGorunuyorMu = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (enterAccountInferGorunuyorMu.isDisplayed()) {
            System.out.println("ENTER ACCOUNT INFORMATION Testi PASSED");
        } else System.out.println("ENTER ACCOUNT INFORMATION Testi FAILED");

//        9. Fill details: Title, Name, Email, Password, Date of birth
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
        WebElement firstName = driver.findElement(By.cssSelector("input[id='first_name']"));
        firstName.sendKeys("Ali");
        String ilkIsim = firstName.toString();
        WebElement lastName = driver.findElement(By.cssSelector("input[id='last_name']"));
        lastName.sendKeys(" Veli");
        String sonIsim = lastName.toString();
        String isim = ilkIsim.concat(sonIsim);
        System.out.println("isim = " + isim);

        WebElement company = driver.findElement(By.cssSelector("input[id='company']"));
        company.sendKeys("Turkiye");

        WebElement adress1 = driver.findElement(By.cssSelector("input[id='address1']"));
        adress1.sendKeys("Kutahya");

        driver.findElement(By.cssSelector("input[id='address2']")).sendKeys("Kusu");
        WebElement adress2 = driver.findElement(By.cssSelector("select[id='country']"));
        adress2.sendKeys("India");

        WebElement state = driver.findElement(By.cssSelector("input[id='state']"));
        state.sendKeys("Turkiye");

        WebElement city = driver.findElement(By.cssSelector("input[id='city']"));
        city.sendKeys("Simav");

        WebElement zipKode = driver.findElement(By.cssSelector("input[id='zipcode']"));
        zipKode.sendKeys("43500");

        WebElement mobileNumber = driver.findElement(By.cssSelector("input[id='mobile_number']"));
        mobileNumber.sendKeys("+905515464350");

//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//        13. Click 'Create Account button'
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
        //  15. Click 'Continue' button

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        Thread.sleep(4000);

        clickOutside();

//11. Verify ' Logged in as username' at top
        WebElement basariliGirisYazisiGorunuyorMu = driver.findElement(By.cssSelector("i[class='fa fa-user']"));
       Assert.assertTrue(basariliGirisYazisiGorunuyorMu.isDisplayed());

//12.Click 'Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();

//13. Click 'Proceed To Checkout' button
        driver.findElement(By.cssSelector("a[class='btn btn-default check_out']")).click();

//14. Verify Address Details and Review Your Order
        //Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        WebElement adresBilgileri= driver.findElement(By.xpath("(//h2[@class='heading'])[1]"));
        if (adresBilgileri.isDisplayed()){
            System.out.println("adresBilgileri Testi PASSED");
        }else  System.out.println("adresBilgileri Testi FAILED");

//15. Enter description in comment text area and click 'Place Order'
        //Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Cok Calismaliyim");
        driver.findElement(By.cssSelector("a[href='/payment']")).click();

//            16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.cssSelector("input[data-qa=\"name-on-card\"]")).sendKeys("Deneme", Keys.TAB, "1234567891234567", Keys.TAB, "311", Keys.TAB, "12", Keys.TAB, "2023");


//17. Click 'Pay and Confirm Order' button
        driver.findElement(By.cssSelector("button[id='submit']")).click();

//18. Verify success message 'Your order has been placed successfully!'
        WebElement placedSuccessfulyYazisiVarmi = driver.findElement(By.cssSelector("div[id='success_message'] div[class='alert-success alert']"));

        Assert.assertEquals("Your order has been placed successfully!",placedSuccessfulyYazisiVarmi);



//  19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        //'Faturayı İndir' düğmesini tıklayın ve faturanın başarıyla indirildiğini doğrulayın.
        driver.findElement(By.cssSelector("a[href='/download_invoice/1399']")).click();

//       WebElement dosyaIndirildimi= driver.findElement(By.xpath("C:\\Users\\hp\\Downloads\\\\invoice (1).txt"));
//       Assert.assertTrue(dosyaIndirildimi.isEnabled());

//20. Click 'Continue' button
        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

//21. Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href=\"/delete_account\"]")).click();

//22. Verify 'ACCOUNT DELETED!' and
         WebElement sonucYazisi = driver.findElement(By.cssSelector("h2[data-qa='account-deleted']"));
       Assert.assertEquals(sonucYazisi.getText(),"ACCOUNT DELETED!");


//        click 'Continue' button
        driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();

    }
    public static void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

    /*
    cerez kodu
    WebElement acceptCookies =driver.findElement(By.xpath("//*[@id='ez-accept-all']"));
acceptCookies.click();
     */

}

package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class TestCase23 {

    /*
        Test Case 23: Verify address details in checkout page
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
12. Verify that the delivery address is same address filled at the time registration of account
13. Verify that the billing address is same address filled at the time registration of account
14. Click 'Delete Account' button
15. Verify 'ACCOUNT DELETED!' and click 'Continue' button

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

//4. Click 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

//5. Fill all details in Signup and create account--Kayıttaki tüm ayrıntıları doldurun ve hesap oluşturun
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


//        13. Click 'Create Account button'
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
        //  15. Click 'Continue' button

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        Thread.sleep(3000);

        clickOutside();


//7. Verify ' Logged in as username' at top
        WebElement basariliGirisYazisiGorunuyorMu = driver.findElement(By.cssSelector("i[class='fa fa-user']"));
        if (basariliGirisYazisiGorunuyorMu.isDisplayed()) {
            System.out.println("basariliGirisYazisiGorunuyorMu Testi PASSED");
        } else System.out.println("basariliGirisYazisiGorunuyorMu Testi FAILED");

//8. Add products to cart
        driver.findElement(By.xpath("(//a[@data-product-id='16'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//a[@data-product-id='19'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//a[@data-product-id='20'])[1]")).click();
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("(//a[@data-product-id='22'])[1]")).click();
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();

//9. Click 'Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();

//10. Verify that cart page is displayed --Sepet sayfasının görüntülendiğini doğrulayın
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]")).click();

        WebElement ilkUrunGorunuyorMu = driver.findElement(By.xpath("//*[@href='/product_details/16']"));
        WebElement ikinciUrunGorunuyorMu = driver.findElement(By.xpath("//*[@href='/product_details/19']"));
        WebElement ucuncuUrunGorunuyorMu = driver.findElement(By.xpath("//*[@href='/product_details/20']"));
        WebElement dorduncuUrunGorunuyorMu = driver.findElement(By.xpath("//*[@href='/product_details/22']"));

        Assert.assertTrue(ilkUrunGorunuyorMu.isDisplayed() && ikinciUrunGorunuyorMu.isDisplayed() &&
                ucuncuUrunGorunuyorMu.isDisplayed() && dorduncuUrunGorunuyorMu.isDisplayed());

//11. Click Proceed To Checkout --Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.cssSelector("a[class=\"btn btn-default check_out\"]")).click();

//12. Verify that the delivery address is same address filled at the time registration of account
        //Teslimat adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın


        String firsLastNameTeslimat = driver.findElement(By.xpath("(//*[@class='address_firstname address_lastname'])[1]")).getText();
        String adress1Teslimat = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[1]")).getText();
        String adress2Teslimat = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[2]")).getText();
        String adress3Teslimat = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[3]")).getText();
        String ulkeSehirPostaKoduTeslimat = driver.findElement(By.xpath("(//*[@class='address_city address_state_name address_postcode'])[1]")).getText();
        String ulkeIsmiTeslimat = driver.findElement(By.xpath("(//*[@class='address_country_name'])[1]")).getText();
        String telefonNuTeslimat = driver.findElement(By.xpath("(//*[@class='address_phone'])[1]")).getText();


        String adresBilgileri1 = driver.findElement(By.id("address_delivery")).getText();
        System.out.println("adresBilgileri1 = " + adresBilgileri1);

        String adresBilgileri2 = driver.findElement(By.id("address_invoice")).getText();
        System.out.println("adresBilgileri2 = " + adresBilgileri1);


//13. Verify that the billing address is same address filled at the time registration of account
        //Fatura adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın

        String firsLastNameFatura = driver.findElement(By.xpath("(//*[@class='address_firstname address_lastname'])[1]")).getText();
        String adress1Fatura = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[1]")).getText();
        String adress2Fatura = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[2]")).getText();
        String adress3Fatura = driver.findElement(By.xpath("(//*[@class='address_address1 address_address2'])[3]")).getText();
        String ulkeSehirPostaKoduFatura = driver.findElement(By.xpath("(//*[@class='address_city address_state_name address_postcode'])[1]")).getText();
        String ulkeIsmiFatura = driver.findElement(By.xpath("(//*[@class='address_country_name'])[1]")).getText();
        String telefonNuFatura = driver.findElement(By.xpath("(//*[@class='address_phone'])[1]")).getText();

//14. Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
        Thread.sleep(3000);


//15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
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

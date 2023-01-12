    package alistirmalar.ornek_test_caseler.automationexcercise;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import utilities.TestBase;

    public class C02_UserId_002 extends TestBase {

    @Test
    public void ValideUsername_ValidPasswordTestiTC_01() {

    /*
    TestCase:  Gecerli kullanici adi ve gecerli sifre ile erisilebilir.
    1. Kullanici https://www.automationexercise.com/ adresine gider.
    2. Kullanici Signup / Login ' e tiklar.
    3. Kullanici Login to your account Email address yazan bolume  "Gecerli" bir mail adresi (kusulua@gmail.com) girer.
    4. Kullanici  Login to your account Password bolumune "Gecerli" bir password (014036) girer.
    5. Kullanici  Login butonuna tiklar.
 */
    //1. https://www.automationexercise.com/ adresine gidin
    driver.get("https://www.automationexercise.com/");

    //2. Signup / Login ' e tiklayin
    WebElement signupLoginButton= driver.findElement(By.xpath("//a[@href='/login']"));
    signupLoginButton.click();

    //3. Kullanici Login to your account Email address yazan bolume  "Gecerli" bir mail adresi (kusulua@gmail.com) girer.
    WebElement loginEmail= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
    loginEmail.sendKeys("kusulua@gmail.com");



    //4. Kullanici  Login to your account Password bolumune "Gecerli" bir password (014036) girer.
    WebElement loginPassword= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
    loginPassword.sendKeys("014036");



    // 5. Kullanici  Login butonuna tiklar.
    driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

    //6. Acilan ekranda "Logged in as "username"" yazisinin  gorundugunu dogrulayin
    WebElement actualLoggedInAsText= driver.findElement(By.xpath("//a//i[@class='fa fa-user']"));

    Assert.assertTrue(actualLoggedInAsText.isDisplayed());

    }
    }

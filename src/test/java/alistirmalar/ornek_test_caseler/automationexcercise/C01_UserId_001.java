    package alistirmalar.ornek_test_caseler.automationexcercise;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import utilities.TestBase;

    public class C01_UserId_001 extends TestBase {


    @Test
    public void invalideEmailAdress_ValidPasswordTestiTC_01(){

    /*
    TestCase: Geçersiz kullanici adi ve geçerli sifre ile erisilemez.
    1. Kullanici https://www.automationexercise.com/ adresine gider.
    2. Kullanici Signup / Login ' e tiklar.
    3. Kullanici Login to your account Email address yazan bolume  Gecersiz (kUsuLu@gmail.com) bir mail adresi girer.
    4. Kullanici  Login to your account Password bolumune Gecerli bir password (014036) girer.
    5. Kullanici  Login butonuna tiklar.
    6. ekrana gelen mesajin "Your email or password is incorrect!" oldugunu dogrulayin

    */
    //1. https://www.automationexercise.com/ adresine gidin
    driver.get("https://www.automationexercise.com/");

    //2. Signup / Login ' e tiklayin
    WebElement signupLoginButton= driver.findElement(By.xpath("//a[@href='/login']"));
    signupLoginButton.click();

    //3. Kullanici Login to your account Email address yazan bolume  Gecersiz (kUsuLu@gmail.com) bir mail adresi girer.
    WebElement loginEmail= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
    loginEmail.sendKeys("kUsuLu@gmail.com");

    //4. Kullanici  Login to your account Password bolumune Gecerli bir password (014036) girer.
    WebElement loginPassword= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
    loginPassword.sendKeys("014036");

    //Kullanici  Login butonuna tiklar.
    driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

    //6. ekrana gelen mesajin "Your email or password is incorrect!" oldugunu dogrulayin
    String actualResultMessage= driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).getText();
    System.out.println("actualResultMessage = " + actualResultMessage);
    String expectedResultMessage= "Your email or password is incorrect!";
   // Assert.assertEquals(expectedResultMessage, actualResultMessage);
    }

    @Test
    public void valideEmailAdress_InValidPasswordTestiTC_02() {

    /*
    TestCase: Geçerli kullanici adi ve geçersiz sifre ile erisilemez.
    1. Kullanici https://www.automationexercise.com/ adresine gider.
    2. Kullanici Signup / Login ' e tiklar.
    3. Kullanici Login to your account Email address yazan bolume  Gecerli bir mail adresi (kusulua@gmail.com) girer.
    4. Kullanici  Login to your account Password bolumune Gecersiz bir password (015036) girer.
    5. Kullanici  Login butonuna tiklar.
    6. ekrana gelen mesajin "Your email or password is incorrect!" oldugunu dogrulayin

    */
    //1. https://www.automationexercise.com/ adresine gidin
    driver.get("https://www.automationexercise.com/");

    //2. Signup / Login ' e tiklayin
    WebElement signupLoginButton= driver.findElement(By.xpath("//a[@href='/login']"));
    signupLoginButton.click();

    //3.Kullanici Login to your account Email address yazan bolume  Gecerli bir mail adresi (kusulua@gmail.com) girer.
    WebElement loginEmail= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
    loginEmail.sendKeys("kusulua@gmail.com");



    //4. Kullanici  Login to your account Password bolumune Gecersiz bir password (015036) girer.
    WebElement loginPassword= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
    loginPassword.sendKeys("015036");



    // 5. Kullanici  Login butonuna tiklar.
    driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

    //6. ekrana gelen mesajin "Your email or password is incorrect!" oldugunu dogrulayin
    String actualResultMessage= driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).getText();
    System.out.println("actualResultMessage = " + actualResultMessage);
    String expectedResultMessage= "Your email or password is incorrect!";
    Assert.assertEquals(expectedResultMessage, actualResultMessage);

    }








    @Test
    public void inValideEmailAdress_InValidPasswordTestiTC_03() {

    /*
    TestCase: Geçersiz kullanici adi  ve geçersiz sifre ile erisilemez.
    1. Kullanici https://www.automationexercise.com/ adresine gider.
    2. Kullanici Signup / Login ' e tiklar.
    3. Kullanici Login to your account Email address yazan bolume  "Gecersiz" bir mail adresi (kUsulua@gmail.com) girer.
    4. Kullanici  Login to your account Password bolumune "Gecersiz" bir password (015036) girer.
    5. Kullanici  Login butonuna tiklar.


    */
    //1. https://www.automationexercise.com/ adresine gidin
    driver.get("https://www.automationexercise.com/");

    //2. Signup / Login ' e tiklayin
    WebElement signupLoginButton= driver.findElement(By.xpath("//a[@href='/login']"));
    signupLoginButton.click();

    //3.  Kullanici Login to your account Email address yazan bolume  "Gecersiz" bir mail adresi (kUsulua@gmail.com) girer.
    WebElement loginEmail= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
    loginEmail.sendKeys("kUsulua@gmail.com");



    //4.  Kullanici  Login to your account Password bolumune "Gecersiz" bir password (015036) girer.
    WebElement loginPassword= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
    loginPassword.sendKeys("015036");



    // 5. Kullanici  Login butonuna tiklar.
    driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

    //6. ekrana gelen mesajin "Your email or password is incorrect!" oldugunu dogrulayin
    String actualResultMessage= driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).getText();
    System.out.println("actualResultMessage = " + actualResultMessage);
    String expectedResultMessage= "Your email or password is incorrect!";
    Assert.assertEquals(expectedResultMessage, actualResultMessage);

    }

    }

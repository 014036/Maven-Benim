    package alistirmalar.ornek_test_caseler.n1_login_test;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import utilities.TestBase;

    public class N11_LoginPageTest extends TestBase {


    @Test
    public void inValidEmail_ValidPasswordTest() {
    //1. Kullanici https://www.n11.com/ adresine gider.
    driver.get("https://www.n11.com/");

    //2. Anasayfadaki "Giris Yap" butonu gorunur olmalidir.
    WebElement girisYapButton= driver.findElement(By.xpath("//a[@title='Giriş Yap']"));
    Assert.assertTrue(girisYapButton.isDisplayed());

    //3. Kullanici "Giris Yap" butonuna tiklar.
    girisYapButton.click();

    //3. Kullanici, "E-Posta Adresi" yazan bolume  "Gecersiz" bir mail adresi girer.
    //WebElement eMailBox= driver.findElement(By.xpath("//input[@id='email']"));
    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Test.123.yap@gmail.com");

    //4. Kullanici  "Sifre"bolumune Gecerli" bir sifre girer.
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Deneme123!");

    //5. Kullanici  "Giris Yap" butonuna tiklar.
    driver.findElement(By.xpath("//div[@id='loginButton']")).click();


    //6. Kullanici erisim saglamamalidir. "E-posta adresiniz veya şifreniz hatalı" mesajini almalidir
    String ecpectedResultMessage= "E-posta adresiniz veya şifreniz hatalı";
    // String actualResultMessage= driver.findElement(By.xpath("//div[.='E-posta adresiniz veya şifreniz hatalı']")).getText();
    String actualResultMessage= driver.findElement(By.xpath("(//div[@class='errorText'])[4]")).getText();
    waitFor(5);
    System.out.println("actualResultMessage = " + actualResultMessage);
    Assert.assertEquals(ecpectedResultMessage, actualResultMessage);

    }





    @Test
    public void ValidEmail_InValidPasswordTest() {
    //1. Kullanici https://www.n11.com/ adresine gider.
    driver.get("https://www.n11.com/");

    //2. Anasayfadaki "Giris Yap" butonu gorunur olmalidir.
    WebElement girisYapButton= driver.findElement(By.xpath("//a[@title='Giriş Yap']"));
    Assert.assertTrue(girisYapButton.isDisplayed());

    //3. Kullanici "Giris Yap" butonuna tiklar.
    girisYapButton.click();

    //3. Kullanici, "E-Posta Adresi" yazan bolume  "Gecersiz" bir mail adresi girer.
    //WebElement eMailBox= driver.findElement(By.xpath("//input[@id='email']"));
    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test.123.yap@gmail.com");

    //4. Kullanici  "Sifre"bolumune Gecerli" bir sifre girer.
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("deneme123!");

    //5. Kullanici  "Giris Yap" butonuna tiklar.
    driver.findElement(By.xpath("//div[@id='loginButton']")).click();
    waitFor(5);

    //6. Kullanici erisim saglamamalidir. "E-posta adresiniz veya şifreniz hatalı" mesajini almalidir
    String ecpectedResultMessage= "E-posta adresiniz veya şifreniz hatalı";
    // String actualResultMessage= driver.findElement(By.xpath("//div[.='E-posta adresiniz veya şifreniz hatalı']")).getText();
    //WebElement actualResultMessage= driver.findElement(By.xpath("(//div[@class='errorText'])[4]"));
    WebElement actualResultMessage= driver.findElement(By.xpath("//div[@data-errormessagefor='password']"));
    waitForVisibility(actualResultMessage, 30);
    System.out.println("actualResultMessage = " + actualResultMessage.getText());
    Assert.assertEquals(ecpectedResultMessage, actualResultMessage.getText());

    }




        @Test
        public void inValidEmail_InValidPasswordTest() {
            //1. Kullanici https://www.n11.com/ adresine gider.
            driver.get("https://www.n11.com/");

            //2. Anasayfadaki "Giris Yap" butonu gorunur olmalidir.
            WebElement girisYapButton= driver.findElement(By.xpath("//a[@title='Giriş Yap']"));
            Assert.assertTrue(girisYapButton.isDisplayed());

            //3. Kullanici "Giris Yap" butonuna tiklar.
            girisYapButton.click();

            //3. Kullanici, "E-Posta Adresi" yazan bolume  "Gecersiz" bir mail adresi girer.
            //WebElement eMailBox= driver.findElement(By.xpath("//input[@id='email']"));
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Test.123.yap@gmail.com");

            //4. Kullanici  "Sifre"bolumune Gecerli" bir sifre girer.
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("deneme123!");

            //5. Kullanici  "Giris Yap" butonuna tiklar.
            driver.findElement(By.xpath("//div[@id='loginButton']")).click();
            waitFor(5);

            //6. Kullanici erisim saglamamalidir. "E-posta adresiniz veya şifreniz hatalı" mesajini almalidir
            String ecpectedResultMessage= "E-posta adresiniz veya şifreniz hatalı";
            // String actualResultMessage= driver.findElement(By.xpath("//div[.='E-posta adresiniz veya şifreniz hatalı']")).getText();
            //WebElement actualResultMessage= driver.findElement(By.xpath("(//div[@class='errorText'])[4]"));
            WebElement actualResultMessage= driver.findElement(By.xpath("//div[@data-errormessagefor='password']"));
            waitForVisibility(actualResultMessage, 30);
            System.out.println("actualResultMessage = " + actualResultMessage.getText());
            Assert.assertEquals(ecpectedResultMessage, actualResultMessage.getText());

        }





        @Test
        public void ValidEmail_ValidPasswordTest() {
            //1. Kullanici https://www.n11.com/ adresine gider.
            driver.get("https://www.n11.com/");

            //2. Anasayfadaki "Giris Yap" butonu gorunur olmalidir.
            WebElement girisYapButton= driver.findElement(By.xpath("//a[@title='Giriş Yap']"));
            Assert.assertTrue(girisYapButton.isDisplayed());

            //3. Kullanici "Giris Yap" butonuna tiklar.
            girisYapButton.click();

            //3. Kullanici, "E-Posta Adresi" yazan bolume  "Gecersiz" bir mail adresi girer.
            //WebElement eMailBox= driver.findElement(By.xpath("//input[@id='email']"));
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test.123.yap@gmail.com");

            //4. Kullanici  "Sifre"bolumune Gecerli" bir sifre girer.
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Deneme123!");

            //5. Kullanici  "Giris Yap" butonuna tiklar.
            driver.findElement(By.xpath("//div[@id='loginButton']")).click();
            waitFor(5);

            //6. Kullanici erisim saglamalidir
            WebElement kullaniciAdiGorunurMu= driver.findElement(By.xpath("//a[@title='Hesabım']"));
            Assert.assertTrue(kullaniciAdiGorunurMu.isDisplayed());


        }

    }

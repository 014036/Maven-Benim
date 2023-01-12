package alistirmalar.internet_herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Digest_Authentication {

    /*
    test01
    // https://the-internet.herokuapp.com/ adresine git
    //Digest Authentication (user and pass: admin) yazisina tikla
    //Acilan ekrandaki mesaji yazdir
    //Kullanici Adi ve Sifreyi gir
    //oturum ac'a bas

TEST 02
// https://the-internet.herokuapp.com/ adresine git
    //Digest Authentication (user and pass: admin) yazisina tikla
    //Acilan ekrandaki mesaji yazdir
    //iptal'e bas
    //bir onceki sayfaya geri don
     */

   static WebDriver driver;
    @Before
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {
    // https://the-internet.herokuapp.com/ adresine git
        driver.get("https://the-internet.herokuapp.com/");

    //Digest Authentication (user and pass: admin) yazisina tikla
        driver.findElement(By.xpath("//li/a[@href='/digest_auth']")).click();

    //Acilan ekrandaki mesaji yazdir


        //Kullanici Adi ve Sifreyi gir
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        Thread.sleep(5000);
    //oturum ac'a bas
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}

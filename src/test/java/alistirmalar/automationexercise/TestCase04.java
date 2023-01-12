package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase04 {
    /*
    Test Case 4: Logout User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
****************************************************

     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu= driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()){
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        }else  System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

//        4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

//        5. Verify 'Login to your account' is visible

        WebElement loginYourAccountYazisiVarMi= driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > h2"));
        if (loginYourAccountYazisiVarMi.isDisplayed()){
            System.out.println("loginYourAccountYazisiVarMi Testi PASSED");
        }else System.out.println("loginYourAccountYazisiVarMi Testi FAILED");


//        6. Enter correct email address and password
        WebElement eMailGirme= driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        eMailGirme.sendKeys("kusuluabc@gmail.com");

        WebElement sifreGirme= driver.findElement(By.cssSelector("input[data-qa='login-password']"));
        sifreGirme.sendKeys("014036");

//        7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

//        8. Verify that 'Logged in as username' is visible
        WebElement basariliGirisYazisiGorunuyorMu= driver.findElement(By.cssSelector("i[class='fa fa-user']"));
        if (basariliGirisYazisiGorunuyorMu.isDisplayed()){
            System.out.println("basariliGirisYazisiGorunuyorMu Testi PASSED");
        }else  System.out.println("basariliGirisYazisiGorunuyorMu Testi FAILED");

//        9. Click 'Logout' button

        driver.findElement(By.cssSelector("a[href='/logout']")).click();

//        10. Verify that user is navigated to login page
        WebElement anaSayfaLogosoGorunuyorMuSon= driver.findElement(By.cssSelector("i[class='fa fa-home']"));
        if (anaSayfaLogosoGorunuyorMuSon.isDisplayed()){
            System.out.println("anaSayfaLogosoGorunuyorMuSon Testi PASSED");
        }else System.out.println("anaSayfaLogosoGorunuyorMuSon Testi FAILED");
    }
}

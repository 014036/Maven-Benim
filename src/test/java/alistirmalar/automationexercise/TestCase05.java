package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase05 {
    /*
    Test Case 5: Register User with existing email
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
  */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu= driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()){
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        }else  System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

//        4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

//        5. Verify 'New User Signup!' is visible
        WebElement yeniKullaniciYazisiGorunurMu= driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > div > h2"));
        if (yeniKullaniciYazisiGorunurMu.isDisplayed()){
            System.out.println("yeniKullaniciYazisiGorunurMu Testi PASSED");
        }else System.out.println("yeniKullaniciYazisiGorunurMu Testi FAILED");

////        6. Enter name and already registered email address
//        WebElement nameGirme= driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
//        nameGirme.sendKeys("Mustafa");
//        WebElement eMailGir= driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
//        eMailGir.sendKeys("kusuluabc@gmail.com");
//
////        7. Click 'Signup' button
//        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
//
////        8. Verify error 'Email Address already exist!' is visible
//        WebElement eMailTekrariHatasiAliniyorMu= driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > p"));
//        if (eMailTekrariHatasiAliniyorMu.isDisplayed()){
//            System.out.println("eMailTekrariHatasiAliniyorMu Testi PASSED");
//        }else System.out.println("eMailTekrariHatasiAliniyorMu Testi FAILED");
//
//        driver.close();
    }
}

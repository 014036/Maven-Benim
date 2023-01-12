package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase02 {
    public static void main(String[] args) {

        /*
        Test Case 2: Login User with correct email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
******************************************************

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//    2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//    3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu= driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()){
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        }else  System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

//    4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();

//    5. Verify 'Login to your account' is visible
WebElement loginToYourAccount =driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));

if (loginToYourAccount.isDisplayed()){
    System.out.println("loginToYourAccount Testi PASSED");
}else    System.out.println("loginToYourAccount Testi FAILED");

//    6. Enter correct email address and password
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("kusuluabc@gmail.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("014036");

//    7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

//    8. Verify that 'Logged in as username' is visible
        WebElement loggedInUserNameGorunuyorMu =driver.findElement(By.cssSelector("i[class='fa fa-user']"));
        if (loggedInUserNameGorunuyorMu.isDisplayed()){
            System.out.println("loggedInUserNameGorunuyorMu Testi PASSED");
        }else System.out.println("loggedInUserNameGorunuyorMu Testi FAILED");


////    9. Click 'Delete Account' button
//        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
//
////    10. Verify that 'ACCOUNT DELETED!' is visible
//
//        WebElement accountDeletedYazisiGorunuyorMu =driver.findElement(By.cssSelector("h2[data-qa='account-deleted']"));
//
//        if (accountDeletedYazisiGorunuyorMu.isDisplayed()){
//            System.out.println("accountDeletedYazisiGorunuyorMu Testi PASSED");
//        }else            System.out.println("accountDeletedYazisiGorunuyorMu Testi FAILED");
//
//        driver.close();
    }
}

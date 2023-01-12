package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase03 {
    /*
    Test Case 3: Login User with incorrect email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
******************************************************

     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
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

//    6. Enter incorrect email address and password
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("kus@hags.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("kus@hags");


//    7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

//    8. Verify error 'Your email or password is incorrect!' is visible
        WebElement gecersizEmailVeSifreYazisi=driver.findElement(By.cssSelector("p[style]"));
        if (gecersizEmailVeSifreYazisi.isDisplayed()){
            System.out.println("gecersizEmailVeSifreYazisi Testi PASSED");
        }else   System.out.println("gecersizEmailVeSifreYazisi Testi FAILED");

        driver.close();
    }
}

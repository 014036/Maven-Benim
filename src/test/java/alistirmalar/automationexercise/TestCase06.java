package alistirmalar.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase06 {

    /*
    Test Case 6: Contact Us Form
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
****************************************************

     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu = driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()) {
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        } else System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

//        4. Click on 'Contact Us' button
        driver.findElement(By.cssSelector("a[href='/contact_us']")).click();

//        5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchYazisiVarmi = driver.findElement(By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > h2"));
        if (getInTouchYazisiVarmi.isDisplayed()) {
            System.out.println("getInTouchYazisiVarmi Testi PASSED");
        } else System.out.println("getInTouchYazisiVarmi Testi FAILED");


//        6. Enter name, email, subject and message
        WebElement nameGir = driver.findElement(By.cssSelector("input[data-qa='name']"));
        nameGir.sendKeys("Mustafa");

        WebElement eMailGir = driver.findElement(By.cssSelector("input[data-qa='email']"));
        eMailGir.sendKeys("kusulu@gmailcom");

        WebElement subjectGir = driver.findElement(By.cssSelector("input[data-qa='subject']"));
        subjectGir.sendKeys("Turkce");


        WebElement mesajGir = driver.findElement(By.cssSelector("textarea[data-qa='message']"));
        mesajGir.sendKeys("Iyi calismaliyim", Keys.TAB);


//        7. Upload file
        driver.findElement(By.cssSelector("input[name='upload_file']")).sendKeys("C:\\Users\\hp\\Desktop\\MASAÜSÜTÜ KLASÖR\\DekontPdfDiger.pdf");


//        8. Click 'Submit' button

        driver.findElement(By.cssSelector("input[data-qa='submit-button']")).click();
////        9. Click OK button
        driver.switchTo().alert().accept();
////        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement islemBasariliYazisiGeldiMi = driver.findElement(By.cssSelector("div[class='status alert alert-success']"));
        if (islemBasariliYazisiGeldiMi.isDisplayed()) {
            System.out.println("islemBasariliYazisiGeldiMi Testi PASSED");
        } else System.out.println("islemBasariliYazisiGeldiMi Testi FAILED");

//        11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.cssSelector("a[class='btn btn-success']")).click();


        WebElement anaSayfaTusuGorunuyorMuSon = driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMuSon.isDisplayed()) {
            System.out.println("anaSayfaTusuGorunuyorMuSon Testi PASSED");
        } else System.out.println("anaSayfaTusuGorunuyorMuSon Testi FAILED");
    }
}

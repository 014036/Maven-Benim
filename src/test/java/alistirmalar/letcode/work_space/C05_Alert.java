package alistirmalar.letcode.work_space;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Alert {
    static WebDriver driver;

    /*
// https://letcode.in/ adresine git
//Work-Space yazisina tikla
//Acilan pencereden Alert e tikla
//Simple Alert' butonuna bas; cikan mesaji yazdir; gelen uyariyi kabul et
//Confirm Alert'e tikla; uyarı metnini yazdır gelen uyariyi iptal et
// Prompt Alert' e tikla ; gelen ekrana ismini yazdir ve kabul et'e tikla
//Modern Alert'e tikla; "Modern Alert - Some people address me as sweet alert as well" mesajini dogrula


     */

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void alert() throws InterruptedException {
// https://letcode.in/ adresine git
        driver.get("https://letcode.in/");

//Work-Space yazisina tikla
        driver.findElement(By.id("testing")).click();

//Acilan pencereden Alert e tikla
        driver.findElement(By.xpath("//a[@href='/alert']")).click();

//Simple Alert' butonuna bas; cikan mesaji yazdir; gelen uyariyi kabul et
        driver.findElement(By.id("accept")).click();
        String accetText = driver.switchTo().alert().getText();
        System.out.println("accetText = " + accetText);
        driver.switchTo().alert().accept();

//Confirm Alert'e tikla; uyarı metnini yazdır gelen uyariyi iptal et
        driver.findElement(By.id("confirm")).click();
        String dismisText = driver.switchTo().alert().getText();
        System.out.println("dismisText = " + dismisText);
        driver.switchTo().alert().dismiss();

// Prompt Alert' e tikla ; gelen ekrana ismini yazdir ve kabul et'e tikla
        driver.findElement(By.id("prompt")).click();
        String promptText = driver.switchTo().alert().getText();
        System.out.println("promptText = " + promptText);

        driver.switchTo().alert().sendKeys("mustafa");

        driver.switchTo().alert().accept();
        String prompAlertMyName= driver.findElement(By.id("myName")).getText();
        System.out.println("prompAlertMyName = " + prompAlertMyName);

//Modern Alert'e tikla; "Modern Alert - Some people address me as sweet alert as well" mesajini dogrula
        driver.findElement(By.id("modern")).click();
        String actualModernAlertText = driver.findElement(By.xpath("//div[@class='card']")).getText();
//        String expectedModernAlertText = "Modern Alert - Some people address me as sweet alert as well";
//        Assert.assertEquals(expectedModernAlertText, actualModernAlertText);

    }

    @After
    public void TearDown() {
        driver.quit();
    }
}

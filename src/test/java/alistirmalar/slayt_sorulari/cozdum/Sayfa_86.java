package alistirmalar.slayt_sorulari.cozdum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Sayfa_86 {

    /*
    1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
○ titleTest
○ imageTest
=> Sayfa başlığının “YouTube” oldugunu test edin
=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest() {
        //=> Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.equals("YouTube"));

    }

    @Test
    public void imageTest() {

        //YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youTubeResmi= driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));

Assert.assertTrue(youTubeResmi.isDisplayed());
    }

    @Test
    public void wrongTitleTest() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle= driver.getTitle();
        Assert.assertTrue(!actualTitle.equals("youTube"));

    }

    @Test
    public void searhBooxs() {

        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searhBooxs= driver.findElement(By.xpath("(//*[@id='search'])[2]"));
        Assert.assertTrue(searhBooxs.isEnabled());
    }


    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}

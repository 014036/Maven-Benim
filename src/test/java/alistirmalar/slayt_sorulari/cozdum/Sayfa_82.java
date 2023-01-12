package alistirmalar.slayt_sorulari.cozdum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Sayfa_82 {

    /*
    1. Bir class oluşturun : RadioButtonTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
- https://www.facebook.com adresine gidin
- Cookies’i kabul edin
- “Create an Account” button’una basin
- “radio buttons” elementlerini locate edin
- Secili degilse cinsiyet butonundan size uygun olani secin
     */
static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");

    }


    @Test
    public void test01() {

      //- Cookies’i kabul edin
        //- “Create an Account” button’una basin

       // driver.findElement(By.id("u_0_0_yq")).click();//hesap olustur

driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();


        //- “radio buttons” elementlerini locate edin
        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys("as");//isim
        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[2]")).sendKeys("df");//soyisim
        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[3]")).sendKeys("gh@gmail.com");//tel
        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[5]")).sendKeys("asdfre34");//sifre


       // driver.findElement(By.id("day")).sendKeys("20");//gun
        WebElement dayDropDown= driver.findElement(By.id("day"));
        Select day= new Select(dayDropDown);
        day.selectByVisibleText("20");




        //    driver.findElement(By.id("month")).sendKeys("02");//ay
        WebElement monthDropDown= driver.findElement(By.id("month"));
        Select month= new Select(monthDropDown);
        day.selectByValue("5");


      //  driver.findElement(By.id("year")).sendKeys("2000");//yil

        WebElement yerDropDown= driver.findElement(By.id("year"));
        Select year= new Select(yerDropDown);
        year.selectByVisibleText("2005");

        //- Secili degilse cinsiyet butonundan size uygun olani secin

        driver.findElement(By.id("year")).sendKeys(Keys.TAB, Keys.TAB, Keys.ARROW_RIGHT,Keys.SPACE);
        //WebElement cinsiyet=driver.findElement(By.xpath("//*[@id='u_w_5_di']"));//
//        WebElement cinsiyet=driver.findElement(By.xpath("//*[@for='u_w_5_di']"));//
//        if (!cinsiyet.isSelected()){
//            cinsiyet.click();
//        }
    }
}

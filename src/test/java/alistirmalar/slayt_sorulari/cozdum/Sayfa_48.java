package alistirmalar.slayt_sorulari.cozdum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Sayfa_48 {
    public static void main(String[] args) {


        /*
        SAYFA 48
        1. Bir class oluşturun : AmazonSearchTest
2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
a.web sayfasına gidin. https://www.amazon.com/
b. Search(ara) “city bike”
c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
         */

//
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
//                a.web sayfasına gidin. https://www.amazon.com/

        driver.get("https://www.amazon.com/");

//        b. Search(ara) “city bike”
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);


//        c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın

       WebElement aramaSonucSayisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("Arama Sonucu Sayisi = "+aramaSonucSayisi.getText());

//        d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //sayfayi kapatin
        driver.close();
    }
}

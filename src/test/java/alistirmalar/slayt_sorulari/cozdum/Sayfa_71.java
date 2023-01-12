package alistirmalar.slayt_sorulari.cozdum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Sayfa_71 {
    /*
    Class Work Amazon Search Test
1 https://www.amazon.com/ sayfasina gidelim
2 arama kutusunu locate edelim
3 “Samsung headphones” ile arama yapalim
4 Bulunan sonuc sayisini yazdiralim
5 Ilk urunu tiklayalim
6 Sayfadaki tum basliklari yazdiralim
     */

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2 arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //3 “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //4 Bulunan sonuc sayisini yazdiralim
        String urunSayisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println("urunSayisi = " + urunSayisi);

        //5 Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//a[@class=\"a-link-normal s-no-outline\"])[1]")).click();

        //6 Sayfadaki tum basliklari yazdiralim
        //List<WebElement> title = driver.findElements(By.id("productTitle"));

    }
}

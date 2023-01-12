package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


import java.util.ArrayList;
import java.util.List;

public class Sayfa_104 extends TestBase {

    /*
    Handle Iframe Class Work
● Bir class olusturun: IframeTest02
1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
2) sayfadaki iframe sayısını bulunuz.
3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
4) ilk iframe'den çıkıp ana sayfaya dönünüz
5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
tıklayınız
eleman.clear()
     */

    @Test
    public void test01() throws InterruptedException {
       //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement>iframeSayisi= driver.findElements(By.xpath("//iframe"));
        System.out.println("iframeSayisi.size() = " + iframeSayisi.size());
   // iframeSayisi.forEach(t-> System.out.println(t.getText()));// NEDEN IFRAME ISIMLERINI YAZMIYOR


        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframe1= driver.findElement(By.xpath("//div/div/div/div/iframe[@frameborder='0']"));
       driver.switchTo().frame(iframe1);
       // driver.switchTo().frame(driver.findElement(By.xpath("//*[@wmode='transparent']")));
        driver.findElement(By.xpath("//*[@aria-label='YouTube Video Oynatıcısı']")).click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        driver.navigate().refresh();
        Thread.sleep(5000);

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement iframe2= driver.findElement(By.xpath("//div[@id='rt-page-surround']//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(iframe2);

        Thread.sleep(2000);
       // driver.findElement(By.xpath("//*[@href=' http://www.guru99.com/live-selenium-project.html']")).click();
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();


    }
}

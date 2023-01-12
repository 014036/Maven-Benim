package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Sayfa_135_ActionGenelTekrar extends TestBase {


    /*
    1. "http://webdriveruniversity.com/Actions" sayfasina gidin
2. "Hover over Me First" kutusunun ustune gelin
3. "Link 1" e tiklayin
4. Popup mesajini yazdirin
5. Popup'i tamam diyerek kapatin
6. "Click and hold" kutusuna basili tutun
7. "Click and hold" kutusunda cikan yaziyi yazdirin
8. "Double click me" butonunu cift tiklayin
     */


    @Test
    public void hoverOverTest(){
//1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

//2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverMeFirstButton= driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        actions.moveToElement(hoverMeFirstButton).build().perform();

//3. "Link 1" e tiklayin
        WebElement link1Button= driver.findElement(By.xpath("(//div[@class='dropdown-content'])[1]"));
        actions.click(link1Button).build().perform();

//4. Popup mesajini yazdirin
       String alertMessage=  driver.switchTo().alert().getText();
        System.out.println("alertMessage = " + alertMessage);

//5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

//6. "Click and hold" kutusuna basili tutun
     WebElement clickAndHoldButton=   driver.findElement(By.id("click-box"));
     actions.clickAndHold(clickAndHoldButton).build().perform();

//7. "Click and hold" kutusunda cikan yaziyi yazdirin
        waitFor(2);
        String clickAndHoldMessage= driver.findElement(By.id("click-box")).getText();
        System.out.println("clickAndHoldMessage = " + clickAndHoldMessage);

//8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickButton= driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickButton).build().perform();


    }
}

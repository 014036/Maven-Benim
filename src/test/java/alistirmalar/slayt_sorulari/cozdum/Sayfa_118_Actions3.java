    package alistirmalar.slayt_sorulari.cozdum;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;

    public class Sayfa_118_Actions3 extends TestBase {

    /*
    2 https://www.amazon.com sayfasina gidelim
    3 Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    4 aramanin gerceklestigini test edin
    */


    @Test
    public void amazon() {
    //2 https://www.amazon.com sayfasina gidelim
    driver.get("https://www.amazon.com/");
    Actions actions= new Actions(driver);

    //3 Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    WebElement searchtextbox = driver.findElement(By.id("twotabsearchtextbox"));
    actions.sendKeys(searchtextbox,"samsung A71", Keys.ENTER).perform();

    //4 aramanin gerceklestigini test edin
    String aramaSonucuText= driver.findElement(By.xpath("//span[.='1-16 of 56 results for']")).getText();
    System.out.println("aramaSonucuText = " + aramaSonucuText);
    //veya
    WebElement aramaSonucu= driver.findElement(By.xpath("//span[.='1-16 of 56 results for']"));
    Assert.assertTrue(aramaSonucu.isDisplayed());
    }
    }

    package alistirmalar.slayt_sorulari.cozdum;

    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;

    public class Sayfa_114_Actions extends TestBase {

    /*
    2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
    3- Cizili alan uzerinde sag click yapalim
    4 Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
    5 Tamam diyerek alert’i kapatalim
    6 Elemental Selenium linkine tiklayalim
    7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    */


    @Test
    public void actionsTest01() {

    Actions actions=  new Actions(driver);

    //    2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
    driver.get("https://the-internet.herokuapp.com/context_menu");

    //3- Cizili alan uzerinde sag click yapalim
    WebElement cizgiliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
    actions.contextClick(cizgiliAlan).perform();
    waitFor(5);

    //4 Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    String actualAlertMesage= driver.switchTo().alert().getText();
    System.out.println("actualAlertMesage = " + actualAlertMesage);
    String expectedAllertMessage= "You selected a context menu";

    //5 Tamam diyerek alert’i kapatalim
    driver.switchTo().alert().accept();

    //6 Elemental Selenium linkine tiklayalim
    driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).click();

    //7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    switchToWindow(2);
    String actualH1Text=  driver.findElement(By.xpath("//h1")).getText();
    System.out.println("actualH1Text = " + actualH1Text);
    String expectedH1Text= "Elemental Selenium";
    }
    }

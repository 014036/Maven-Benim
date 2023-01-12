    package alistirmalar.slayt_sorulari.cozdum;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;

    public class Sayfa_116_ActionsMoveToElement extends TestBase {


    /*
    1 https://www.amazon.com/ adresine gidelim

    2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin   mouse’u bu menunun ustune getirelim
    3 “Create a list” butonuna basalim
    4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
    */

    @Test
    public void amazonActionsTest01() {
    //1 https://www.amazon.com/ adresine gidelim
    driver.get("https://www.amazon.com/");

    //2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin   mouse’u bu menunun ustune getirelim
    Actions actions= new Actions(driver);
    WebElement signIn= driver.findElement(By.id("nav-link-accountList"));
    actions.moveToElement(signIn).perform();
    waitFor(2);

    //3 “Create a list” butonuna basalim
    driver.findElement(By.xpath("//span[.='Create a List']")).click();

    //4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
    waitFor(2);
    String text= driver.findElement(By.xpath("//div[@role='heading']")).getText();
    System.out.println("text = " + text);
    String expectedText= "Your Lists";
    Assert.assertTrue(text.contains(expectedText));

    }
    }




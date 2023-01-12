    package alistirmalar.ornek_test_caseler.kendimyazdim;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.ui.Select;
    import utilities.TestBase;

    import java.util.ArrayList;
    import java.util.List;

    public class AmazonActions extends TestBase {

    /*
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

    */

    @Test
    public void test01(){
    // https://amazon.com adresine gidiniz
    driver.get("https://amazon.com");
    waitFor(3);

    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    WebElement languageBox= driver.findElement(By.id("icp-nav-flyout"));
    Actions actions= new Actions(driver);
    actions.moveToElement(languageBox).perform();
    waitFor(3);

    // Change country/region butonuna basiniz
    WebElement changeCountryButton= driver.findElement(By.xpath("(//a[@id='icp-flyout-mkt-change'])[1]"));
    changeCountryButton.click();
    waitFor(1);

    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    WebElement ulkeSec= driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
    Select select = new Select(ulkeSec);
    select.selectByVisibleText("Turkey (Türkiye)");

    //        driver.findElement(By.xpath("(//span[@class='a-dropdown-prompt'])[2]")).click();
    //        driver.findElement(By.id("icp-dropdown-item-18")).click();
    String windowHnadle_1= driver.getWindowHandle();
    waitFor(1);
    // Go to website butonuna tiklayiniz
    //Drop down opsiyon listesi 'Go to website' butonuna basmamıza engel oldugu icin
    //herhangi bir yere clic yapıp drop down opsiyon listesinin toparlanmasını sagladık
    driver.findElement(By.xpath("//div[@class='a-column a-span1']")).click();
    waitFor(1);

    // Go to website butonuna tiklayiniz
    driver.findElement(By.id("icp-save-button")).click();

    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
    waitFor(1);
    List<String>allWindowHandles= new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(allWindowHandles.get(1));
    String actualTitle= driver.getTitle();
    String expectedTitle= "Elektronik";
    Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    }

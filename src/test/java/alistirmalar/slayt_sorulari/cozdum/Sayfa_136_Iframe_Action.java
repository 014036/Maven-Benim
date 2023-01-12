    package alistirmalar.slayt_sorulari.cozdum;

    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;


    public class Sayfa_136_Iframe_Action extends TestBase {

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
    public void test01() {
    //  1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    driver.get("http://webdriveruniversity.com/Actions");

    //    2. "Hover over Me First" kutusunun ustune gelin
    Actions  actions = new Actions(driver);
    WebElement meFirstButton= driver.findElement(By.xpath("//div[@class='dropdown hover']"));
    actions.moveToElement(meFirstButton).build().perform();

    //    3. "Link 1" e tiklayin
    driver.findElement(By.xpath("(//*[@class='dropdown-content'])[1]")).click();

    //    4. Popup mesajini yazdirin
    String alertMessage= driver.switchTo().alert().getText();
    System.out.println("alertMessage = " + alertMessage);

    //    5. Popup'i tamam diyerek kapatin
    driver.switchTo().alert().accept();

    //    6. "Click and hold" kutusuna basili tutun
    WebElement clickAndHoldBas= driver.findElement(By.xpath("//div[@id='click-box']"));
    actions.clickAndHold(clickAndHoldBas).build().perform();

    //    7. "Click and hold" kutusunda cikan yaziyi yazdirin
    System.out.println("clickAndHoldBas.getText() = " + clickAndHoldBas.getText());

    //    8. "Double click me" butonunu cift tiklayin
    WebElement doubleClickYap= driver.findElement(By.xpath("//h2"));
    String ilkDoubleClassName=doubleClickYap.findElement(By.xpath("//div[@class='div-double-click']")).getText();
    System.out.println("ilkDoubleClassName = " + ilkDoubleClassName);
    actions.doubleClick(doubleClickYap).build().perform();
    //9. Butonun renk degistirdigini dogrula
    String expectedClassName= doubleClickYap.findElement(By.xpath("//div[@class='div-double-click double']")).getText();
    System.out.println("expectedClassName = " + expectedClassName);


    }
    }

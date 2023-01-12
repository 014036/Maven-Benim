package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/*
TESTBASE ICINDEKI METHODLAR
1- BEFORE
2- AFTER
3- PENCERELER ARASI GECIS YAPMA (switchToWindow)
4- DROPDOWN SELECT METHODU -selectFromDropdown (Dropdawn icinde tekrar tekrar kullanmak istedigimiz zaman)
5- Tam sayfa açılan reklamı kapatmak için oluşturulan method (clickOutside)
6- ISLEM BASAMAKLARI ARASINDA BEKLEMEK ICIN (waitFor)
7-Sayfanın altından kayan reklamı kapatmak için oluşturulan method (kayanReklamiKapat)
8- ACTIONS METHODLARI
       a- ACTIONS_RIGHT CLICK
       b- ACTIONS_DOUBLE CLICK
       c- ACTIONS_SCROLL_DOWN
       d- ACTIONS_SCROLL_UP
       e- ACTIONS_SCROLL_RIGHT
       f- ACTIONS_SCROLL_LEFT
       g- ACTIONS_DRAG_AND_DROP
       h- ACTIONS_DRAG_AND_DROP_BY
9- DYNAMIC SELENIUM WAITS: (Bekleme methodlari)
 */


public abstract class TestBase {

    /*
●TestBase, testlerden önce ve sonra tekrar tekrar kullandığımız kodları içermektedir.
●İçerisindeki metodları kullanabilmemiz icin extends yapıyoruz. Bu sayede test class’ımızda sadece test
case’ler bulunmaktadır.
● Utilities package’da TestBase’i oluşturuyoruz.
○ setUp method
○ reports (Raporlar)
○ tearDown method
●TestBase class’i abstract yapabiliriz (Olmasada olabilir) , extends yaparak kullanabiliriz. Ve bu
class’da object create edemeyiz.
● olusturdugumuz driver’in farkli package’lardan kullanabilmek icin PROTECTED yapariz
Bu sinifin amaci obje olusturmak degil buraya extends yapmaktir

//    TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
//    TestBase testBase = new TestBase(); -> YAPILAMAZ
//    Amacim bu sinifi extend etmek ve icindeki hazir metodlari kullanmak

//    driver objesini olustur. Driver ya public yada protected olmali.
//    Sebepi child classlarda gorulebilir olmasi
     */
//driver objesini olustur. Driver public veya protected olmak zorundadir.
    //  Sebebi child classlardan cagrilabilmesidir

    protected static WebDriver driver;


    //setup methodu olustur
    @Before
    public void setUp() throws Exception {

        String userProfile= "C:\\Users\\hp\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+userProfile);
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    //tearDown olustur
    @After
    public void tearDown() throws Exception {
        //waitFor(3);
        driver.quit();
    }

    //PENCERELER ARASI GECIS YAPMAK ICIN
    public void switchToWindow(int sekmeNumarasi){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(sekmeNumarasi-1));
    }




    //    MULTIPLE WINDOW PENCERELER ARASI GECIS YAPMAK ICIN
    //1 Parametre alir: Gecis yapmak istedigim sayfanin Title'i
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }



    //Resuable Method> Dropdawn icinde tekrar tekrar kullanmak istedigimiz bir method olsuturalim
    public void selectFromDropdown(WebElement dropdown, String secenek){
        List<WebElement> tumOptions= dropdown.findElements(By.tagName("option"));

        for (WebElement w: tumOptions){
            if (w.getText().equals(secenek)) {
                w.click();         break;
            }
        }
    }


    //TAM SAYFA ACLIR REKLAM KAPATMAK ICIN
    public static void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }




    /*   HARD WAIT:
    @param : second
  */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //      Sayfanın altından kayan reklamı kapatmak için oluşturulan method. Reklamın açıldığı yerde kapatmak methodu çağırın.
    public void kayanReklamiKapat() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"grippy-host\"]")).click();
        Thread.sleep(2000);
    }



    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
//        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }
    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }
    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }
    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source,target).perform();
    }
    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source,x,y).perform();
    }





    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }


    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }
    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }


 /*
   // SHADOW ELEMENTLERI LOCATE ETMEK ICIN ASAGIDAKI YOL IZLENIR
    Thread.sleep(1000);
        SearchContext shadow1 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        WebElement book = shadow1.findElement(By.cssSelector("a[href='/']"));
        Assert.assertTrue(book.isDisplayed());
 */


    /*
    SLIDER (FILTER) DE ISTENEN DEGERI GONDERMEK ICIN ASAGIDAKI YOL IZLENIR
        JavascriptExecutor j = (JavascriptExecutor) driver;
        WebElement ads = driver.findElement(By.xpath("//*[@id='max_price']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", ads);
        ads.clear();
        ads.sendKeys("450");
     */

    /*
    Basic Authentication
    ALERT SEKLINDE YUKARIDAN ACILAN PENCERELERE KULLANICI ADI VE PASSWORD YAZDIRABILMEK ICIN
    (NORMAL ALERT'LERLE DEGER GONDEREMEDIKLERIMIZIN) ICIN
        //Kullanici Adi ve Sifreyi gir
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        ILK admin: username
        Ikinci admin: password
        adres satirinin sonuna da "basic_auth" ifadesi yazilacak

     */



}

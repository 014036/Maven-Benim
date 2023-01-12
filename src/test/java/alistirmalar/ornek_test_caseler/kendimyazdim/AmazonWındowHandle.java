    package alistirmalar.ornek_test_caseler.kendimyazdim;

    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.WindowType;
    import utilities.TestBase;

    public class AmazonWındowHandle extends TestBase{

    /*
    // 1- https://www.amazon.com sayfasına gidin
    // 2- nutella icin arama yapın
    // 3- yeni bir tab'da ilk urunun resmine tıklayınız
    // 4- yeni tab'da acilan urunun basligini yazdirin
    // 5- ilk sayfaya gecip url'i yazdırın
    */

    @Test
    public void amazon() {
    // 1- https://www.amazon.com sayfasına gidin
    driver.get("https://www.amazon.com");

    // 2- nutella icin arama yapın
    WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("nutella", Keys.ENTER);
    String windowHandle_1= driver.getWindowHandle();

    // 3- yeni bir tab'da ilk urunun resmine tıklayınız
    driver.switchTo().newWindow(WindowType.TAB);

    driver.get("https://www.amazon.com");
    waitFor(2);
    WebElement searchBox1= driver.findElement(By.id("twotabsearchtextbox"));
    searchBox1.sendKeys("nutella", Keys.ENTER);
    driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

    // 4- yeni tab'da acilan urunun basligini yazdirin
    String urunTitle= driver.findElement(By.xpath("//*[@id='productTitle']")).getText();
    System.out.println("urunTitle = " + urunTitle);

    // 5- ilk sayfaya gecip url'i yazdırın
    driver.switchTo().window(windowHandle_1);
    waitFor(2);
    String currentURL_Window1= driver.getCurrentUrl();
    System.out.println("currentURL_Window1 = " + currentURL_Window1);
    }
    }

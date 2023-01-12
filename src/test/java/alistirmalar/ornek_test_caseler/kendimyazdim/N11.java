    package alistirmalar.ornek_test_caseler.kendimyazdim;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import utilities.TestBase;

    import java.util.ArrayList;
    import java.util.List;

    public class N11 extends TestBase {

    /*
    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'oppo' yazıp aratın
    // ilk ürüne tıklayın
    // Basligin 'Oppo' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın
    */
    @Test
    public void test01(){

    // 'https://www.n11.com' adresine gidin
    driver.get("https://www.n11.com");
    // driver.findElement(By.tagName("//button[.()= 'Daha Sonra']")).click();
    String windowHandle_1= driver.getWindowHandle();

    // arama motoruna 'oppo' yazıp aratın
    WebElement searchBox= driver.findElement(By.id("searchData"));
    searchBox.sendKeys("oppo", Keys.ENTER);

    // ilk ürüne tıklayın
    WebElement ilkUrun= driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
    ilkUrun.click();
    waitFor(2);

    //ikinci sayfaya gecmek icin
    List<String>allWindowsHandles= new ArrayList<>(driver.getWindowHandles());
    System.out.println("allWindowsHandles = " + allWindowsHandles);
    driver.switchTo().window(allWindowsHandles.get(1));

    // Basligin 'Oppo' icerdigini test edin.
    String actualUrunTitle= driver.findElement(By.xpath("//h1[@class='proName']")).getText();
    String expectedUrunTitle= "Oppo";
    Assert.assertTrue(actualUrunTitle.contains(expectedUrunTitle));


    // ilk sayfaya donun ve Title'ını yazdırın
    driver.switchTo().window(windowHandle_1);
    String actualTitle= driver.getTitle();
    System.out.println("actualTitle = " + actualTitle);

    }
    }

    package alistirmalar.ornek_test_caseler.kendimyazdim;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.WindowType;
    import utilities.TestBase;

    import java.util.List;

    public class BestBuyWindowHandle extends TestBase {

    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim


    @Test
    public void test01(){
    // 1- https://www.amazon.com sayfasina gidelim
    driver.get("https://www.amazon.com");

    // 2- url'in 'amazon' icerdigini test edelim
    String actualCurrentURL_1= driver.getCurrentUrl();
    System.out.println("actualCurrentURL_1 = " + actualCurrentURL_1);
    String expectedCurrentURL= "amazon";
    Assert.assertTrue(actualCurrentURL_1.contains(expectedCurrentURL));
    String windowHandle_1= driver.getWindowHandle();

    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    driver.switchTo().newWindow(WindowType.WINDOW);
    driver.get("https://www.bestbuy.com ");

    // 4- title'in 'Best Buy' icerdigini test edelim
    String actualBestBuyTitle= driver.getTitle();
    String expectedestBuyTitle= "Best Buy";
    Assert.assertTrue(actualBestBuyTitle.contains(expectedestBuyTitle));
    String windowHandleBestBuy= driver.getWindowHandle();

    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    driver.switchTo().window(windowHandle_1);
    waitFor(2);
    WebElement searchBox1= driver.findElement(By.id("twotabsearchtextbox"));
    searchBox1.sendKeys("java", Keys.ENTER);

    // 6- arama sonuclarının 'Java' icerdigini test edelim
    String actualSearchResult= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
    String expectedSearchResult = "java";
    Assert.assertTrue(actualSearchResult.contains(expectedSearchResult));
    waitFor(2);

    // 7- ikinci sayfaya(bestbuy) donelim
    driver.switchTo().window(windowHandleBestBuy);
    waitFor(2);

    //tagname'i "button"olan webElementlerin sayisini bulup isimlerini yazdirin
    List<WebElement> allTag= driver.findElements(By.tagName("button"));
    System.out.println("allTag.size() = " + allTag.size());
    for (WebElement w: allTag){
    System.out.println("w.getText() = " + w.getText());
    }

    // 8- logonun gorundugunu test edelim
    WebElement bestBuyLogo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
    Assert.assertTrue(bestBuyLogo.isDisplayed());

    }
    }

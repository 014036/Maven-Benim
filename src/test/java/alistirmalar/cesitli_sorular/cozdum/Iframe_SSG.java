    package alistirmalar.cesitli_sorular.cozdum;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;

    public class Iframe_SSG extends TestBase {

    @Test
    public void iframeTest() {
    // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
    driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

    // Videoyu görecek kadar asagiya ininiz

    Actions actions= new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN).perform();


    // Videoyu izlemek icin Play tusuna basiniz
    WebElement iframe= driver.findElement(By.xpath("//iframe[1]"));
    driver.switchTo().frame(iframe);
    WebElement playButton= driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
    actions.click(playButton).perform();

    // videoyu durdurunuz
    waitFor(5);
    WebElement pauseButton=   driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
    pauseButton.click();

    // videoyu tam ekran yapınız
    WebElement tamEkran= driver.findElement(By.xpath("//button[@title='Tam ekran (f)']"));
    tamEkran.click();
    waitFor(3);

    // videoyu calıstırınız
    driver.findElement(By.xpath("//button[@title='Oynat (k)']")).click();
    waitFor(3);

    // videoyu kucultunuz
    WebElement tamEkrandanCik= driver.findElement(By.xpath("//button[@data-title-no-tooltip='Tam ekrandan çık']"));
    actions.click(tamEkrandanCik).perform();

    // videoyu durdurunuz
   pauseButton.click();

    // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazisi= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());

    // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        String  actualBaslikYazisi= driver.findElement(By.xpath("//h1")).getText();
        String expectedBaslikYazisi= "jQuery Flexy Plugin Demos";
        Assert.assertEquals(expectedBaslikYazisi,actualBaslikYazisi);
    }
    }

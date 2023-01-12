    package alistirmalar.slayt_sorulari.cozdum;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;


    public class Sayfa_122_KeyboardAction extends TestBase {

    /*
    1Bir Class olusturalim KeyboardActions2
    2https://html.com/tags/iframe/ sayfasina gidelim
    3- video’yu gorecek kadar asagi inin
    4 videoyu izlemek icin Play tusuna basin
    5 videoyu calistirdiginizi test edin
    */

    @Test
    public void keyboardActions2Test() {

    //2https://html.com/tags/iframe/ sayfasina gidelim
    driver.get("https://html.com/tags/iframe/");

    //3- video’yu gorecek kadar asagi inin
    Actions actions= new Actions(driver);
    WebElement video= driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
    actions.scrollToElement(video).perform();

    WebElement iframe1= driver.findElement(By.xpath("//div[@class='render']/iframe"));
    driver.switchTo().frame(iframe1);


    //4 videoyu izlemek icin Play tusuna basin
    WebElement playButton= driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
    playButton.click();
    waitFor(5);

    //5 videoyu calistirdiginizi test edin
        Assert.assertFalse(playButton.isDisplayed());

    }
    }

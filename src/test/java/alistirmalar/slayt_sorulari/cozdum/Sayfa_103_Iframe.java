    package alistirmalar.slayt_sorulari.cozdum;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import utilities.TestBase;


    public class Sayfa_103_Iframe extends TestBase {

    /*
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    ○Text Box’a “Merhaba Dunya!” yazin.
    ○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    dogrulayin ve konsolda yazdirin.
    */

    @Test
    public void iframeTest() {
    //● https://the-internet.herokuapp.com/iframe adresine gidin.
    driver.get("https://the-internet.herokuapp.com/iframe");

    //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    WebElement iframeContaining= driver.findElement(By.xpath("//h3"));
    Assert.assertTrue(iframeContaining.isDisplayed());
    System.out.println("iframeContaining.getText() = " + iframeContaining.getText());

    //○Text Box’a “Merhaba Dunya!” yazin.
    WebElement iframe1= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
    driver.switchTo().frame(iframe1);
    waitFor(1);
    WebElement textBox= driver.findElement(By.xpath("//body[@id='tinymce']"));
    textBox.clear();
    textBox.sendKeys("Merhaba Dunya");
    System.out.println("textBox.getText() = " + textBox.getText());

    //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
    waitFor(2);
    driver.switchTo().parentFrame();
    WebElement elementalSeleniumIsDisplayed= driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
    Assert.assertTrue(elementalSeleniumIsDisplayed.isDisplayed());
    System.out.println("elementalSeleniumIsDisplayed.getText() = " + elementalSeleniumIsDisplayed.getText());

    }
    }

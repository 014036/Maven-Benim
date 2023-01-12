package alistirmalar.letcode.work_space;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C14_Slider extends TestBase {
/*
    // 1-https://letcode.in/ adresine git
    // 2-Work-Space yazisina tikla
    //Slider yazisini gorunceye kadar sayfayi asagi kaydir
    //3- Click on the Slider button --Slider düğmesine tıklayın
    //4-Move the slider between 1 to 50--Kaydırıcıyı 1 ile 50 arasında hareket ettirin
    //5-Click on the get countries button --Ülkeleri al düğmesine tıklayın
    //6-Validate that countries are generated based on slider values --Ülkelerin kaydırıcı değerlerine göre oluşturulduğunu doğrulayın

*/

    @Test
    public void sliderTest() {
        // 1-https://letcode.in/ adresine git
        driver.get("https://letcode.in/");
        // 2-Work-Space yazisina tikla
        driver.findElement(By.id("testing")).click();

        //Slider yazisini gorunceye kadar sayfayi asagi kaydir
        WebElement sliderText= driver.findElement(By.xpath("//a[.='AUI - 5']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(sliderText).build().perform();

        //3- Click on the Slider button --Slider düğmesine tıklayın
        actions.click(sliderText).build().perform();

        //4-Move the slider between 1 to 50--Kaydırıcıyı 1 ile 50 arasında hareket ettirin
        WebElement sliderCubugu= driver.findElement(By.name("generate"));
        System.out.println("sliderCubugu.getLocation() = " + sliderCubugu.getLocation());
//        JavascriptExecutor j = (JavascriptExecutor) driver;
//        WebElement ads = driver.findElement(By.name("generate"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", ads);
//        ads.clear();
//        ads.sendKeys("15");

        actions.clickAndHold(sliderCubugu).moveByOffset( 180,270).build().perform();

        //5-Click on the get countries button --Ülkeleri al düğmesine tıklayın
        WebElement getCountriesButton= driver.findElement(By.xpath("//button[@class='button is-primary']"));
        String countries_1= driver. findElement(By.xpath("//div[@class='notification is-primary']")).getText();
        System.out.println("countries_1 = " + countries_1);
        //6-Validate that countries are generated based on slider values --Ülkelerin kaydırıcı değerlerine göre oluşturulduğunu doğrulayın

    }
}

package alistirmalar.cesitli_sorular.cozdum;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Slider extends TestBase {

    ///*
    //     -https://jqueryui.com/slider/#colorpicker adrese gidiniz

    //     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
    //     */


    @Test
    public void name() {
        //https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement iframe1= driver.findElement(By.xpath("//iframe[@src='/resources/demos/slider/colorpicker.html']"));
        driver.switchTo().frame(iframe1);

        WebElement sliderRed= driver.findElement(By.xpath("//div[@id='red']"));
        WebElement slidergreen= driver.findElement(By.xpath("//div[@id='green']"));
        WebElement sliderBlue= driver.findElement(By.xpath("//div[@id='blue']"));
        Actions actions =new Actions(driver);
        actions.dragAndDropBy(sliderRed, 140,125).dragAndDropBy(slidergreen,-140,0).dragAndDropBy(sliderBlue, -140,0).build().perform();
        waitFor(3);
        actions.dragAndDropBy(sliderRed, -140,125).dragAndDropBy(slidergreen,140,0).dragAndDropBy(sliderBlue, -140,0).build().perform();
        waitFor(3);
        actions.dragAndDropBy(sliderRed, -140,125).dragAndDropBy(slidergreen,-140,0).dragAndDropBy(sliderBlue, 140,0).build().perform();


        waitFor(5);

    }

}

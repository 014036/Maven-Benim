package alistirmalar.cesitli_sorular.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Dropdown_Action extends TestBase {


// Exercise 1...

    // https://www.amazon.com/ sayfasina gidin
    // sag ust bolumde bulunan dil menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change butonuna basiniz
    // DropDown'dan Visible Text kullanarak 'TRY - Turkish Lira' optionunu secin ve yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki tum optionlarin toplam sayısının 68'ye esit oldugunu test edin
    // Save Changes butonuna basınız
    // arama motoruna 'Kitap' yazip aratin
    // ilk cikan urunun parabiriminin 'TRY' oldugunu test edin


    @Test
    public void dropDown() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // sag ust bolumde bulunan dil menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions= new Actions(driver);
        WebElement languageMenu= driver.findElement(By.xpath("(//span[@class='nav-line-2'])[1]"));
        actions.moveToElement(languageMenu).perform();

        // Change butonuna basiniz
        driver.findElement(By.xpath("(//a[@class='icp-flyout-change'])[1]")).click();
waitFor(5);
        // DropDown'dan Visible Text kullanarak 'TRY - Turkish Lira' optionunu secin ve yazdırın
        WebElement country= driver.findElement(By.xpath("//select[@id='icp-currency-dropdown']"));
        Select countrySelect= new Select(country);
        countrySelect.selectByVisibleText("TRY - Turkish Lira");

        // Tüm option'ları yazdırın
       List<WebElement> allOptions= countrySelect.getOptions();
      allOptions.forEach(t-> System.out.println(t.getText()));

        // dropdown'daki tum optionlarin toplam sayısının 68'ye esit oldugunu test edin
        int actualAllOptionsSayi= allOptions.size();
        System.out.println("allOptionsSayi = " + actualAllOptionsSayi);
        int expectedAllOptionsSayi=68;
        Assert.assertEquals(expectedAllOptionsSayi, actualAllOptionsSayi);

        // Save Changes butonuna basınız
        driver.findElement(By.id("icp-save-button")).click();
        waitFor(5);

        // arama motoruna 'Kitap' yazip aratin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Kitap", Keys.ENTER);

        // ilk cikan urunun parabiriminin 'TRY' oldugunu test edin
        String actualParaBirimi = driver.findElement(By.xpath("(//span[.='TRY'])[1]")).getText();
        String expectedParaBirimi= "TRY";
        Assert.assertEquals(expectedParaBirimi, actualParaBirimi);
    }
}

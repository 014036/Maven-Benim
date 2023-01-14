package alistirmalar.cesitli_sorular;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;



public class AmazonDropDown extends TestBase {
    @Test
    public void name() {

        //● https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");

        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin

        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
Select select= new Select(ddm);
int sayi= select.getOptions().size();
        System.out.println("sayi = " + sayi);


    }


}

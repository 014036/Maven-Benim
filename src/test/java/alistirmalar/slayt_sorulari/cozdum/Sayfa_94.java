package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Sayfa_94 extends TestBase {

    /*
    1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */

    @Test
    public void test01() {

        //    1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        //sayfa direkt gecise izin vermedigi icin back yapacagiz
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        //once online Banking sayfasina gidecegiz
        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click(); //Pay Bills sayfasina gider


        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropdown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Eurozone (euro)");

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("400");


        //10. “US Dollars” in secilmedigini test edin
        WebElement usDolarSciliMi = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDolarSciliMi.isSelected());

        //11. “Selected currency” butonunu secin
        WebElement selectedCurrency = driver.findElement(By.id("pc_inDollars_false"));

        selectedCurrency.click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        //purchase butonuna basmak icin
        driver.findElement(By.id("purchase_cash")).click();


        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String successfullyPurchased= driver.findElement(By.id("alert_content")).getText();
        String expectedSuccessfully= "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(expectedSuccessfully, successfullyPurchased);

    }
}

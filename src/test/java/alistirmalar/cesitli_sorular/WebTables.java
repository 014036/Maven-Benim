package alistirmalar.cesitli_sorular;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class WebTables extends TestBase {


    @Test
    public void name() {

        //    https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        String allTables= driver.findElement(By.id("table1")).getText();

    }
}

package alistirmalar.cesitli_sorular;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class BankOfAmerikaWebTable extends TestBase {


    @Test
    public void test(){


        driver.get("https://www.bankofamerica.com/");
        rowColumnDataPrint("1", "2", "3");
//Are Not a Condition to Any Banking Service or Activity
    }


    public void rowColumnDataPrint(String tableNumber, String rowNumber, String columnNumber){
        String rowData=    driver.findElement(By.xpath("//table["+tableNumber+"]//tr["+rowNumber+"]//td["+columnNumber+"]")).getText();
        System.out.println("rowData = " + rowData);
    }
}

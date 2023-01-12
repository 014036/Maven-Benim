package alistirmalar.ornek_test_caseler.kendimyazdim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_AddDeleteButton extends TestBase {
    /*
    1- https://testcenter.techproeducation.com/index.php adresine git
    2- Add/Remove Elements yazan yere tikla
    3- 100 defa Add Element butonuna bas
    4-  100 defa Add Element butonuna basildigini dogrula
     */

    @Test
    public void test01() {
     //https://testcenter.techproeducation.com/index.php
     driver.get("https://testcenter.techproeducation.com/index.php");

     // 2- Add/Remove Elements yazan yere tikla
        driver.findElement(By.xpath("//a[@href='index.php?page=add-remove-elements']")).click();

    //    3- 100 defa Add Element butonuna bas
        WebElement addButton= driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i=1; i<101; i++){
            addButton.click();
        }
    //    4-  100 defa Add Element butonuna basildigini dogrula
        List<WebElement>addDeleteButtonAccount= driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println("addDeleteButtonAccount.size() = " + addDeleteButtonAccount.size());
        int expectedSayi=100;
        Assert.assertTrue(addDeleteButtonAccount.size()==expectedSayi);
    }
}

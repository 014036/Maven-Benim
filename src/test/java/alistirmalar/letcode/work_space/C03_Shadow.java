package alistirmalar.letcode.work_space;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C03_Shadow extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        driver.get("https://letcode.in/shadow");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String str = "return document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')";
        WebElement fname = (WebElement) ((JavascriptExecutor) driver).executeScript(str);
        fname.sendKeys("erkam");
//
        ((JavascriptExecutor) driver).executeScript("document.querySelector('my-web-component').myRoot.querySelector('#lname').value = 'erkam'");
//
//    /*
/*
1-https://books-pwakit.appspot.com/ adresine gidin.
2-"BOOKS" başlığının görünür olduğunu doğrulayın
3-Arama çubuğunda "Selenium" u aratın.
4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
*/
// */
//
 }


}


















package alistirmalar.letcode.work_space;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class C01_Input extends TestBase {
    @Test
    public void input() {
        driver.get("https://letcode.in/edit");
        driver.findElement(By.id("fullName")).sendKeys("admin");
        driver.findElement(By.id("join")).sendKeys("absdc",Keys.TAB);
       String label2= driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']")).getText();
        System.out.println("label2 = " + label2);
         String name= driver.findElement(By.id("getMe")).getAttribute("value");
        System.out.println("name = " + name);
        driver.findElement(By.id("clearMe")).clear();
       WebElement gizli= driver.findElement(By.id("noEdit"));
        Assert.assertTrue(!gizli.isEnabled());
        String readonly= driver.findElement(By.id("dontwrite")).getAttribute("readonly");
        System.out.println("readonly = " + readonly);

    }
}

package alistirmalar.letcode.work_space;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;


public class C02utton extends TestBase {
    @Test
    public void input() {
        driver.get("https://letcode.in/buttons");
        //Goto Home and come back here using driver command
          driver.findElement(By.id("home")).click();
          driver.navigate().back();
        //Get the X & Y co-ordinates
        WebElement coordinates = driver.findElement(By.id("position"));
        Point point = coordinates.getLocation();
        int x = point.x;
        int y = point.y;
        System.out.println("x==> " + x + " y==> " + y);

        //Find the color of the button
        WebElement buttonColor = driver.findElement(By.id("color"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("color = " + color);

        //Find the height & width of the button
        Rectangle rectangle = driver.findElement(By.id("property")).getRect();
        System.out.println("rectangle.getHeight() = " + rectangle.getHeight());
        System.out.println("rectangle.getWidth() = " + rectangle.getWidth());
        System.out.println("rectangle.getPoint() = " + rectangle.getPoint());
        // //VEYA
//        Dimension dimension= rectangle.getDimension();
//       int height=dimension.getHeight();
//       int with=dimension.getWidth();
//        System.out.println("height==> "+height+" with==> "+with);

        //Confirm button is disabled
        WebElement confirmButton = driver.findElement(By.xpath("//button[@title='Disabled button']"));
        Assert.assertTrue(!confirmButton.isEnabled());

        //Click and Hold Button
        driver.findElement(By.xpath("//h2[text()='Button Hold!']"));


    }
}

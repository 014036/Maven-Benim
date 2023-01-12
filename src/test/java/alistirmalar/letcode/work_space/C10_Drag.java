    package alistirmalar.letcode.work_space;

    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;
;

    public class C10_Drag extends TestBase {

    /*
    // 1-https://letcode.in/ adresine git
    // 2-Work-Space yazisina tikla
    //3- Click on the Drag button --Drag düğmesine tıklayın
    //4- Uzerinde "I can only be dragged within the dotted container" yazan kutuyu saydaya 3 farkli yere tasiyin
    */

    @Test
    public void dragTest01() {
    //1 https://letcode.in/ adresine git
    driver.get("https://letcode.in/");

    // 2-Work-Space yazisina tikla
    driver.findElement(By.id("testing")).click();

    //3- Click on the Drag button --Drag düğmesine tıklayın
    driver.findElement(By.xpath("//a[@href='/draggable']")).click();

    //4- Uzerinde "I can only be dragged within the dotted container" yazan kutuyu saydaya 3 farkli yere tasiyin

    Actions actions =new Actions(driver);
    WebElement source= driver.findElement(By.id("sample-box"));
    WebElement target= driver.findElement(By.xpath("//div[@class='example-boundary']"));

    actions.clickAndHold(source).moveByOffset( 198, 198).release().build().perform();
    waitFor(3);

    actions.dragAndDropBy(source, -2, 191).release().build().perform();

    waitFor(3);
//
    actions.clickAndHold(source).moveByOffset( 198, -2).release(target).build().perform();

    }


    }

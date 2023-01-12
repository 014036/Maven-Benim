    package alistirmalar.slayt_sorulari.cozdum;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;

    public class Sayfa_115_ActionsDrog extends TestBase {

    /*
    1 https://demoqa.com/droppable adresine gidelim
    2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    */

    @Test
    public void dropAndDrag() {
    //    1 https://demoqa.com/droppable adresine gidelim
    driver.get("https://demoqa.com/droppable");

    Actions actions = new Actions(driver);

    //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    WebElement sourceDragMe= driver.findElement(By.id("draggable"));
    WebElement targetDragHere= driver.findElement(By.id("droppable"));
    actions.dragAndDrop(sourceDragMe, targetDragHere).perform();

    //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    String text=  driver.findElement(By.xpath("//p[.='Dropped!']")).getText();
    Assert.assertEquals("Dropped!", text);
    }
    }

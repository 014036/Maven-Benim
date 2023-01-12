    package alistirmalar.letcode.work_space;

    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;


    public class C11_Drop extends TestBase {

    /*
    // 1-https://letcode.in/ adresine git
    // 2-Work-Space yazisina tikla
    //3- Click on the Drop button --Drop düğmesine tıklayın
    //  4- "Drag me to my target" yazan kutuyu "drop Here" yazan yere tasiyiniz


    */


    @Test
    public void dropTest01() {
    //1 https://letcode.in/ adresine git
    driver.get("https://letcode.in/");


    // 2-Work-Space yazisina tikla
    driver.findElement(By.id("testing")).click();
    //3- Click on the Drop button --Drop düğmesine tıklayın
    driver.findElement(By.xpath("//a[@href='/dropable']")).click();
    waitFor(2);

    Actions actions = new Actions(driver);
    waitFor(5);
    //  4- "Drag me to my target" yazan kutuyu "drop Here" yazan yere tasiyiniz

    WebElement source= driver.findElement(By.id("draggable"));

    WebElement target= driver.findElement(By.id("droppable"));
    WebElement target2= driver.findElement(By.xpath("//div/p[.='Drop here']"));

    waitFor(3);
    actions.dragAndDrop(source, target).build().perform();


    }


    }

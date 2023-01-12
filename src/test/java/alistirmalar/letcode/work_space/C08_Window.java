    package alistirmalar.letcode.work_space;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.junit.Before;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import utilities.TestBase;


    import java.time.Duration;

    public class C08_Window extends TestBase {
    /*
    // https://letcode.in/ adresine git
    //Work-Space yazisina tikla
    //Click on the home button --Ana sayfa düğmesine tıklayın
    //Goto the newly opened tab --Yeni açılan sekmeye git
    //Print the title of the page --Sayfanın başlığını yazdır
    //Close the parent window --Ebeveyn penceresini kapat
    //Close the child window --Alt pencereyi kapat
    //Click on the Muiltiple windows button --Birden çok pencere düğmesine tıklayın
    //Print all the window title --Tüm pencere başlığını yazdır
    //Close all the windows  --tüm pencereleri kapat

    */


    @Test
    public void window() {
    //1 https://letcode.in/ adresine git
    driver.get("https://letcode.in/");

    // 2-Work-Space yazisina tikla
    driver.findElement(By.id("testing")).click();

    //3-Acilan pencereden   Windows'a tikla
    driver.findElement(By.xpath("//a[@href='/windows']")).click();
    String handleWindow_1 = driver.getWindowHandle();

    // 4-Click on the home button --Ana sayfa düğmesine tıklayın
    driver.findElement(By.id("home")).click();


    // 5-Goto the newly opened tab --Yeni açılan sekmeye git
    switchToWindow(2);
    waitFor(3);

    // 6-Print the title of the page --Sayfanın başlığını yazdır
    String actualTitleWindow_2 = driver.getTitle();
    System.out.println("actualTitleWindow_2 = " + actualTitleWindow_2);

    // 7-Close the parent window --Ebeveyn penceresini kapat
        switchToWindow(1);
        waitFor(3);
       driver.close();

    // 8-Close the child window --Alt pencereyi kapat
 //   driver.close();
        switchToWindow(1);
    //Click on the Muiltiple windows button --Birden çok pencere düğmesine tıklayın
    driver.findElement(By.id("multi")).click();
    driver.findElement(By.id("multi")).click();
    waitFor(3);

    //Print all the window title --Tüm pencere başlığını yazdır
    switchToWindow(1);
    String actualTitleWindow1 = driver.getTitle();
    System.out.println("actualTitleWindow1 = " + actualTitleWindow1);

    waitFor(3);
    switchToWindow(2);
    String actualTitleWindow2 = driver.getTitle();
    System.out.println("actualTitleWindow2 = " + actualTitleWindow2);
    waitFor(3);

    switchToWindow(3);
    String actualTitleWindow3 = driver.getTitle();
    System.out.println("actualTitleWindow3 = " + actualTitleWindow3);


    //Close all the windows  --tüm pencereleri kapat
    driver.quit();

    }

    }

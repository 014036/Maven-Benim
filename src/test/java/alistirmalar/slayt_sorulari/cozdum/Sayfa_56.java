package alistirmalar.slayt_sorulari.cozdum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Sayfa_56 {


    public static void main(String[] args) {

     /*
        SAYFA 56
        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
2- Add Element butonuna basin
3 Delete butonu’nun gorunur oldugunu test edin
4 Delete tusuna basin
5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");

//        2- Add Element butonuna basin

        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();

//        3 Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteKutusuGorunuyorMu= driver.findElement(By.xpath("//*[@onclick='deleteElement()']"));
        if (deleteKutusuGorunuyorMu.isDisplayed()){
            System.out.println("delete Kutus uGorunuyorMu Testi PASSED");
        }else  System.out.println("delete Kutus uGorunuyorMu Testi FAILED");

//        4 Delete tusuna basin
        driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();

//        5 “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoteYazisiGorunuyorMu1 = driver.findElement(By.xpath("//h3"));

        if (addRemoteYazisiGorunuyorMu1.isDisplayed()){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //veya
       WebElement addRemoteYazisiGorunuyorMu2 = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoteYazisiGorunuyorMu2.isDisplayed()){
            System.out.println("addRemoteYazisiGorunuyorMu2 Testi PASSED");
        }else System.out.println("addRemoteYazisiGorunuyorMu2 Testi FAILED");

        //sayfayi kapatin
        driver.close();




    }
}

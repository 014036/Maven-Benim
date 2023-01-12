package alistirmalar.letcode.work_space;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;


import java.util.List;

public class C04_Select extends TestBase {

// https://letcode.in/ adresine git
//Work-Space yazisina tikla
//Acilan pencereden select e tikla
//Tum secenekleri yazdirin
//Select the apple using visible text ile sec
//Select your super hero's coklu secim yap
//Tum secenekleri yazdirin
//super hero'e ta sectiginiz secenekleri geri alin
//Select the last programming language and print all the options --tum secenekleri yazdirin
//Select India using value & print the selected value basliginda getFirstSelectedOption() yapin
//Tum secenekleri yazdirin


    @Test
    public void select() throws InterruptedException {
    // https://letcode.in/ adresine git
        driver.get("https://letcode.in/");

    //Work-Space yazisina tikla
        driver.findElement(By.id("testing")).click();

    //Acilan pencereden select e tikla
        driver.findElement(By.xpath("//a[@href='/dropdowns']")).click();


    //Select the apple using visible text ile sec
        WebElement kutu1= driver.findElement(By.id("fruits"));
        Select fruits= new Select(kutu1);
        fruits.selectByVisibleText("Orange");
        boolean isMu1= fruits.isMultiple();
        System.out.println("isMu1 = " + isMu1);
        List<WebElement> allfruits= fruits.getOptions();
        allfruits.forEach(t-> System.out.println(t.getText()));
        System.out.println("******************");

    //Select your super hero's coklu secim yap
        WebElement heros= driver.findElement(By.id("superheros"));
        Select superHeros= new Select(heros);
        boolean isMu= superHeros.isMultiple();
        System.out.println("isMu = " + isMu);
        List<WebElement>allHeros= superHeros.getOptions();
        allHeros.forEach(t-> System.out.println(t.getText()));

        superHeros.selectByIndex(2);
        superHeros.deselectByIndex(2);//sectigimiz secenegi geri almak icin******************
       superHeros.selectByValue("th");
       superHeros.selectByVisibleText("Wonder Woman");


       //SECTIGIMIZ SECENEKLERI GERI ALMAK ICIN
        superHeros.deselectByIndex(2);//sectigimiz secenegi geri almak icin******************
        superHeros.deselectByValue("th");
        superHeros.deselectByVisibleText("Wonder Woman");
       Thread.sleep(5000);

    //Select the last programming language and print all the options --tum secenekleri yazdirin
        WebElement lang= driver.findElement(By.id("lang"));
        Select language= new Select(lang);
        List<WebElement> allOptions= language.getOptions();
        allOptions.forEach(t-> System.out.println(t.getText()));
        System.out.println("************************");

    //Select India using value & print the selected value basliginda value ile "India" secip getFirstSelectedOption() yapin
        WebElement country= driver.findElement(By.id("country"));
        Select selectCountry= new Select(country);
        selectCountry.selectByValue("India");
        String getFirst1=selectCountry.getFirstSelectedOption().getText();
        System.out.println("getFirst1 = " + getFirst1);
        List<WebElement> allCountry= selectCountry.getOptions();
        allCountry.forEach(t-> System.out.println(t.getText()));
    }
}

package alistirmalar.cesitli_sorular.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import java.nio.file.Files;
import java.nio.file.Paths;
public class C02_FilesDownload extends TestBase {
    // Exercise 2...
    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. LambdaTest.txt dosyasini indirelim
    //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz
    @Test
    public void test01() throws InterruptedException {
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        //2. LambdaTest.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[@href='download/LambdaTest.txt']")).click();
        Thread.sleep(2000);
        //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz
        //   "C:\Users\BURAK\Downloads\myfile.txt"
        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Downloads\\myfile.txt")));  Bu işlemi daha dinamik hale getirelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\LambdaTest.txt";
        String dosyaYolu=farkliKisim + ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
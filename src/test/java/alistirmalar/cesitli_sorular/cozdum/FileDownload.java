package alistirmalar.cesitli_sorular.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {

    /*

     //1. 'https://the-internet.herokuapp.com/' adresine gidiniz
     //2File download linkine tiklayin
    //2. some-file.txt dosyasini indirelim
    //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)

     */

    @Test
    public void fileDownloadTest(){

        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/");
        //2. File download linkine tiklayin
        driver.findElement(By.xpath("//a[@href='/download']")).click();

        //3. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[@href='download/some-file.txt']")).click();

        //4. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
        String filePath= "C:\\Users\\hp\\Downloads\\some-file.txt";
        boolean isExist= Files.exists(Paths.get(filePath));

        Assert.assertTrue(isExist);

    }
}

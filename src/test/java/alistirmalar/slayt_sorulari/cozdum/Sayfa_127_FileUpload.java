package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class Sayfa_127_FileUpload extends TestBase {

    /*

2. https://the-internet.herokuapp.com/upload adresine gidelim
3. chooseFile butonuna basalim
4. Yuklemek istediginiz dosyayi secelim.
5. Upload butonuna basalim.
6. “File Uploaded!” textinin goruntulendigini test edelim
     */



    @Test
    public void uploadFileTest(){

//2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

//3. chooseFile butonuna basalim
   WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

//4. Yuklemek istediginiz dosyayi secelim.
        String dosyaPath= System.getProperty("user.home")+"\\Documents\\ing klavye.docx";
        chooseFileButton.sendKeys(dosyaPath);

//5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

//6. “File Uploaded!” textinin goruntulendigini test edelim
        String actualResultText= driver.findElement(By.xpath("//h3")).getText();
        String expectedResulText= "File Uploaded!";
        Assert.assertEquals(expectedResulText, actualResultText);


    }
}

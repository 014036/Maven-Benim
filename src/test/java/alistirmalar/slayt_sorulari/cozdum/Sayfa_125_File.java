    package alistirmalar.slayt_sorulari.cozdum;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import utilities.TestBase;


    import java.nio.file.Files;
    import java.nio.file.Paths;

    public class Sayfa_125_File extends TestBase {
    /*
    1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    2. https://the-internet.herokuapp.com/download adresine gidelim.
    3. text.txt dosyasını indirelim
    4. Dosyanın başarıyla indirilip indirilmediğini test edelim
    */

    @Test
    public void fileDownloadTest() {

    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    driver.get("https://the-internet.herokuapp.com/download");

    //3. text.txt dosyasını indirelim
    driver.findElement(By.xpath("//*[@href='download/screenshot.png']")).click();
    waitFor(5);

    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
    String filePath= System.getProperty("user.home")+"\\Downloads\\screenshot.png";
    boolean fileIsExist= Files.exists(Paths.get(filePath));
    Assert.assertTrue(fileIsExist);
    }
    }

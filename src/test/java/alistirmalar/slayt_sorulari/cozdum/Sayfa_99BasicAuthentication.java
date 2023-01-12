    package alistirmalar.slayt_sorulari.cozdum;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import utilities.TestBase;


    public class Sayfa_99BasicAuthentication extends TestBase {

    /*
    Bir class olusturun : BasicAuthentication
    2 https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3 asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu : https://username:password@URL
    Username : admin
    password : admin
    4 Basarili sekilde sayfaya girildigini dogrulayin
    */

    @Test
    public void basicAuthenticationTest(){
    //2 https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    driver.get("https://the-internet.herokuapp.com/basic_auth");

    //3 asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //Html komutu : https://username:password@URL
    //Username : admin
    //password : admin
    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    //4 Basarili sekilde sayfaya girildigini dogrulayin
    WebElement girisBasariliMi= driver.findElement(By.xpath("//h3"));
    Assert.assertTrue(girisBasariliMi.isDisplayed());
    }
    }

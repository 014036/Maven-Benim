package alistirmalar.cesitli_sorular.cozdum;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class FaceBookKayit extends TestBase {
    /*

    // 'https://www.facebook.com' sayfasina gidiniz
    // yeni hesap olustur butonuna basin
    // isim kutusunu locate ediniz
    // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
     */

    @Test
    public void createLoginTest(){
        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");

        // yeni hesap olustur butonuna basin
        //WebElement yeniHesapOlusturButton=
                driver.findElement(By.xpath("//a[.='Yeni Hesap Oluştur']")).click();

        // isim kutusunu locate ediniz
        WebElement nameBox= driver.findElement(By.name("firstname"));


        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker= new Faker();
       String firstName= faker.name().firstName();
        String lasstName= faker.name().lastName();
        String emailAdress= faker.internet().emailAddress();
        String password = faker.internet().password();
        nameBox.sendKeys(firstName, Keys.TAB, lasstName, Keys.TAB, emailAdress, Keys.TAB, emailAdress, Keys.TAB, password );

        WebElement day= driver.findElement(By.id("day"));
        dropDown(day,"23");
        WebElement month= driver.findElement(By.id("month"));
        dropDown(month, "Eyl");
        WebElement year= driver.findElement(By.id("year"));
        dropDown(year, "2015");
        driver.findElement(By.xpath("(//*[@name='sex'])[1]")).click();
        waitFor(10);
    }




    public  void dropDown(WebElement ddm, String secenek){
        Select select =new Select(ddm);
        select.selectByVisibleText(secenek);
    }
}

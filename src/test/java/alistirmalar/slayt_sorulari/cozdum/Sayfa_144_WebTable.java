package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Sayfa_144_WebTable extends TestBase {

    /*

1- https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin

 2- Ana Sayfadaki login butonuna tiklayin
 3-Log in butonuna basiniz
 4-acilan ekrana asagidaki bilgileri giriniz
Username : manager
 Password : Manager1!
2- table( ) metodu oluşturun
3-Tüm table body’sinin boyutunu(sutun sayisi) bulun.
4-Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
5-printRows( ) metodu oluşturun
6-//tr table body’sinde bulunan toplam satir(row) sayısını bulun.
7-Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
8- 4.satirdaki(row) elementleri konsolda yazdırın.
     */

    @Test
    public void login() {
//1- https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");

 //2- Ana Sayfadaki login butonuna tiklayin
        driver.findElement(By.xpath("//a[@href='/Account/Logon']")).click();
        //acilan ekrana asagidaki bilgileri giriniz
        driver.findElement(By.id("UserName")).sendKeys("manager", Keys.TAB,"Manager1!");
//Username : manager
// Password : Manager1!
   //Log in butonuna basiniz
   driver.findElement(By.id("btnSubmit")).click();

//2- table( ) metodu oluşturun
        table();
//3-Tüm table body’sinin boyutunu(sutun sayisi) bulun.
//4-Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
//5-printRows( ) metodu oluşturun
//6-//tr table body’sinde bulunan toplam satir(row) sayısını bulun.
//7-Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
//8- 4.satirdaki(row) elementleri konsolda yazdırın.

    }

    public void table(){
  WebElement bodySize=      driver.findElement(By.xpath("//div[@class='portlet-body']"));
        System.out.println("bodySize.getSize() = " + bodySize.getSize());
    }
}

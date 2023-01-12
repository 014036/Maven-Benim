package alistirmalar.automationtesting.anasayfa.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase13 extends TestBase {

    /*

TEST CASE 13
 13. Home-Arrivals-Add to Basket-Items-Check-out-Book Final price
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
10) Click on the Add To Basket button which adds that book to your basket
11) User can view that Book in the Menu item with price.

13) Now User can find the Total price of the book in the Check out grid.
14) User has the feasibility to find the total price of the books at to find the total price of the books at the time of check out

TEST VAKA 13
  13. Ana Sayfa-Gelenler-Sepete Ekle-Ürünler-Çıkış-Kitabı Son fiyat
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Şimdi Ana menü düğmesine tıklayın
5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
6) Ana sayfa yalnızca üç Varış içermelidir
7) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
8) Şimdi Gelenler bölümündeki resme tıklayın
9) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın
11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.

13) Artık Kullanıcı, Kitabın Toplam fiyatını Ödeme tablosunda bulabilir.
14) Kullanıcı, ödeme anında kitapların toplam fiyatını bulmak için kitapların toplam fiyatını bulma fizibilitesine sahiptir.

     */

    @Test
    public void test01() throws InterruptedException {

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //  3) Click on Shop Menu
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in/shop/'])[1]")).click();


        //4) Now click on Home menu button
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in'])[2]")).click();


        //5) Test whether the Home page has Three Arrivals only
        int arrivals = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
        System.out.println("arrivals = " + arrivals);

        //6) The Home page must contains only three Arrivals
        Assert.assertTrue(arrivals == 3);
//7) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
        WebElement resimUlasilabilirMi= driver.findElement(By.xpath("//*[@alt='Mastering JavaScript']"));
        Assert.assertTrue(resimUlasilabilirMi.isEnabled());

//8) Şimdi Gelenler bölümündeki resme tıklayın
        driver.findElement(By.xpath("//*[@alt='Mastering JavaScript']")).click();

//9) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
        WebElement urunEkleMeSayfasiGorunurMu = driver.findElement(By.xpath("//*[@id='content']"));
        Assert.assertTrue(urunEkleMeSayfasiGorunurMu.isDisplayed());

//10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()='Add to basket']")).click();
        driver.findElement(By.xpath("//a[@class='button wc-forward']")).click(); //sepete gitmek icin


//11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
        WebElement fiyatGorunurMu = driver.findElement(By.xpath("//span[@class='woocommerce-Price-amount amount']"));//sepete ekleme butonunun oldugu yerdeki fiyat
        Assert.assertTrue(fiyatGorunurMu.isDisplayed());

//13) Artık Kullanıcı, Kitabın Toplam fiyatını Ödeme tablosunda bulabilir.
        String subTotal= driver.findElement(By.xpath("//td[@data-title='Subtotal']")).getText();
        System.out.println("subTotal = " + subTotal);

        String totalPrice= driver.findElement(By.xpath("//strong//span[@class='woocommerce-Price-amount amount']")).getText().replace("₹","");
        System.out.println("totalPrice = " + totalPrice);
//14) Kullanıcı, ödeme anında kitapların toplam fiyatını bulmak için kitapların toplam fiyatını bulma fizibilitesine sahiptir.
//**************ANLAMADIM



    }




}

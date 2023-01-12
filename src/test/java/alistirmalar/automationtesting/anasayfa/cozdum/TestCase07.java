package alistirmalar.automationtesting.anasayfa.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase07 extends TestBase {

    /*

TEST CASE 7
7. Home page - Arrivals-Add to Basket with more books
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
12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
14) Click the add to basket button
15) Now it throws an error prompt like you must enter a value between 1 and 20


TEST DURUMU 7
7. Ana sayfa - Gelenler-Daha fazla kitapla Sepete Ekle
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Şimdi Ana menü düğmesine tıklayın
5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
6) Ana sayfa yalnızca üç Varış içermelidir
7) Şimdi Gelenler bölümündeki resme tıklayın
8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın
11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
12) Kullanıcı, o kitabı Sepetine ekleyen Sepete Ekle düğmesine tıklayarak bir kitap ekleyebilir.
13) Stoktaki kitaplardan daha fazla kitap seçin. Örneğin, stokta 20 kitap varsa, 21 eklemeye çalışın.
14) Sepete ekle butonuna tıklayın
15) Şimdi 1 ile 20 arasında bir değer girmeniz gerekiyormuş gibi bir hata mesajı veriyor.

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
        stokDurumuUygunsaKitapEkle();
//        //7)Image should be clickable and shoul navigate to next page where user can add that book to his basket
//        //Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
//        WebElement urunUlasilabilirMi = driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']"));
//        Assert.assertTrue(urunUlasilabilirMi.isEnabled());


        //12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
        //12) Kullanıcı, o kitabı Sepetine ekleyen Sepete Ekle düğmesine tıklayarak bir kitap ekleyebilir.
//        WebElement sepeteEkleDugmesiUlasilabilirMi=driver.findElement(By.xpath("(//*[@type='submit'])[1]"));
//        Assert.assertTrue(sepeteEkleDugmesiUlasilabilirMi.isEnabled());


        String stokDurumu = driver.findElement(By.xpath("//p[@class='stock in-stock']")).getText();
        int stokSayisi = Integer.parseInt(stokDurumu.split(" ")[0]);
        String gonderilecekDeger= String.valueOf(stokSayisi+1);
        System.out.println("stokDurumu = " + stokSayisi);



        //13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
        //13) Stoktaki kitaplardan daha fazla kitap seçin. Örneğin, stokta 20 kitap varsa, 21 eklemeye çalışın.
//13) Stoktaki kitaplardan daha fazla kitap seçin. Örneğin, stokta 20 kitap varsa, 21 eklemeye çalışın.
        WebElement stokSayi = driver.findElement(By.xpath("//*[@type=\"number\"]"));
        stokSayi.clear();
        stokSayi.sendKeys(gonderilecekDeger);

        //14) Sepete ekle butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Add to basket']")).click();

//15) Şimdi 1 ile 20 arasında bir değer girmeniz gerekiyormuş gibi bir hata mesajı veriyor.
        String message = driver.findElement(By.xpath("//*[@type=\"number\"]")).getAttribute("validationMessage");
        System.out.println(message);

    }

    static int i = 1;

    private static void stokDurumuUygunsaKitapEkle() {
        driver.findElement(By.xpath("(//*[@class='products'])[" + i + "]")).click();

        WebElement urunEkleMeSayfasiGorunurMu = driver.findElement(By.xpath("//*[@id='content']"));
        Assert.assertTrue(urunEkleMeSayfasiGorunurMu.isDisplayed());

        WebElement fiyatGorunurMu = driver.findElement(By.xpath("//span[@class='woocommerce-Price-amount amount']"));//sepete ekleme butonunun oldugu yerdeki fiyat
        Assert.assertTrue(fiyatGorunurMu.isDisplayed());

        String stokDurumu = driver.findElement(By.xpath("//div[@class='summary entry-summary']/p")).getText();
        System.out.println("stokDurumu = " + stokDurumu);

        if (stokDurumu.equals("Out of stock")) {
            driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in'])[2]")).click();
        } else {
            driver.findElement(By.xpath("//*[text()='Add to basket']")).click();
            return;
        }
        i++;
        stokDurumuUygunsaKitapEkle();
    }


}

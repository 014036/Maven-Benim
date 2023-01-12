package alistirmalar.automationtesting.anasayfa.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase12 extends TestBase {

    /*


TEST CASE 12
 12. Home-Arrivals-Add to Basket-Items-Add book
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

13) Click on textbox value under quantity in Check out page to add or subtract books.
14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
15) Now click on Update Basket to reflect those changes
16) User has the feasibility to Update Basket at the time of check out.


TEST VAKA 12
  12. Ana Sayfa-Gelenler-Sepete Ekle-Ürünler-Kitap Ekle
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

13) Kitap eklemek veya çıkarmak için Çıkış sayfasında miktar altındaki metin kutusu değerine tıklayın.
14) Şimdi yukarıdaki değişiklikten sonra 'Sepeti Güncelle' düğmesi Tıklanabilir moda dönüşecektir.
15) Şimdi bu değişiklikleri yansıtmak için Sepeti Güncelle'ye tıklayın
16) Kullanıcı, ödeme anında Sepeti Güncelleme olanağına sahiptir.

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
        //6-12. arasi sorulari bu methid icinde yaoiyoruz
        Assert.assertTrue(arrivals == 3);
        stokDurumuUygunsaKitapEkle();

        //12) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
        // 12 Kullanıcı, kitabı sepete ekledikten sonra, ödeme sayfasına yönlendiren menü öğesindeki Öğe bağlantısına tıklayabilir.
        driver.findElement(By.xpath("//a[@class='button wc-forward']")).click();


        // 13) Click on textbox value under quantity in Check out page to add or subtract books.
        //13) Kitap eklemek veya çıkarmak için Çıkış sayfasında miktar altındaki metin kutusu değerine tıklayın.
        WebElement quantity = driver.findElement(By.xpath("//input[@type='number']"));//kitap sayisini guncelleme kutusu
        quantity.clear(); //once var olan degeri siliyoruz
        driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("4");//miktar kutusuna yeni deger gonderiyoruz


        //14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
        //14) Şimdi yukarıdaki değişiklikten sonra 'Sepeti Güncelle' düğmesi Tıklanabilir moda dönüşecektir.
        WebElement updateBasketButonuAktifMi= driver.findElement(By.xpath("//input[@name='update_cart']"));
        Assert.assertTrue(updateBasketButonuAktifMi.isEnabled());


        //15) Now click on Update Basket to reflect those changes
        //15) Şimdi bu değişiklikleri yansıtmak için Sepeti Güncelle'ye tıklayin
        driver.findElement(By.xpath("//input[@name='update_cart']")).click();

        //16) User has the feasibility to Update Basket at the time of check out.
        //16) Kullanıcı, ödeme anında Sepeti Güncelleme olanağına sahiptir.
        //NOT: BEN BU SORUYU GUNCELLEMEK ISTEDIGI MIKTAR ILE GUNCELLENEN MIKTAR ESIT MI DIYE ANLADIM
       String miktarKontrolu= driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
        System.out.println("miktarKontrolu = " + miktarKontrolu);
        String expectedQuantity="4";
        Assert.assertEquals(expectedQuantity,miktarKontrolu);


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
            WebElement stokSayi = driver.findElement(By.xpath("//*[@type=\"number\"]"));//indirim yapmasi icin kitap sayisinin 1'den fazla olmasi gerekiyor
            stokSayi.clear();
            stokSayi.sendKeys("1");
            driver.findElement(By.xpath("//*[text()='Add to basket']")).click();
            return;
        }
        i++;
        stokDurumuUygunsaKitapEkle();
    }
}

package alistirmalar.automationtesting.anasayfa.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase11 extends TestBase {

    /*


TEST CASE 11
11. Home-Arrivals-Add to Basket-Items-Remove book
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
12) Now click on Item link which navigates to proceed to check out page.
13) Now click on Remove this icon in Check out page which removes that book from the grid.
14) User has the feasibility to remove the book at the time of check out also


TEST VAKA 11
11. Ana Sayfa-Gelenler-Sepete Ekle-Ürünler-Kitabı Kaldır
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
12) Şimdi, ödeme sayfasına ilerlemek için gezinen Öğe bağlantısına tıklayın.
13) Şimdi, bu kitabı ızgaradan kaldıran Çıkış sayfasındaki Bu simgeyi kaldır'a tıklayın.
14) Kullanıcı, check-out sırasında kitabı kaldırma olanağına da sahiptir.

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


        //13) Now click on Item link which navigates to proceed to check out page.
        //13)Şimdi, ödeme sayfasına ilerlemek için gezinen Öğe bağlantısına tıklayın.
        // driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/checkout/']")).click(); //*odeme sayfasina ilerle)

        //14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
        //14) Toplamda 50rps indirim kazanmak için Kupon kodunu 'krishnasakinala' olarak girin.
        driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("krishnasakinala"); //cupon'a kupon kodu gonderir


        //15) User can able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price
        //15) Kullanıcı, toplam fiyat üzerinden 50rps indirim sağlayan kupon metin kutusuna 'krishnasakinala' yazarak kupon uygulayabilir.
        driver.findElement(By.xpath("//input[@name='apply_coupon']")).click(); //apply cupon tusuna basar
        String kuponSonucYazisiVarMi= driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive']")).getText();//kupon uygulanmadai yazisi
        System.out.println("kuponSonucYazisiVarMi = " + kuponSonucYazisiVarMi);
        String expectedKuponIndirimYazisiVArMi="Coupon: krishnasakinala";
        Assert.assertTrue(!kuponSonucYazisiVarMi.contains(expectedKuponIndirimYazisiVArMi));
        driver.close();

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



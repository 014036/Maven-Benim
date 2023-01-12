package alistirmalar.automationtesting.anasayfa.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase16 extends TestBase {

    /*

TEST CASE 16
 16. Home-Arrivals-Add to Basket-Items-Check-out functionality
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
13) Now user can find total and subtotal values just above the Proceed to Checkout button.
14) The total always < subtotal because taxes are added in the subtotal
15) Now click on Proceed to Check out button which navigates to payment gateway page.
16) Clicking on Proceed to Checkout button leads to payment gateway page
17)Clicking on Proceed to Checkout button leads to payment gateway page


TEST VAKA 16
  16. Eve-Gelenler-Sepete Ekle-Öğeler-Ödeme işlevi
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

13) Artık kullanıcı, Ödeme İşlemine Geç düğmesinin hemen üzerinde toplam ve ara toplam değerlerini bulabilir.
14) Toplam her zaman < alt toplam çünkü ara toplama vergiler eklenir
15) Şimdi, ödeme ağ geçidi sayfasına giden Kontrol Et düğmesine tıklayın.
16) Ödemeye Devam Et düğmesine tıklamak, ödeme ağ geçidi sayfasına yönlendirir
17)Ödemeye Devam Et düğmesine tıklamak, ödeme ağ geçidi sayfasına yönlendirir

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


        //13) Artık kullanıcı, Ödeme İşlemine Geç düğmesinin hemen üzerinde toplam ve ara toplam değerlerini bulabilir.
        String subTotal = driver.findElement(By.xpath("//td[@data-title='Subtotal']")).getText().replace("₹", "");
        System.out.println("subTotal = " + subTotal);
        int subTotalInt = Integer.parseInt(subTotal.replaceAll("\\D", ""));
        System.out.println("subTotalInt = " + subTotalInt);

        String totalPrice = driver.findElement(By.xpath("//strong//span[@class='woocommerce-Price-amount amount']")).getText().replace("₹", "");
        System.out.println("totalPrice = " + totalPrice);
        int totalPriceInt = Integer.parseInt(totalPrice.replaceAll("\\D", ""));
        System.out.println("totalPriceInt = " + totalPriceInt);
        //14) Toplam her zaman > alt toplam çünkü ara toplama vergiler eklenir
        Assert.assertTrue(totalPriceInt > subTotalInt);
        // 15) Toplam
        String enSonTotal = driver.findElement(By.xpath(" //strong//span[@class='woocommerce-Price-amount amount']")).getText().replace("₹", "");
        System.out.println("enSonTotal = " + enSonTotal);

        //15) Now click on Proceed to Check out button which navigates to payment gateway page.
        //15) Şimdi, ödeme ağ geçidi sayfasına giden Kontrol Et düğmesine tıklayın.
driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/checkout/']")).click();

        //16) Clicking on Proceed to Checkout button leads to payment gateway page
        //16) Ödemeye Devam Et düğmesine tıklamak, ödeme ağ geçidi sayfasına yönlendirir
        WebElement odemeSayfasiGorunurMu= driver.findElement(By.xpath("//form[@name='checkout']"));
        Assert.assertTrue(odemeSayfasiGorunurMu.isDisplayed());



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
            stokSayi.sendKeys("4");
            driver.findElement(By.xpath("//*[text()='Add to basket']")).click();
            return;
        }
        i++;
        stokDurumuUygunsaKitapEkle();
    }
}

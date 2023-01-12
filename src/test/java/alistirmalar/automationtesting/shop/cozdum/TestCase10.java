package alistirmalar.automationtesting.shop.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase10 extends TestBase {

    /*
TEST CASE 10
10. Shop-Add to Basket-View Basket Functionality
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Click on the Add To Basket button which adds that book to your basket
5) User can view that Book in the Menu item with price .
6) Now click on View Basket link which navigates to proceed to check out page.
7) Now user can find total and subtotal values just above the Proceed to Checkout button.
8) The total always < subtotal because taxes are added in the subtotal
9) Now click on Proceed to Check out button which navigates to payment gateway page.
10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank
 transfer,cheque,cash or paypal.
12) Now click on Place Order button to complete process
13) On clicking place order button user completes his process where the page navigates to Order confirmation page with
 order details,bank details,customer details and billing details.




TEST VAKA 10
10. Alışveriş-Sepete Ekle-Sepet Görüntüle İşlevselliği
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) O kitabı sepetinize ekleyen Sepete Ekle düğmesini tıklayın.
5) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
6) Şimdi ödeme sayfasına ilerlemek için gezinen Sepeti Görüntüle bağlantısını tıklayın.
7) Artık kullanıcı, Ödeme İşlemine Geç düğmesinin hemen üzerinde toplam ve alt toplam değerleri bulabilir.
8) Toplam her zaman > alt toplam çünkü vergiler ara toplama eklenir
9) Şimdi, ödeme ağ geçidi sayfasına giden Kontrol Et düğmesine tıklayın.
10) Kullanıcı, Fatura Ayrıntılarını, Sipariş Ayrıntılarını, Ek ayrıntıları ve Ödeme ağ geçidi ayrıntılarını görüntüleyebilir.
11) Artık kullanıcı, ayrıntılarını fatura ayrıntıları formunda doldurabilir ve Doğrudan banka gibi ödeme ağ geçidinde herhangi bir ödemeyi seçebilir
  havale, çek, nakit veya paypal.
12) Şimdi işlemi tamamlamak için Sipariş Ver düğmesine tıklayın
13) Sipariş ver düğmesine tıklandığında, kullanıcı, sayfanın Sipariş onay sayfasına gittiği işlemi tamamlar.
  sipariş detayları, banka detayları, müşteri detayları ve fatura detayları.

  */

    @Test
    public void basketFunctionality() throws InterruptedException {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");
        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();
        //4) O kitabı sepetinize ekleyen Sepete Ekle düğmesini tıklayın.
        driver.findElement(By.xpath("(//a[.='Add to basket'])[1]")).click();
        //5) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
        WebElement fiyatGorunurMu= driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/product/html5-webapp-develpment/']"));
        Assert.assertTrue(fiyatGorunurMu.isDisplayed());
        //6) Şimdi ödeme sayfasına ilerlemek için gezinen Sepeti Görüntüle bağlantısını tıklayın.
        driver.findElement(By.xpath("//a[@title='View Basket']")).click();
        //7) Artık kullanıcı, Ödeme İşlemine Geç düğmesinin hemen üzerinde toplam ve alt toplam değerleri bulabilir.
        String subTotal = driver.findElement(By.xpath("//td[@data-title='Subtotal']")).getText().replace("₹", "");
        System.out.println("subTotal = " + subTotal);
        int subTotalInt = Integer.parseInt(subTotal.replaceAll("\\D", ""));
        System.out.println("subTotalInt = " + subTotalInt);
        String totalPrice = driver.findElement(By.xpath("//strong//span[@class='woocommerce-Price-amount amount']")).getText().replace("₹", "");
        System.out.println("totalPrice = " + totalPrice);
        int totalPriceInt = Integer.parseInt(totalPrice.replaceAll("\\D", ""));
        System.out.println("totalPriceInt = " + totalPriceInt);
        //8) Toplam her zaman > alt toplam çünkü vergiler ara toplama eklenir
        Assert.assertTrue(totalPriceInt > subTotalInt);
        //9) Şimdi, ödeme ağ geçidi sayfasına giden Kontrol Et düğmesine tıklayın.
        driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/checkout/']")).click();
        //10) Kullanıcı, Fatura Ayrıntılarını, Sipariş Ayrıntılarını, Ek ayrıntıları ve Ödeme ağ geçidi ayrıntılarını görüntüleyebilir.
        WebElement odemeSayfasiGorunurMu= driver.findElement(By.xpath("//form[@name='checkout']"));
        Assert.assertTrue(odemeSayfasiGorunurMu.isDisplayed());
        //11) Artık kullanıcı, ayrıntılarını fatura ayrıntıları formunda doldurabilir
        WebElement billingDetailsGorunurMu = driver.findElement(By.xpath("//form[@name='checkout']"));
        Assert.assertTrue(billingDetailsGorunurMu.isDisplayed());
        WebElement billingsDetailName = driver.findElement(By.id("billing_first_name"));
        billingsDetailName.sendKeys("Kemal");
        WebElement billingsDetailLastName = driver.findElement(By.id("billing_last_name"));
        billingsDetailLastName.sendKeys("Can");
        WebElement billingsDetailCompany = driver.findElement(By.id("billing_company"));
        billingsDetailCompany.sendKeys("Turkey");
        WebElement billingsDetailEmail = driver.findElement(By.id("billing_email"));
        billingsDetailEmail.sendKeys("gec.ici@hotmail.com");
        WebElement billingsDetailPhone = driver.findElement(By.id("billing_phone"));
        billingsDetailPhone.sendKeys("053615823700");
        driver.findElement(By.xpath("//*[@role='presentation']")).click();
        driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]")).sendKeys("Turkey", Keys.ENTER);
        WebElement adress = driver.findElement(By.xpath("//input[@name='billing_address_1']"));
        adress.sendKeys("Kutahya");
        WebElement adress2 = driver.findElement(By.xpath("//input[@id='billing_address_2']"));
        adress2.sendKeys("Merkez");
        WebElement townCity = driver.findElement(By.xpath("//input[@id='billing_city']"));
        townCity.sendKeys("Herhangi bir yer");
        townCity.sendKeys(Keys.TAB, Keys.ENTER, "Balıkesir", Keys.ENTER); //Province *
        WebElement postaCode = driver.findElement(By.xpath("//input[@id='billing_postcode']"));
        postaCode.sendKeys("43200");
        WebElement additionalInformation= driver.findElement(By.xpath("//textarea[@id='order_comments']"));
        additionalInformation.sendKeys("Merhaba");
        //Doğrudan banka havalesi, çek, nakit veya paypal gibi ödeme ağ geçidinde herhangi bir ödemeyi seçebilir.
        WebElement directBankTransferGorunurMu= driver.findElement(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']"));
        Assert.assertTrue(directBankTransferGorunurMu.isDisplayed());
        driver.findElement(By.xpath("//input[@id='payment_method_cod']")).click();//teslimatta odeme secenegi
        //12) Şimdi işlemi tamamlamak için Sipariş Ver düğmesine tıklayın
        driver.findElement(By.xpath(" //input[@class='button alt']")).click();//siparis ver butonuna basiyoruz
        //13) Sipariş ver düğmesine tıklandığında, kullanıcı, sayfanın Sipariş onay sayfasına gittiği işlemi tamamlar.
        //  sipariş detayları, banka detayları, müşteri detayları ve fatura detayları.
        WebElement orderDetailsSayfasiGorunurMu= driver.findElement(By.xpath("//div[@class='page-content entry-content']"));
        Assert.assertTrue(orderDetailsSayfasiGorunurMu.isDisplayed());
        Thread.sleep(5000);
    }
}

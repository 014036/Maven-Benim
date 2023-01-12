package alistirmalar.slayt_sorulari.cozdum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Sayfa_45 {
    public static void main(String[] args) {

      /*

      BU SORUDAKI SITE KULLANILMIYOR
         *********************** SAYFA 45 ***********************
        Class Work: LoginTest

        2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
                a. http://a.testaddressbook.com adresine gidiniz.
        b. Sign in butonuna basin
        c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        i. Username : testtechproed@gmail.com
        ii. Password : Test1234!
                e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
                f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        3. Sayfada kac tane link oldugunu bulun.

*/
        WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        2.  http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com ");

//        b. Sign in butonuna basin
//        c. email textbox,password textbox, and signin button elementlerini locate ediniz..
//        d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
//        i. Username : testtechproed@gmail.com
//        ii. Password : Test1234!
//                e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
//                f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
//        3. Sayfada kac tane link oldugunu bulun.


    }
}

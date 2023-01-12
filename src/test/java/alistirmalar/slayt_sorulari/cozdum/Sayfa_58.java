package alistirmalar.slayt_sorulari.cozdum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Sayfa_58 {
    /*
    Home Work: Log in Test Using Css
1 ) Bir class oluşturun : Locators_css
2 ) Main method oluşturun ve aşağıdaki görevi tamamlayın.
a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
b. Locate email textbox
c. Locate password textbox ve
d. Locate signin button
e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
i. Username : testtechproed@gmail.com
ii. Password : Test1234!
NOT: cssSelector kullanarak elementleri locate ediniz
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//a. Verilen web sayfasına gidin. https://devcenter.heroku.com/articles/logging#view-logs
driver.get("https://devcenter.heroku.com/articles/logging#view-logs");

driver.findElement(By.cssSelector("a[href=\"/login?back_to=%2Farticles%2Flogging\"]")).click();

//b. Locate email textbox
        driver.findElement(By.id("email")).sendKeys("testtechproed@gmail.com");


//c. Locate password textbox ve
        driver.findElement(By.id("password")).sendKeys("Test1234!");

//d. Locate signin button
        driver.findElement(By.cssSelector("button[name=\"commit\"]")).click();

//e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
//i. Username : testtechproed@gmail.com
//ii. Password : Test1234!

    }
}

    package alistirmalar.letcode.work_space;

    import com.github.dockerjava.api.model.CpuStatsConfig;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import utilities.TestBase;


    import java.time.Duration;

    public class C06_Iframe extends TestBase {

    static WebDriver driver;
    /*
    // https://letcode.in/ adresine git
    //Work-Space yazisina tikla
    //Acilan pencereden Frame e tikla
    //First Name bilgisini gir
    //Last Name bilgisini gir
    //Email bilgisini gir
    */

    @Before
    public void Setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
    // https://letcode.in/ adresine git
    driver.get("https://letcode.in/");

    //Work-Space yazisina tikla
    driver.findElement(By.id("testing")).click();

    //Acilan pencereden Frame e tikla
    driver.findElement(By.xpath("//a[@href='/frame']")).click();

    //First Name bilgisini gir
    WebElement frame1 = driver.findElement(By.id("firstFr"));
    driver.switchTo().frame(frame1);
    driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Mustafa");

    //Last Name bilgisini gir
    WebElement lastName = driver.findElement(By.xpath("//input[@name='lname']"));
    lastName.sendKeys("Ali");

    ////Email bilgisini gir
    //  ONEMLI ASAGIDAKI IFRAME BIR UST IFRAME'NIN ICINDE OLDUGU ICIN PARENTFRAME'YE DONMEDEN ISLEME DEVAM EDIYORUZ

    WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
    driver.switchTo().frame(frame2);
    driver.findElement(By.name("email")).sendKeys("abc@gmai.com");

    Thread.sleep(2000);
    //simdi tekrar last name'ye donelim eski degeri silip yeni bir deger yazalim
    driver.switchTo().parentFrame(); //once bir ust frame'ye cikalim
    lastName.clear();// demin yazmis oldugumuz degeri silelim
    lastName.sendKeys("Muhammet");//yeni deger yukleyelim
    Thread.sleep(2000);
    driver.switchTo().defaultContent();//anasayfaya donelim

    }

    @After
    public void TearDown() {
    driver.quit();
    }

    }

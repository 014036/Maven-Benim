    package alistirmalar.slayt_sorulari.cozdum;

    import com.github.javafaker.Faker;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.ui.Select;
    import utilities.TestBase;


    public class Sayfa_119_Actions4 extends TestBase {

    /*
    Yeni bir class olusturalim: D15_MouseActions4
    1- https://www.facebook.com adresine gidelim
    2- Yeni hesap olustur butonuna basalim
    3- Ad, soyad, mail ve sifre kutularina deger yazalim
    //Dogum tarihi ile ilgili kisimlari dolduralim (Select objesi kullanarak)
    4- Kaydol tusuna basalim
    */

    @Test
    public void mouseActionsTesti(){
    //1- https://www.facebook.com adresine gidelim
    driver.get("https://www.facebook.com");
    Actions actions =new Actions(driver);

    //2- Yeni hesap olustur butonuna basalim
    driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    Faker faker= new Faker();
    String fName=faker.name().firstName();
    driver.findElement(By.name("firstname")).sendKeys(fName);

    String lName=  faker.name().lastName();
    driver.findElement(By.name("lastname")).sendKeys(lName);

    String phonNumber= String.valueOf(faker.phoneNumber());
    String eMailAdress=  faker.internet().emailAddress();
    driver.findElement(By.name("reg_email__")).sendKeys(eMailAdress);
    driver.findElement(By.name("reg_email_confirmation__")).sendKeys(eMailAdress);


    //Dogum tarihi ile ilgili kisimlari dolduralim (Select objesi kullanarak)
    WebElement day=driver.findElement(By.name("birthday_day"));
//    Select selectday= new Select(day);
//    selectday.selectByVisibleText("20");
    WebElement month=  driver.findElement(By.name("birthday_month"));
//    Select selectMonth= new Select(month);
//    selectMonth.selectByValue("7");
    WebElement year= driver.findElement(By.name("birthday_year"));
//    Select selectYear= new Select(year);
//    selectYear.selectByVisibleText("2015");


        //Dogum tarihi ile ilgili kisimlari dolduralim(Resouble method'dan yararlanalim (TestBase'den)
        selectFromDropdown(day,"20");
        selectFromDropdown(month, "Tem");
        selectFromDropdown(year, "2014");



day.findElement(By.xpath("//label[.='Erkek']")).click();
    //4- Kaydol tusuna basalim
////day.findElement(By.xpath("//button[@name='websubmit']")).click();

    }
    }

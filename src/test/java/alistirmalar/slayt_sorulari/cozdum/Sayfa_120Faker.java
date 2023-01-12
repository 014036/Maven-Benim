    package alistirmalar.slayt_sorulari.cozdum;

    import com.github.javafaker.Faker;
    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;


    public class Sayfa_120Faker extends TestBase {
    /*
    1. "https://facebook.com" Adresine gidin
    2. “create new account” butonuna basin
    3. “firstName” giris kutusuna bir isim yazin
    4. “surname” giris kutusuna bir soyisim yazin
    5. “email” giris kutusuna bir email yazin
    6. “email” onay kutusuna emaili tekrar yazin
    7. Bir sifre girin
    8. Tarih icin gun secin
    9. Tarih icin ay secin
    10. Tarih icin yil secin
    11. Cinsiyeti secin
    12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    13. Sayfayi kapatin
    */

    @Test
    public void fakerTesti() {
    //1- https://www.facebook.com adresine gidelim
    driver.get("https://www.facebook.com");
    Actions actions = new Actions(driver);

    //2- Yeni hesap olustur butonuna basalim
    driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

    //  3. “firstName” giris kutusuna bir isim yazin
    Faker faker = new Faker();
    String fName = faker.name().firstName();
    driver.findElement(By.name("firstname")).sendKeys(fName);

    //    4. “surname” giris kutusuna bir soyisim yazin
    String lName = faker.name().lastName();
    driver.findElement(By.name("lastname")).sendKeys(lName);

    //    5. “email” giris kutusuna bir email yazin
    String eMailAdress = faker.internet().emailAddress();
    driver.findElement(By.name("reg_email__")).sendKeys(eMailAdress);

    //    6. “email” onay kutusuna emaili tekrar yazin
    driver.findElement(By.name("reg_email_confirmation__")).sendKeys(eMailAdress);

    //    7. Bir sifre girin
    String password = faker.internet().password();
    driver.findElement(By.name("reg_passwd__")).sendKeys(password);

    //    8. Tarih icin gun secin
    WebElement day = driver.findElement(By.name("birthday_day"));
    //    Select selectday= new Select(day);
    //    selectday.selectByVisibleText("20");
    //veya
    selectFromDropdown(day, "20");

    //    9. Tarih icin ay secin
    WebElement month = driver.findElement(By.name("birthday_month"));
    //    Select selectMonth= new Select(month);
    //    selectMonth.selectByValue("7");
    //VEYA
    selectFromDropdown(month, "Tem");


    //    10. Tarih icin yil secin
    WebElement year = driver.findElement(By.name("birthday_year"));
    //    Select selectYear= new Select(year);
    //    selectYear.selectByVisibleText("2015");
    //VEYA
    selectFromDropdown(year, "2014");

    //    11. Cinsiyeti secin
//    WebElement cinsiyetErkek = day.findElement(By.xpath("//label[.='Erkek']"));
//    cinsiyetErkek.click();
//    boolean cinsiyetErkekseciliMi = cinsiyetErkek.isSelected();
//    System.out.println("cinsiyetErkekseciliMi = " + cinsiyetErkekseciliMi);
//    Assert.assertTrue(cinsiyetErkek.isSelected());
    WebElement cinsiyetErkek1 = day.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
    cinsiyetErkek1.click();
            waitFor(5);
      boolean cinsiyetErkekseciliMi1 = cinsiyetErkek1.isSelected();
    System.out.println("cinsiyetErkekseciliMi1 = " + cinsiyetErkekseciliMi1);
    Assert.assertTrue(cinsiyetErkek1.isSelected());


    //    12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    waitFor(3);
    WebElement cinsiyetKadin = day.findElement(By.xpath("//label[.='Kadın']"));
    boolean cinsiyetKadinseciliMi = cinsiyetKadin.isSelected();
    System.out.println("cinsiyetKadinseciliMi = " + cinsiyetKadinseciliMi);
    Assert.assertTrue(!cinsiyetKadin.isSelected());

    WebElement cinsiyetOzel = day.findElement(By.xpath("(//input[@class='_8esa'])[3]"));
    boolean cinsiyetOzelseciliMi = cinsiyetOzel.isSelected();
    System.out.println("cinsiyetOzelseciliMi = " + cinsiyetOzelseciliMi);
    Assert.assertTrue(!cinsiyetOzel.isSelected());


    //    13. Sayfayi kapatin
    waitFor(3);
    driver.close();


    }
    }

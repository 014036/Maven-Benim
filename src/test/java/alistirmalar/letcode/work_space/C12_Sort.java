    package alistirmalar.letcode.work_space;

    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Point;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import utilities.TestBase;

    import java.util.ArrayList;
    import java.util.List;

    public class C12_Sort extends TestBase {

    /*
    // 1-https://letcode.in/ adresine git
    // 2-Work-Space yazisina tikla
    //3- Click on the Sort button --Sort düğmesine tıklayın
    Move the content from to do to done --İçeriği, yapılacaklar kısmından yapılacaklar kısmına taşıyın
    Pick up groceries --Yiyecekleri al
    Go home --Eve git
    Fall asleep --uykuya dalmak
    Get to work --ise baslamak
    Get up --yataktan kalkmak
    Brush teeth --dis fircalamak
    Take a shower --dus almak
    Check e-mail -emailini kontrol et
    Walk dog --kopegi yuruyuse cikar
    to do --yapmak
    done -tamamlamak

    */
    @Test
    public void sortTest(){
        //1 https://letcode.in/ adresine git
        driver.get("https://letcode.in/");
        // 2-Work-Space yazisina tikla
        driver.findElement(By.id("testing")).click();
        //3- Click on the Drop button --Drop düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/sortable']")).click();
        waitFor(2);
        Actions actions= new Actions(driver);
        //        List<WebElement>allLocations= driver.findElements(By.xpath("//div[@id='sample-box1']"));
        //        List<Point>locationslar= new ArrayList<>();
        //  allLocations.forEach(t->locationslar.add(t.getLocation());
        //  System.out.println("locationslar = " + locationslar);

        List<WebElement> adimlar = new ArrayList<>();
        adimlar.add(driver.findElement(By.xpath("//div[.=' Get up']")));
        adimlar.add(driver.findElement(By.xpath("//div[.=' Take a shower']")));
        adimlar.add(driver.findElement(By.xpath("//div[.=' Brush teeth']")));
        adimlar.add(driver.findElement(By.xpath("//div[.=' Walk dog']")));
        adimlar.add(driver.findElement(By.xpath("//div[.=' Get to work']")));
        adimlar.add(driver.findElement(By.xpath("//div[.=' Check e-mail']")));
        adimlar.add(driver.findElement(By.xpath("//div[.=' Pick up groceries']")));
        adimlar.add(driver.findElement(By.xpath("//div[.=' Go home']")));
        adimlar.add(driver.findElement(By.xpath("//div[.=' Fall asleep']")));
        for(int i=adimlar.size()-1; i>=0; i--){
            actions.clickAndHold(adimlar.get(i)).perform();
            actions.moveToElement(driver.findElement(By.xpath("(//*[@class=\"navbar-item\"])[9]"))).perform();//mouse'u başka elemente harakte ettiriyorum
            actions.moveByOffset(200,270);
            actions.release().perform();
            waitFor(1);
        }

    }
    }

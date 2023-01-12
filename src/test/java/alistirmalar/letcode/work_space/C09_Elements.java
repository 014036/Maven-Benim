    package alistirmalar.letcode.work_space;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import utilities.TestBase;


    import java.util.ArrayList;
    import java.util.List;

    public class C09_Elements extends TestBase {

    /*

    // 1-https://letcode.in/ adresine git
    // 2-Work-Space yazisina tikla
    //3- Click on the Elements button --Elements düğmesine tıklayın
    //4-Type and Enter your Git username -- Git kullanıcı adınızı yazın ve girin
    //5-Assert that user has image --Kullanıcının resmi olduğunu iddia et
    //6-Print the user name & other informations --Kullanıcı adını ve diğer bilgileri yazdırın
    //7-Assert that no.of public repositories are listed correctly --Genel depoların sayısının doğru listelendiğini iddia edin
    //eg. if Public Repos has 10 then in the list 10 links should be available --Örneğin. Public Repos'ta 10 tane varsa, listede 10 bağlantı bulunmalıdır.

    */
    @Test
    public void elementsTest01(){

    //1 https://letcode.in/ adresine git
    driver.get("https://letcode.in/");

    // 2-Work-Space yazisina tikla
    driver.findElement(By.id("testing")).click();

    //3- Click on the Elements button --Elements düğmesine tıklayın
    driver.findElement(By.xpath("//a[@href='/elements']")).click();

    //4-Type and Enter your Git username -- Git kullanıcı adınızı yazın ve girin
    WebElement inputName= driver.findElement(By.xpath("//input[@name='username']"));
    inputName.sendKeys("014036", Keys.ENTER);

    //5-Assert that user has image --Kullanıcının resmi olduğunu iddia et
    WebElement userHasImage= driver.findElement(By.xpath("//img[@alt='Placeholder image']"));
    //Assert.assertTrue(userHasImage.isDisplayed());

    //6-Print the user name & other informations --Kullanıcı adını ve diğer bilgileri yazdırın

    //div[@class='block']
    List<WebElement>userInformations= driver.findElements(By.xpath("//div[@class='block']/app-usercard"));
    List<String>userInformations1= new ArrayList<>() ;
    userInformations.forEach(t->userInformations1.add(t.getText()));
    System.out.println("userInformations1 = " + userInformations1);

    List <WebElement> actualRepos= driver.findElements(By.xpath("//div[@class='tags has-addons']"));
    List<String> reposStr= new ArrayList<>();
    actualRepos.stream().forEach(t->reposStr.add(t.getText()));
    System.out.println("reposStr = " + reposStr);

    //7-Assert that no.of public repositories are listed correctly --Genel depoların sayısının doğru listelendiğini iddia edin
    //eg. if Public Repos has 10 then in the list 10 links should be available --Örneğin. Public Repos'ta 10 tane varsa, listede 10 bağlantı bulunmalıdır.
    String actualPublicRepos= reposStr.get(0);
    System.out.println("actualPublicRepos = " + actualPublicRepos);

    String actualPublicGist= reposStr.get(1);
    System.out.println("actualPublicGist = " + actualPublicGist);

    String actualFollowers= reposStr.get(2);
    System.out.println("actualFollowers = " + actualFollowers);
    String expectedPublicRepos= "3";

    String expectedPublicGist= "0";
    String expectedFollowers= "15";

    List<WebElement>gitHub= driver.findElements(By.xpath("//div/app-gitrepos/div/div/ol/li"));
    List<String>bilgi= new ArrayList<>();
    gitHub.forEach(t->bilgi.add(t.getText()));
    System.out.println("bilgi = " + bilgi);
    }
    }

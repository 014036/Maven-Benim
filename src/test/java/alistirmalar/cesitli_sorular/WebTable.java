    package alistirmalar.cesitli_sorular;

    import org.junit.Assert;
    import org.junit.Test;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import utilities.TestBase;

    import java.util.ArrayList;
    import java.util.List;

    public class WebTable extends TestBase {

    /*
    //https://www.way2automation.com/angularjs-protractor/webtables/
    //tüm E-mail leri yazdırın
    //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
    */


    @Test
    public void webTableEmailTest(){

    //https://www.way2automation.com/angularjs-protractor/webtables/
    driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");

    //tüm E-mail leri yazdırın
    List<WebElement>tumEmailler= driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody//tr//td[7]"));
    List<String>allEmail= new ArrayList<>();
    for (WebElement w: tumEmailler){
    allEmail.add(w.getText());
    }
    System.out.println("allEmail = " + allEmail);

    //Tüm E-maillerin "@" işareti içerdiğini doğrulayin

    for (int i=0; i< allEmail.size(); i++){
    Assert.assertTrue(allEmail.get(i).contains("@"));
    }
        }


        @Test
        public void eMailsFromWebTable() {
            driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
            List<WebElement> eMails = driver.findElements(By.xpath("//table//tbody//tr//td[7]"));
            eMails.forEach(eMail -> System.out.println(eMail.getText()));
            eMails.forEach(eMail -> Assert.assertTrue(eMail.getText().contains("@")));
        }
    }

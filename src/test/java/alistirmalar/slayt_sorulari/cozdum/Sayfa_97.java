package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Sayfa_97 extends TestBase {

    /*
1-Bir class olusturun: Alerts
2- https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
3-Bir metod olusturun: acceptAlert
4-○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
5-“You successfully clicked an alert” oldugunu test edin.
6- Bir metod olusturun: dismissAlert
7-○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
8-“successfuly” icermedigini test edin.
9-Bir metod olusturun: sendKeysAlert
10-○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    @Test
    public void acceptAlerts() {

    //2- https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

      //4-○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String successfullyClickedAnAlert= driver.findElement(By.id("result")).getText();
        String expected= "You successfully clicked an alert";
        Assert.assertEquals(expected, successfullyClickedAnAlert);
    //6- Bir metod olusturun: dismissAlert
    //7-○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //8-“successfuly” icermedigini test edin.
    //9-Bir metod olusturun: sendKeysAlert
    //10-○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    }

    @Test
    public void dismissAlert() {
    //6- Bir metod olusturun: dismissAlert
    //2- https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    //7-○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
    driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
    driver.switchTo().alert().dismiss();
    String resultMessage= driver.findElement(By.id("result")).getText();
    String expected= "successfuly";
    Assert.assertFalse(resultMessage.contains(expected));


    }

    @Test
    public void sendKeysAlert() {
    //9-Bir metod olusturun: sendKeysAlert
    //2- https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    //10-○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
    driver.switchTo().alert().sendKeys("Mustafa");
    driver.switchTo().alert().accept();
    String resultMessage= driver.findElement(By.id("result")).getText();
    String expected= "Mustafa";
    Assert.assertTrue(resultMessage.contains(expected));

    }
}

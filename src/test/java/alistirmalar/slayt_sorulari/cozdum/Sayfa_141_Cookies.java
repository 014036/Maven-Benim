package alistirmalar.slayt_sorulari.cozdum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;


import java.util.Set;

public class Sayfa_141_Cookies extends TestBase {
    /*
1-Amazon anasayfaya gidin
2-tum cookie’leri listeleyin
3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
olusturun ve sayfaya ekleyin
6-eklediginiz cookie’nin sayfaya eklendigini test edin
7-ismi skin olan cookie’yi silin ve silindigini test edin
8-tum cookie’leri silin ve silindigini test edin
 */

    @Test
    public void cookiesTest01() {
//1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

//2-tum cookie’leri listeleyin
        Set<Cookie> allCookies= driver.manage().getCookies();
        allCookies.forEach(t-> System.out.println(t));
        allCookies.forEach(t-> System.out.println("Cookies isimleri sunlardir: "+t.getName()));

//3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("allCookies.size() = " + allCookies.size());
        Assert.assertTrue(allCookies.size()>5);

//4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Cookie cookieValue= driver.manage().getCookieNamed("i18n-prefs");
        System.out.println("cookieValue.getValue() = " + cookieValue.getValue());

//5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie myCookie= new Cookie("Cikolatam","antep-Fistikli-Cikolata");
        driver.manage().addCookie(myCookie);
        waitFor(3);


//6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie> allCookies2= driver.manage().getCookies();
        allCookies2.forEach(t-> System.out.println("Cookies isimleri sunlardir: " + t.getName()));
        System.out.println("myCookie= " + driver.manage().getCookieNamed("Cikolatam"));

//
//7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        String cookies= "skin";
        Assert.assertTrue(!allCookies.contains(cookies));
//8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Set<Cookie> allCookiesSon= driver.manage().getCookies();
        System.out.println("allCookiesSon.size() = " + allCookiesSon.size());
        // Assert.assertTrue(allCookiesSon.size()==0);

    }
}

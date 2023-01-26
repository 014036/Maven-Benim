package alistirmalar.cesitli_sorular.cozdum;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class C01_Files {
    // Exercise 1...
    // masaustunde bir text dosyası olusturun
    // masaustundeki text dosyasının varlıgını test edin
    @Test
    public void test01() {
        // "C:\Users\BURAK      \Desktop\text.txt"
        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Desktop\\text.txt")));  Bu islemi daha dinamik hale getirelim
        String farkliKisim=System.getProperty("user.home"); //
        String ortakKisim="\\Desktop\\text.txt"; //
        String dosyaYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}

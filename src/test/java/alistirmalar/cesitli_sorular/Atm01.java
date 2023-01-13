package alistirmalar.cesitli_sorular;

public class Atm01 {

    /*
    Test Cases for ATM
Given below are the various test cases for ATM.

#1) Verify if the card reader is working correctly. A screen should ask you to insert the pin after inserting the valid card.

#2) Verify if the cash dispenser is working as expected.

#3) Verify if the receipt printer is working correctly. Which means it can print the data on the paper and the paper comes out properly.

#4) Verify if the Screen buttons are working correctly. For touch screen: Verify if it is operational and working as per the expectations.

#5) Verify if the text on the screen button is visible clearly.

#6) Verify the font of the text on the screen buttons.

#7) Verify each number button on the Keypad.

#8) Verify the functionality of the Cancel button on the Keypad.


#9) Verify the text color of the keypad buttons. The numbers should be visible clearly.

#10) Verify the text color and font of the data on the screen. The user should be able to read it clearly.

#11) Verify the language selection option. If the messages or data are displayed in the selected language.

#12) Insert the card, the correct pin, and print the receipt for available balance.

#13) Verify the receipt printing functionality after a valid transaction. Whether the printed data is correct or not.

#14) Verify how much time the system takes to log out.

#15) Verify the timeout session functionality.

#16) Verify the deposit slot functionality depending on its capability (Cash or cheque or both) by inserting a valid cheque.

#17) Verify using different cards (Cards of different banks).

Verifying the Message
#18) Insert the card and an incorrect PIN to verify the message.

#19) Verify the message when there is no cash in the ATM.

#20) Verify the messages after a transaction.

#21) Verify if a user will get a correct message if a card is inserted incorrectly.

Messages for each and every scenario should be verified.

Cash Withdrawal
#22) Verify the cash withdrawal functionality by inserting some valid amount.

#23) Verify if a user can perform only one cash withdrawal transaction per PIN insert.

#24) Verify the different combinations of operation and check if there will be a power loss in the middle of the operation.

Negative Test cases
#25) Verify the functionality by entering a wrong pin number for 3 or more times.

#26) Verify the card reader functionality by inserting an expired card.

#27) Verify the deposit slot functionality by inserting an invalid cheque.

#28) Verify the cash withdrawal functionality by inserting invalid numbers like 10, 20, 50 etc.

#29) Verify the cash withdrawal functionality by entering an amount greater than the per day limit,

#30) Verify the cash withdrawal functionality by entering an amount greater than per transaction limit.

#31) Verify the cash withdrawal functionality by entering an amount greater than the available balance in the account.

Conclusion
ATM machines must be tested for accuracy, reliability, and performance. It should get tested for its response time per
transaction as it works for 24*7.

All the above-mentioned points should be considered while testing ATM machines. There should be a combination of both
positive and negative test cases while writing test cases for any product.
     */

    /*
    ATM için Test Senaryoları
Aşağıda, ATM için çeşitli test durumları verilmiştir.

#1) Kart okuyucunun düzgün çalışıp çalışmadığını kontrol edin. Geçerli kartı taktıktan sonra bir ekran sizden pini takmanızı isteyecektir.

#2) Terminalin beklendiği gibi çalışıp çalışmadığını doğrulayın.

#3) Makbuz yazıcısının düzgün çalışıp çalışmadığını kontrol edin. Bu, verileri kağıda yazdırabileceği ve kağıdın düzgün bir şekilde çıktığı anlamına gelir.

#4) Ekran düğmelerinin düzgün çalışıp çalışmadığını kontrol edin. Dokunmatik ekran için: Çalışır durumda olduğunu ve beklentilere göre çalıştığını doğrulayın.

#5) Ekran düğmesindeki metnin net bir şekilde görünüp görünmediğini doğrulayın.

#6) Ekran düğmelerindeki metnin yazı tipini doğrulayın.

#7) Tuş takımındaki her sayı düğmesini doğrulayın.

#8) Tuş takımındaki İptal düğmesinin işlevselliğini doğrulayın.


#9) Tuş takımı düğmelerinin metin rengini doğrulayın. Rakamlar açıkça görülebilmelidir.

#10) Ekrandaki verilerin metin rengini ve yazı tipini doğrulayın. Kullanıcı bunu net bir şekilde okuyabilmelidir.

#11) Dil seçimi seçeneğini doğrulayın. Mesajlar veya veriler seçilen dilde görüntüleniyorsa.

#12) Kartı, doğru pimi takın ve mevcut bakiye için makbuzu yazdırın.

#13) Geçerli bir işlemden sonra makbuz yazdırma işlevini doğrulayın. Yazdırılan verilerin doğru olup olmadığı.

#14) Sistemin oturumu kapatmasının ne kadar sürdüğünü doğrulayın.

#15) Zaman aşımı oturumu işlevini doğrulayın.

#16) Geçerli bir çek ekleyerek para yatırma yuvası işlevselliğini kapasitesine (Nakit veya çek veya her ikisi) bağlı olarak doğrulayın.

#17) Farklı kartlar (farklı bankaların kartları) kullanarak doğrulama yapın.

Mesajı Doğrulama
#18) Mesajı doğrulamak için kartı ve yanlış bir PIN girin.

#19) ATM'de nakit olmadığında mesajı doğrulayın.

#20) Bir işlemden sonra mesajları doğrulayın.

#21) Bir kart yanlış takılırsa kullanıcının doğru mesajı alıp almayacağını doğrulayın.

Her senaryo için mesajlar doğrulanmalıdır.

Nakit Çekme
#22) Geçerli bir miktar girerek nakit çekme işlevini doğrulayın.

#23) Bir kullanıcının PIN girişi başına yalnızca bir nakit çekme işlemi yapıp yapamayacağını doğrulayın.

#24) Farklı işlem kombinasyonlarını doğrulayın ve işlemin ortasında güç kaybı olup olmayacağını kontrol edin.

Negatif Test durumları
#25) 3 veya daha fazla kez yanlış bir pin numarası girerek işlevselliği doğrulayın.

#26) Süresi dolmuş bir kart takarak kart okuyucu işlevselliğini doğrulayın.

#27) Geçersiz bir çek ekleyerek para yatırma yuvası işlevselliğini doğrulayın.

#28) 10, 20, 50 gibi geçersiz sayılar girerek nakit çekme işlevini doğrulayın.

#29) Günlük limitten daha yüksek bir miktar girerek nakit çekme işlevini doğrulayın,

#30) İşlem limitinden daha yüksek bir miktar girerek nakit çekme işlevini doğrulayın.

#31) Hesaptaki mevcut bakiyeden daha yüksek bir miktar girerek nakit çekme işlevini doğrulayın.

Çözüm
ATM makineleri doğruluk, güvenilirlik ve performans açısından test edilmelidir. 7*24 çalıştığı için işlem başına yanıt
süresi açısından test edilmelidir.

ATM makinelerini test ederken yukarıda belirtilen tüm hususlar dikkate alınmalıdır. Herhangi bir ürün için test
senaryoları yazarken hem pozitif hem de negatif test senaryolarının bir kombinasyonu olmalıdır.
     */
}

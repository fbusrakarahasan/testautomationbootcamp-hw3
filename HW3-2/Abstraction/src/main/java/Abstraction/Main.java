package Abstraction;

public class Main {
    public static void main(String[] args) {

         /*
            Abstract, ortak olan methodları yazdığımız yer.
            Eğer farklı methodlar varsa abstract void method olarak yazabiliriz.
         */

        AbstractClass _homePage = new HomePageTest();

        _homePage.open("https://enuygun.com"); // Enuygun.com'u açıyoruz
        _homePage.clickLoginBtn(); // Giriş Yap butonuna tıklıyoruz
        _homePage.loginPopupIsDisplayed(); // Giriş yap popup açıldı mı?
    }
}
package Inheritance;

public class Main {
    public static void main(String[] args) {

        HomePageTest _homePage = new HomePageTest();
        InheritanceEnuygun _enuygun = new InheritanceEnuygun();

        /*
            Homepage sınıfından nesne oluşturularak sadece homepagedeki metotlar çağırılabilir.
            InheritanceEnuygun sınıfı homepageden kalıtım aldığı için hem kendi sınıfından hem de homepage sınıfından her metoda erişebilir.
        */

        _homePage.open("https://enuygun.com"); // Enuygun.com'u açıyoruz
        _homePage.clickLoginBtn(); // Giriş Yap butonuna tıklıyoruz

        _enuygun.loginPopupIsDisplayed(); // Giriş yap popup açıldı mı?

    }
}
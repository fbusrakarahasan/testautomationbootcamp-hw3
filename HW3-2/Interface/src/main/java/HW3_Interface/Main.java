package HW3_Interface;

public class Main {
    public static void main(String[] args){
        HomePageTest _homePage = new HomePageTest();

        _homePage.open("https://enuygun.com"); // Enuygun.com'u açıyoruz
        _homePage.clickLoginBtn(); // Giriş Yap butonuna tıklıyoruz
        _homePage.loginPopupIsDisplayed(); // Giriş yap popup açıldı mı?
    }
}





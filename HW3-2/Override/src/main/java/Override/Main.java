package Override;

public class Main {
    public static void main(String[] args) {

        OverrideEnuygun _enuygun = new OverrideEnuygun();
      /*
        HomePage'deki clickLoginBtn OverrideEnuygun sınıfında Override edildiği için,
        OverrideEnuygun sınıfında yazılan metot dikkate alınır.
      */

        _enuygun.open("https://enuygun.com"); // Enuygun.com'u açıyoruz
        _enuygun.clickLoginBtn(); // Giriş Yap butonuna tıklıyoruz
        _enuygun.loginPopupIsDisplayed(); // Giriş yap popup açıldı mı?
    }
}
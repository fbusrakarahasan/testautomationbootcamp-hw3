 
 <h1 align="center"> :bookmark_tabs: Enuygun - Test Automation Bootcamp - HW3-2 </h1>
 
> ###  ``` Override - Enuygun Giriş Yap Buton Testi ```

Override, üst sınıftan gelen bir metotu alıp kendi ihtiyacımıza göre gövdesini değiştirmek için kullanılır. 

Yani, HomePage'deki `clickLoginBtn` OverrideEnuygun sınıfında `Override` edildiği için, OverrideEnuygun sınıfında yazılan metot dikkate alınır.


- [x]  `Main` 

```java   
public class Main {
    public static void main(String[] args) { 
      /*
        HomePage'deki clickLoginBtn OverrideEnuygun sınıfında Override edildiği için,
        OverrideEnuygun sınıfında yazılan metot dikkate alınır.
      */
      
        OverrideEnuygun _enuygun = new OverrideEnuygun(); 
        
        _enuygun.open("https://enuygun.com"); // Enuygun.com'u açıyoruz
        _enuygun.clickLoginBtn(); // Giriş Yap butonuna tıklıyoruz
        _enuygun.loginPopupIsDisplayed(); // Giriş yap popup açıldı mı?
    }
}
```

- [x]  `Override Enuygun` 

```java
public class OverrideEnuygun extends HomePageTest {

    @Override
    public void clickLoginBtn() {
        getDriver().findElement(By.id(_homeElements.loginBtn)).click();
    }
}
```

- [x]  `Home Page Test` 

```java 
public class HomePageTest {
    WebDriver driver;
    HomeElements _homeElements = new HomeElements();

    public WebDriver getDriver() {
        String[] argument = {"--start-maximized"}; // Tam ekran olarak browser başlasın
        DriverType driverType = DriverType.CHROME; // Browser tipi chrome seçildi
        driver = Driver.get(driverType, argument);
        return driver;
    }

    public void open(String url) {
        getDriver().get(url);
    }

    public void clickLoginBtn() {
        getDriver().findElement(By.id("Override Edileceği İçin Burası Çağırılmaz")).click();
    }

    public void clickSignUpBtn() {
        getDriver().findElement(By.id(_homeElements.registerBtn)).click();
    }

    public void loginPopupIsDisplayed() {
        try {
            boolean displayed = getDriver().findElement(By.cssSelector(_homeElements.cssPopUp)).isDisplayed();
            System.out.println(displayed ? "Test basarili." : "Test basarisiz.");
        } catch (Exception e) {
            System.out.println("Test basarisiz. \n\nHata: " + e.getMessage());
        }
        Driver.closeDriver();
    }
}
```  



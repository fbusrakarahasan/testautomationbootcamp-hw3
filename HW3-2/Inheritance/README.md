 
 <h1 align="center"> :bookmark_tabs: Enuygun - Test Automation Bootcamp - HW3-2 </h1>
 
> ###  ``` Inheritance - Enuygun Giriş Yap Buton Testi ```
 
Inheritance, bir sınıfın sahip olduğu özellik ve metotların başka sınıflara aktarılmasıdır. 
Özelliklerini aktaran sınıf Ata ve özellikleri miras alan sınıf ise Çocuk olarak düşünülebilir.  <br>

Çocuk sınıfın, Ata sınıf özelliklerini miras alabilmesi için de "extends" anahtarı kullanılır.

Görüldüğü gibi, Çocuk sınıfın`(InheritanceEnuygun)` Ata sınıfa`(Homepage)` ulaşması için "extends" anahtarını kullandık. Bu sayede özellik ve metotların miras alınacağını bildirmiş olduk.

Yani, 
-  Homepage sınıfından nesne oluşturularak sadece homepagedeki metotlar çağırılabilir.  `open, clickLoginBtn` <br>
-  InheritanceEnuygun sınıfı ise homepageden kalıtım aldığı için hem kendi sınıfından hem de homepage sınıfından her metoda erişebilir. `open, clickLoginBtn, clickSignUpBtn, loginPopupIsDisplayed`


- [x]  `Main` 

```java   
public class Main {
    public static void main(String[] args) { 
        /*
            Homepage sınıfından nesne oluşturularak sadece homepagedeki metotlar çağırılabilir.
            InheritanceEnuygun sınıfı homepageden kalıtım aldığı için hem kendi sınıfından hem de homepage sınıfından her metoda erişebilir.
        */
        
        HomePageTest _homePage = new HomePageTest();
        InheritanceEnuygun _enuygun = new InheritanceEnuygun();
 
        _homePage.open("https://enuygun.com"); // Enuygun.com'u açıyoruz
        _homePage.clickLoginBtn(); // Giriş Yap butonuna tıklıyoruz

        _enuygun.loginPopupIsDisplayed(); // Giriş yap popup açıldı mı?

    }
}
```

- [x]  `Home Page Tests` 

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
        getDriver().findElement(By.id(_homeElements.loginBtn)).click();
    }
}
```

- [x]  `Inheritance Enuygun` 

```java 
public class InheritanceEnuygun extends HomePageTest {
    public void clickSignUpBtn() {
        super.getDriver().findElement(By.id(super._homeElements.registerBtn)).click();
    }

    public void loginPopupIsDisplayed() {
        try {
            boolean displayed = super.getDriver().findElement(By.cssSelector(super._homeElements.cssPopUp)).isDisplayed();
            System.out.println(displayed ? "Test basarili." : "Test basarisiz.");
        } catch (Exception e) {
            System.out.println("Test basarisiz. \n\nHata: " + e.getMessage());
        }
    }
}
```  



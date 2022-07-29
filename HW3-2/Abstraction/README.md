 
 <h1 align="center"> :bookmark_tabs: Enuygun - Test Automation Bootcamp - HW3-2 </h1>
 
> ###  ``` Abstraction - Enuygun Giriş Yap Buton Testi ```
 
Abstract, kod tekrarını engelleyerek hem daha derli toplu bir görüntü sağlar hem de hata yapma riskini azaltır. 
Ortak bir şablon üzerinden ilerleme imkanı sunar ve bu sınıfların temel amacı da budur. 
Dolayısıyla, Abstract sınıflardan nesne üretimi gerçekleştirilemez.

- Soyut sınıf içerisinde soyut veya somut olmayan metotlar bulunabilir. <br>
- Soyut metotlar "abstract" anahtarı ile public veya protected olacak şekilde tanımlanabilir.  
 Ayrıca gövde, yani içerilerinde kod blokları içermezler ve yalnızca imzadan ibarettirler. <br> `clickSignUpBtn, loginPopupIsDisplayed`
- Soyut olmayan metotların ise içerisinde kod blokları bulunur. `open, clickLoginBtn`


- [x]  `Main` 

```java  
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
```

- [x]  `Abstract Class` 

```java 
public abstract class AbstractClass {
    /*
        Abstract classlar interface gibi gövdesiz metot olmak zorunda değildir.
        Ayrıca interfacede kalıtım yapıldığında her metot için gövde oluşturmak zorundayız.(Override etmek zorundayız)
        Abstract sınıflarda ise her metodu override etmek zorunda değiliz.
    */

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

    abstract void clickSignUpBtn();
    abstract void loginPopupIsDisplayed();
}
```  

- [x]  `Home Page Tests` 

```java
public class HomePageTest extends AbstractClass {

    HomeElements _homeElements = new HomeElements();

    @Override
    public void clickSignUpBtn() {
        getDriver().findElement(By.id(_homeElements.registerBtn)).click();
    }

    @Override
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

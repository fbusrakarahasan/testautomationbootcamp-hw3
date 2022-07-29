 
 <h1 align="center"> :bookmark_tabs: Enuygun - Test Automation Bootcamp - HW3-2 </h1>
 
> ###  ``` Interface - Enuygun Giriş Yap Buton Testi ```

Interface, java dilinde class nasıl tanımlanıyorsa öyle tanımlanır. 
Class yerine interface yazılır. Ancak soyut olarak sınıf sayabiliriz. 
Clastan farklı olarak statik değişkenleri vardır.

> Peki neden interface kullanırız?

Java çoklu mirası desteklemez. Bir sınıf ancak tek bir sınıfın mirasçısı olabilir. 
Ancak interface kullanarak çoklu kalıtım özelliği kazandırılabilir. Bu sebepten çoklu miras alabilmek içinde interface çözümlerden biridir.

Bir sınıf, bir soyut sınıfı genişletirken`(extends)`, bir arayüzü uygular`(implements)`. 
Her ikisinde de (genişleten veya uygulayan) sınıf, (soyut sınıfın veya interface’in) soyut metotlarını örtmek`(Override)` zorundadır.
 




- [x]  `Main` 

```java   
public class Main {
    public static void main(String[] args){
        HomePageTest _homePage = new HomePageTest();

        _homePage.open("https://enuygun.com"); // Enuygun.com'u açıyoruz
        _homePage.clickLoginBtn(); // Giriş Yap butonuna tıklıyoruz
        _homePage.loginPopupIsDisplayed(); // Giriş yap popup açıldı mı?
    }
}
```

- [x]  `Enuygun Interface` 

```java
interface IEnuygunInterface {
    WebDriver getDriver();
    void open(String url);
    void clickLoginBtn();
    void clickSignUpBtn();
    void loginPopupIsDisplayed();
}
```

- [x]  `Home Page Test` 

```java 
public class HomePageTest implements IEnuygunInterface {//Enuygun interfacesinden miras alınır
    WebDriver driver;
    HomeElements _homeElements = new HomeElements();

    @Override
    public WebDriver getDriver() {
        String[] argument = {"--start-maximized"}; // Tam ekran olarak browser başlasın
        DriverType driverType = DriverType.CHROME; // Browser tipi chrome seçildi
        driver = Driver.get(driverType, argument);
        return driver;
    }

    @Override
    public void open(String url) {
        getDriver().get(url);
    }

    @Override
    public void clickLoginBtn() {
        getDriver().findElement(By.id(_homeElements.loginBtn)).click();
    }

    @Override
    public void clickSignUpBtn() {
        this.getDriver().findElement(By.id(_homeElements.registerBtn)).click();
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



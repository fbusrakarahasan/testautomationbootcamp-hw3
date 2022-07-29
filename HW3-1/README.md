<h1 align="center"> :bookmark_tabs: Enuygun - Test Automation Bootcamp - HW3_1 </h1>
 

> ##  ``` Selenium - Chrome Profil Kullanımı   ``` 
 
Chrome profilinin yolunu getirmek için öncelikle kullanıcı adına ihtiyacımız var. Kullanıcı adını getirmek için UserName methodu yazıldı.
 
```java
  public static String UserName() {
        try {
            return new NTSystem().getName(); // Sistem kullanıcı adı getirilir.
        } catch (Exception e) {
            return "";
        }
    }
```

Chrome profilini aktarmak için ise chromeoption kullanıldı. Kullanıcı veri yolunu arguman olarak`(user-data-dir)` set edip chromedriver nesnesini çağırdım. Böylelikle profile erişmiş oldum.
 
```java
    public static void main(String[] args) {
        Path resourceDirectory = Paths.get("src", "main", "resources"); // Resources klasörünün yolu tanımlanıyor
        String absolutePath = resourceDirectory.toFile().getAbsolutePath(); // Resource klasörünün yolu getiriliyor
        System.setProperty("webdriver.chrome.driver", absolutePath + "/chromedriver.exe"); // Chromedriver set ediliyor


        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/" + UserName() + "/AppData/Local/Google/Chrome/User Data"); // Var olan chrome profili ile açmak için kullanılıyor
        options.addArguments("--start-maximized");  // Başlangıçta tam ekran açılması için

        WebDriver driver = new ChromeDriver(options); // Chromedriver nesnesi chrome option ile tanımlanıyor
        driver.get("https://google.com");
    }
```

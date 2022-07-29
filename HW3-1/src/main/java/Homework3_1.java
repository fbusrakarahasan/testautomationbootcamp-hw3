import com.sun.security.auth.module.NTSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Homework3_1 {
    public static String UserName() {
        try {
            return new NTSystem().getName(); // Sistem kullanıcı adı getirilir.
        } catch (Exception e) {
            return "";
        }
    }

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
}

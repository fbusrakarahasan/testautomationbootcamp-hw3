package Abstraction;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.nio.file.Path;

public class Utility {
    public static @NotNull ChromeOptions setChromeOptions(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(args);  // Argümanları liste halinde set etmek için kullanıyoruz.
        return chromeOptions;
    }

    public static @NotNull FirefoxOptions setFirefoxOptions(String[] args) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(args);  // Argümanları liste halinde set etmek için kullanıyoruz.
        return firefoxOptions;
    }

    public static void setDriverProps(@NotNull Enum driverType) {

        Path off = Path.of("src", "main", "resources");
        String absolutePath = off.toFile().getAbsolutePath(); // Resource klasörünün yolu getiriliyor

        if (driverType.equals(DriverType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", absolutePath + "/binary/chromedriver.exe"); // Chromedriver set edilir
        } else if (driverType.equals(DriverType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", absolutePath + "/binary/geckodriver.exe"); // Geckodriver set edilir
        } else {
            throw new IllegalStateException("Driver tipi gönderilmedi. " + driverType);
        }
    }
}

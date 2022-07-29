package Inheritance;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver extends Utility {
    private static WebDriver driver;

    public static WebDriver get(Enum driverType, String[] args) {
        try {
            if (driver == null) { // driver nesnesi tanımlı değil ise
                if (driverType.equals(DriverType.CHROME)) {
                    setDriverProps(DriverType.CHROME);
                    driver = new ChromeDriver(setChromeOptions(args));
                }
                if (driverType.equals(DriverType.FIREFOX)) {
                    setDriverProps(DriverType.FIREFOX);
                    driver = new FirefoxDriver(setFirefoxOptions(args));
                }
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        } catch (IllegalStateException e) {
            System.out.println("Driver set edilemedi. Driver konumunu kontrol ediniz. \n\nHata: " + e.getMessage());
        } catch (SessionNotCreatedException e) {
            System.out.println("Driver ile browser versiyonunuz uyusmuyor. Kontrol ediniz. \n\nHata: " + e.getMessage());
        }
        return driver;
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
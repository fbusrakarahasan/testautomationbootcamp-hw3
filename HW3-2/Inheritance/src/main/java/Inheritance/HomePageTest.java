package Inheritance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

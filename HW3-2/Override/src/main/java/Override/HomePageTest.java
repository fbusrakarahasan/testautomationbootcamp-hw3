package Override;

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

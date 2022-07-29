package HW3_Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
package Abstraction;

import org.openqa.selenium.By;

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

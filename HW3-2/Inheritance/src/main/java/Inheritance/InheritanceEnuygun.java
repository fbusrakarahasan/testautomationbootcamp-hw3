package Inheritance;

import org.openqa.selenium.By;

public class InheritanceEnuygun extends HomePageTest {
    public void clickSignUpBtn() {
        super.getDriver().findElement(By.id(super._homeElements.registerBtn)).click();
    }

    public void loginPopupIsDisplayed() {
        try {
            boolean displayed = super.getDriver().findElement(By.cssSelector(super._homeElements.cssPopUp)).isDisplayed();
            System.out.println(displayed ? "Test basarili." : "Test basarisiz.");
        } catch (Exception e) {
            System.out.println("Test basarisiz. \n\nHata: " + e.getMessage());
        }
    }
}
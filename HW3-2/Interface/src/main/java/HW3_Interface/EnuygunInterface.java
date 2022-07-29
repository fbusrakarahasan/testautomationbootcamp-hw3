package HW3_Interface;

import org.openqa.selenium.WebDriver;

interface IEnuygunInterface {
    WebDriver getDriver();
    void open(String url);
    void clickLoginBtn();
    void clickSignUpBtn();
    void loginPopupIsDisplayed();
}
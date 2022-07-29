package Override;

import org.openqa.selenium.By;

public class OverrideEnuygun extends HomePageTest {

    @Override
    public void clickLoginBtn() {
        getDriver().findElement(By.id(_homeElements.loginBtn)).click();
    }
}
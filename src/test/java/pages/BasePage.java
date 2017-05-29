package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public BasePage(AppiumDriver driver) throws Exception {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 45);
    }

    void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void hideKeyBoard() {
        try {
            driver.hideKeyboard();
        } catch (Exception e) {

        }
    }
}

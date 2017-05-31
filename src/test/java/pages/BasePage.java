package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

class BasePage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    BasePage(AppiumDriver driver) throws Exception {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 45);
    }

    void waitForElementsToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    void hideKeyBoard() {
        try {
            driver.hideKeyboard();
        } catch (Exception e) {

        }
    }

    public void swipeToElement(WebElement element) {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        int y = element.getLocation().getY();
        while (height < y) {
            y = height/2;
            driver.swipe(width / 2, y, width / 2, 10, 1000);
            y = element.getLocation().getY();
        }
    }

    public void waitForElementsToBeVisible(List<WebElement> elementList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void scrollTo(String text) {
        scrollDownTo(text);
    }

    public void scrollDownTo(String text) {
        scrollDownTo(By.xpath("//*[@text=\"" + text + "\"]"));
    }

    public void scrollDownTo(By by) {
        int i = 0;
        while (i < 5) {
            if (driver.findElements(by).size() > 0) {
//                return;
                int height = driver.manage().window().getSize().getHeight();
                int width = driver.manage().window().getSize().getWidth();
                driver.swipe(width / 2, height * 2 / 3, width / 2, height / 3, 1000);
            }
            i++;
        }
        Assert.fail("Did not find : " + by.toString());
    }
}
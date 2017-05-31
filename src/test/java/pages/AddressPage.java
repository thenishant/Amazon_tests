package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressPage extends BasePage {

    public AddressPage(AppiumDriver driver) throws Exception {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "android.view.View")
    private WebElement fullPage;

    private By pincodeBy = By.id("enterAddressPostalCode");

    @FindBy(id = "enterAddressPostalCode")
    private WebElement pincodeEle;

    @FindBy(id = "enterAddressAddressLine1")
    private WebElement addressLine1;

    @FindBy(id = "enterAddressAddressLine2")
    private WebElement addressLine2;

    @FindBy(id = "enterAddressCity")
    private WebElement city;

    @FindBy(id = "enterAddressStateOrRegion")
    private WebElement state;

    @FindBy(id = "AddressType")
    private WebElement addressType;

    @FindBy(id = "android:id/text1")
    private List<WebElement> selectAddressType;

    @FindBy(className = "android.widget.Button")
    private List<WebElement> continueButton;

    public void enterShippingDetails() {
        waitForElementsToBeVisible(fullPage);
        if (isElementPresent(pincodeBy)) {
            waitForElementsToBeVisible(pincodeEle);
            pincodeEle.sendKeys("560007");
            hideKeyBoard();
            addressLine1.sendKeys("12/3");
            hideKeyBoard();
            addressLine2.sendKeys("IndraNagar");
            hideKeyBoard();
            city.sendKeys("Bangalore");
            hideKeyBoard();
            state.sendKeys("KARNATAKA");
            hideKeyBoard();
            swipeToElement(addressType);
            addressType.click();
            waitForElementsToBeVisible(selectAddressType);
            selectAddressType.get(1).click();
            waitForElementsToBeVisible(continueButton);
            swipeToElement(continueButton.stream().findFirst().get());
            continueButton.stream().findFirst().get().click();
        }
        else {
            waitForElementsToBeVisible(continueButton);
            continueButton.stream().findFirst().get().click();
        }
    }
}

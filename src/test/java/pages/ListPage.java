package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListPage extends BasePage {

    public ListPage(AppiumDriver driver) throws Exception {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By byPinCode = By.id("in.amazon.mShop.android.shopping:id/rs_location_data_city_pincode");

    @FindBy(id = "in.amazon.mShop.android.shopping:id/rs_location_data_city_pincode")
    private WebElement pincodeEle;

    @FindBy(id = "in.amazon.mShop.android.shopping:id/loc_ux_pin_code_button")
    private WebElement pinCodeButton;

    @FindBy(id = "in.amazon.mShop.android.shopping:id/loc_ux_pin_code_text")
    private WebElement pinCodeText;

    @FindBy(id = "in.amazon.mShop.android.shopping:id/loc_ux_update_pin_code")
    private WebElement appyPincode;

    @FindBy(id = "in.amazon.mShop.android.shopping:id/list_product_linear_layout")
    private List<WebElement> productList;

    protected void enterPinCode(String pincode) {
        waitForElementsToBeVisible(pincodeEle);
        if(pincodeEle.getText().equals("Select delivery location")) {
            pincodeEle.click();
            waitForElementsToBeVisible(pinCodeButton);
            pinCodeButton.click();
            waitForElementsToBeVisible(pinCodeText);
            pinCodeText.sendKeys(pincode);
            appyPincode.click();
        }
    }

    public void selectItem() {
        enterPinCode("560007");
        waitForElementsToBeVisible(productList);
        productList.stream().findFirst().get().click();
    }
}

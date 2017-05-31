package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BasePage {

    private AppiumDriver driver;

    public ProductPage(AppiumDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "title_feature_div")
    private List<WebElement> productName;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    @FindBy(id = "buyNowCheckout")
    private WebElement buyNowButton;

    @FindBy(id = "add-to-wishlist-button-submit")
    private WebElement addToGetCartELe;

    private By addToWishList = By.id("add-to-wishlist-button-submit");

    public void buyNow() {
        waitForElementsToBeVisible(productName);
        waitForElementsToBeVisible(buyNowButton);
        swipeToElement(buyNowButton);
        System.out.println("Clicking");
        buyNowButton.click();
    }


}

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

    private By addToWishList = By.id("add-to-wishlist-button-submit");

    public void buyNow(){
        waitForElementsToBeVisible(productName);
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
//
        driver.swipe(width / 2, height-100, width / 2, 450, 1000);
        waitForElementsToBeVisible(buyNowButton);
        System.out.println("Clicking");
        buyNowButton.click();
    }



}

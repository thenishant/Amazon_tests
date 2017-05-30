package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.RLogger;

import java.util.List;


public class HomePage extends BasePage{

    private AndroidDriver driver;
    private RLogger logger;
    public HomePage(AndroidDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        logger = new RLogger(this);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "in.amazon.mShop.android.shopping:id/sso_use_different_account")
    private WebElement useDifferentAccount;

    @FindBy(id = "gw-mobile-greeting-bar")
    private WebElement greetingBar;

    @FindBy(id = "in.amazon.mShop.android.shopping:id/rs_search_src_text")
    private WebElement searchItem;

    @FindBy(id = "in.amazon.mShop.android.shopping:id/rs_search_dropdown_item_suggestions")
    private List<WebElement> productList;

    public void searchItem(String itemName){
        waitForElementsToBeVisible(greetingBar);
        waitForElementsToBeVisible(searchItem);
        searchItem.click();
        waitForElementsToBeVisible(searchItem);
        searchItem.sendKeys(itemName);
        waitForElementsToBeVisible(productList);
        productList.get(0).click();
    }




}

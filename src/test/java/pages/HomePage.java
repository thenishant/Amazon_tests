package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.RLogger;


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

    public void login() {
        waitForElementToBeClickable(useDifferentAccount);
        useDifferentAccount.click();
    }
}

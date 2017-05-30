package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.RLogger;


public class LoginPage extends BasePage {

    private AndroidDriver driver;
    private RLogger logger;

    public LoginPage(AndroidDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger = new RLogger(this);
    }

    @FindBy(id = "login_accordion_header")
    private WebElement login;

    @FindBy(id = "ap_email_login")
    private WebElement email;

    @FindBy(id = "ap_password")
    private WebElement password;

    @FindBy(id = "signInSubmit")
    private WebElement loginButton;

    @FindBy(id = "in.amazon.mShop.android.shopping:id/sso_continue")
    private WebElement continueButton;

    public void existingLogin(){
        waitForElementsToBeVisible(continueButton);
        continueButton.click();
    }

    public void login(String emailID, String pass) {
        waitForElementsToBeVisible(login);
        login.click();
        logger.info("Choosing Login to Existing Customer");
        waitForElementsToBeVisible(email);
        email.sendKeys(emailID);
        hideKeyBoard();
        waitForElementsToBeVisible(password);
        password.sendKeys(pass);
        hideKeyBoard();
        waitForElementsToBeVisible(loginButton);
        loginButton.click();
    }
}

package Tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ListPage;
import pages.LoginPage;
import pages.ProductPage;

import java.net.MalformedURLException;

public class LoginTest  extends  BaseTest{

    LoginTest() throws MalformedURLException {
    }

    @Test
    private void SignIn() throws Exception {
        new LoginPage(driver).existingLogin();
        new HomePage(driver).searchItem("Hand Wash");
        new ListPage(driver).selectItem();
        new ProductPage(driver).buyNow();
    }

}

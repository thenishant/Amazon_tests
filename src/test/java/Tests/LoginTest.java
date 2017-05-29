package Tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTest  extends  BaseTest{

    LoginTest() throws MalformedURLException {
    }

    @Test
    private void SignIn() throws Exception {
        new HomePage(driver).login();
        new LoginPage(driver).existingLogin("DemoAccountForTesting@gmail.com","admin12345");
    }

}

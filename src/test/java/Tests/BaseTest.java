package Tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.AppiumServer;
import utils.DriverFactory;

public class BaseTest {

    AndroidDriver driver;
    DriverFactory driverFactory;
    AppiumServer appiumServer;

    BaseTest(){
    appiumServer = new AppiumServer();
    }

    @BeforeMethod(alwaysRun = true)
    public synchronized void setup() {
        appiumServer.start();
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
    }

    @AfterMethod()
    public synchronized void teardown() {
        driver.quit();
    }
}
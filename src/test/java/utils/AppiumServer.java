package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServer {
    private AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    public void start() {
        service.start();
    }

    public void stop() {
        service.stop();
    }
}

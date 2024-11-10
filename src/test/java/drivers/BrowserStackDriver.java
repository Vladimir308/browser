package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    @Getter
    private static final BrowserStackConfig browserStackConfig = ConfigFactory.create(BrowserStackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", browserStackConfig.username());
        caps.setCapability("browserstack.key", browserStackConfig.password());

        caps.setCapability("device", browserStackConfig.deviceName());
        caps.setCapability("os_version", browserStackConfig.platformVersion());
        caps.setCapability("app", browserStackConfig.appUrl());

        caps.setCapability("project", "Wikipedia Mobile Tests Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "wikipedia_tests");

        caps.setCapability("fullReset", true);

        try {
            return new RemoteWebDriver (
                    new URL(browserStackConfig.remoteWebDriverUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
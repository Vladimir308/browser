package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"
})
public interface BrowserStackConfig extends Config {

    @Key("remoteWebDriverUrl")
    String remoteWebDriverUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("device.name")
    String deviceName();

    @Key("platform.version")
    String platformVersion();

    @Key("appUrl")
    String appUrl();
}
package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties",
})
public interface LocalDeviceConfig extends Config {

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("appVersion")
    String getAppVersion();

    @Key("appUrl")
    String getAppUrl();

    @Key("appPath")
    String getAppPath();

    @Key("appiumServer")
    String getAppiumServer();
}
package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/local.properties"
})
public interface LocalConfig extends Config {

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("platform_version")
    String platformVersion();
}

package Config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:auth.properties",
        "classpath:mobile.properties"
})
public interface browserStackConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("apps")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("osVersion")
    String getOsVersion();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();
}

package qa.avasilev.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/remote.properties",
        "classpath:config/local.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue ("browserstack")
    String deviceHost();
    @DefaultValue("Google Pixel 4")
    String device();
    @DefaultValue("10.0")
    String osVersion();
    @DefaultValue("browserstack-build")
    String build();
    String browserstackUsername();
    String browserstackAccessKey();
    String emailAddress();
    String password();
    String serverUrl();


}

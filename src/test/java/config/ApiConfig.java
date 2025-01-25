package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${env}.properties",
        "classpath:properties/local.properties"
})
public interface ApiConfig extends Config {

    @Key("baseURI")
    String getBaseApiUri();

    @Key("basePath")
    @DefaultValue("/api")
    String getBasePath();
}
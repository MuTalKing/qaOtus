package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ServerConfig extends Config {
    @Key("otusURL")
    String otusURL();

    @Key("email")
    String email();

    @Key("password")
    String password();
}
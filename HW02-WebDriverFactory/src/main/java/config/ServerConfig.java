package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface ServerConfig extends Config {
    @Key("url")
    String url();

    @Key("title")
    String title();

    @Key("urlYandex")
    String urlYandex();

    @Key("titleYandex")
    String titleYandex();

    @Key("urlTele")
    String urlTele();
}
package otus;

import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class BaseSteps {

    public static WebDriver driverChrome;
    public static Logger log = LogManager.getLogger(BaseSteps.class);
    protected static Actions action;
    public static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);


    public BaseSteps driverSetUp() {
        WebDriverManager.chromedriver().setup();
        driverChrome = new ChromeDriver();
        action = new Actions(driverChrome);
        driverChrome.manage().window().maximize();
        driverChrome.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        log.info("Драйвер поднят");

        return this;
    }

    public BaseSteps openPage(String url){
        driverChrome.get(url);
        log.info(format("Открыта страница %s", url));

        return this;
    }

    public BaseSteps driverSetDown() {
        if (driverChrome != null) {
            driverChrome.quit();
        }
        log.info("Драйвер опущен");

        return this;
    }

    public BaseSteps refreshDriver(){
        driverChrome.quit();
        driverChrome = new ChromeDriver();
        action = new Actions(driverChrome);
        driverChrome.manage().window().maximize();
        driverChrome.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driverChrome.get(cfg.otusURL());
        log.info("Перезапускаем драйвер");

        return this;
    }


}

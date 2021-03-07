package ru.otus.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import ru.otus.config.ServerConfig;

import java.util.concurrent.TimeUnit;

public class BrowserHooks {

    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(BrowserHooks.class);
    protected static Actions action;
    public static ServerConfig config = ConfigFactory.create(ServerConfig.class);


    @Before
    public BrowserHooks driverSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        log.info("Драйвер поднят");

        return this;
    }

    @After
    public BrowserHooks driverSetDown(){
        if (driver != null) {
            driver.quit();
        }
        log.info("Драйвер опущен");

        return this;
    }
}

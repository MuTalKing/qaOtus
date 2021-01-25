import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class checkTitleYandexTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(checkTitleYandexTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void checkTitleYandex(){
        driver.get(cfg.urlYandex());
        logger.info("Открыта страница Яндекса");
        String actualTitle = driver.getTitle();
        logger.info("Проверяем соответствие title страницы");
        AssertionError assertionError = null;

        try{
            Assert.assertEquals(cfg.titleYandex(), actualTitle);
        }
        catch(AssertionError aEr){
            assertionError = aEr;
        }
        finally{
            if(assertionError == null){
                logger.info("Title страницы соответствует");
            }else{
                logger.error("Title страницы не соответствует");
                throw assertionError;
            }
        }


    }

    @After
    public void setDown(){
        if (driver != null){
            driver.quit();
        }
        logger.info("Драйвер опущен");
    }
}

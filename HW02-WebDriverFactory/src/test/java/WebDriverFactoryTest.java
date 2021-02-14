import config.Browsers;
import config.ServerConfig;
import config.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WebDriverFactoryTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(WebDriverFactoryTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        String browserName = System.getProperty("browser");
        driver = WebDriverFactory.createDriver(browserName);
        logger.info("Драйвер поднят");
    }

    @Test
    public void checkUrl(){
        driver.get(cfg.url());
        logger.info("Открыта страница Отуса");
        String actualUrl = driver.getCurrentUrl();
        logger.info("Проверяем соответствие URL страницы");
        AssertionError assertionError = null;

        try{
            Assert.assertEquals(cfg.url(), actualUrl);
        }
        catch(AssertionError aEr){
            assertionError = aEr;
        }
        finally{
            if(assertionError == null){
                logger.info("URL страницы соответствует");
            }else{
                logger.error("URL страницы не соответствует");
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
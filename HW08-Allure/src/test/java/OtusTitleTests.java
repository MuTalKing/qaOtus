import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OtusTitleTests {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(OtusTitleTests.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeAll
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @Step("Проверяем соответствие URL страницы")
    @Test
    public void checkUrl(){
        driver.get(cfg.url());
        logger.info("Открыта страница Отуса");
        String actualUrl = driver.getCurrentUrl();
        logger.info("Проверяем соответствие URL страницы");
        AssertionError assertionError = null;

        try{
            Assertions.assertEquals(actualUrl, cfg.url());
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
        Allure.addAttachment("OSinOnComparisonPage", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("Проверяем соответствие title страницы")
    @Test
    public void checkTitle(){
        driver.get(cfg.url());
        logger.info("Открыта страница Отуса");
        String actualTitle = driver.getTitle();
        logger.info("Проверяем соответствие title страницы");
        AssertionError assertionError = null;

        try{
            Assertions.assertEquals(actualTitle, cfg.title());
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
        Allure.addAttachment("OSinOnComparisonPage", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

    }

    @AfterAll
    public void setDown(){
        if (driver != null){
            driver.quit();
        }
        logger.info("Драйвер опущен");
    }
}

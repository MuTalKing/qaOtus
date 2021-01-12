import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class otusTitleTests {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(otusTitleTests.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @Test
    public void checkUrl(){
        driver.get(cfg.url());
        logger.info("Открыта страница Отуса");
        String actualUrl = driver.getCurrentUrl();
        logger.info("Проверяем соответствие URL страницы");
        if(!actualUrl.equals(cfg.url())){
            logger.error("URL страницы не соответствует");
        }
        else {
            logger.info("URL страницы соответствует");
        }
    }

    @Test
    public void checkTitle(){
        driver.get(cfg.url());
        logger.info("Открыта страница Отуса");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        logger.info("Проверяем соответствие title страницы");
        if(!actualTitle.equals(expectedTitle)){
            logger.error("Title страницы не соответствует");
        }
        else {
            logger.info("Title страницы соответствует");
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

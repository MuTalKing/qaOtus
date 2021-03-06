import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchTeleNumberTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SearchTeleNumberTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeAll
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @Test
    public void searchNumber(){
        driver.get(cfg.urlTele());
        WebElement searchField = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("searchNumber")));
        logger.info("Открыта страница поиска номеров Теле");
        logger.info("Вводим в строку поиска нужный нам номер и дожидаемся появления номеров");
        searchField.sendKeys("97");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className("area-code")));

        AssertionError assertionError = null;

        try{
            Assertions.assertNotNull(driver.findElement(By.className("area-code")));
        }
        catch(AssertionError aEr){
            assertionError = aEr;
        }
        finally{
            if(assertionError == null){
                logger.info("На экран выведен список нужных нам номеров");
            }else{
                logger.error("На экран не выведен список нужных нам номеров");
                throw assertionError;
            }
        }
    }

    @AfterAll
    public void setDown(){
        if (driver != null){
            driver.quit();
        }
        logger.info("Драйвер опущен");
    }
}

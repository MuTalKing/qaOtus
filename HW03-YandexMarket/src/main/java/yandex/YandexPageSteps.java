package yandex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class YandexPageSteps {
    protected static WebDriver driver;
    protected static Actions action;
    private static Logger log = LogManager.getLogger(YandexPageSteps.class);

    public static void driverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        log.info("Драйвер поднят");
    }

    public static void openPage(String url) {
        driver.get(url);
        if(isElementPresent(YandexPageObject.closeTip())){
            click(YandexPageObject.closeTip());
        }
        log.info(format("Открыта страница %s", url));
    }

    public static void driverSetDown() {
        if (driver != null) {
            driver.quit();
        }
        log.info("Драйвер опущен");
    }

    public static void click(By pageObject) {
        driver.findElement(pageObject).click();
    }

    public static void selectSection(String section) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(YandexPageObject.section(section)));
        click(YandexPageObject.section(section));
        log.info(format("Выбираем раздел %s", section));
    }

    public static void selectSubSection(String subSection) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(YandexPageObject.subSection(subSection)));
        click(YandexPageObject.subSection(subSection));
        log.info(format("Выбираем подраздел %s", subSection));
    }

    public static void selectPhoneProducer(String phoneProducer) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(YandexPageObject.selectProducer(phoneProducer)));
        click(YandexPageObject.selectProducer(phoneProducer));
        log.info(format("Выбираем производителя %s", phoneProducer));
    }

    public static void sortBy(String sortMethod) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(YandexPageObject.sortBy(sortMethod)));
        click(YandexPageObject.sortBy(sortMethod));
        log.info(format("Сортируем %s", sortMethod));
    }

    public static void addFirstProducerPhoneToComparison(String producerName) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-apiary-widget-id='/content/results']/div/div[2]")));
        WebElement button = (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath(format("//div[@data-zone-name='SearchResults']//article//a[contains(@title, '%s')]",producerName))));
        action.moveToElement(button).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(YandexPageObject.addFirstProducerPhoneToComparisonButton(producerName))).click();
        log.info(format("Добавляем первый телефон %s в сравнение", producerName));
    }

    protected static boolean isElementPresent(By tip) {
        try {
            driver.findElement(tip);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public static void verifyProductName(String producerName){
        String productName = driver.findElement(YandexPageObject.productName(producerName)).getAttribute("title");
        String productNameInPopUp = driver.findElement(YandexPageObject.popUpInformer()).getText();
        Assertions.assertEquals(format("Товар %s добавлен к сравнению", productName), productNameInPopUp);
        log.info(format("Товар %s успешно добавлен к сравнению", productName));
    }

    public static void moveToComparisonPage(){
        WebElement comparisonButton = (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(YandexPageObject.comparisonButton()));
        JavascriptExecutor jsexecutor = (JavascriptExecutor)driver; // Через обычный клик не получается кликнуть на кнопку - в гугле пишут, что это баг вебдрайвера
        jsexecutor.executeScript("arguments[0].click();", comparisonButton);
        log.info("Переходим на страницу сравнения");
    }

    public static void verifyProductsCount(int productsCount){
        int productsCountInCamparison = driver.findElements(YandexPageObject.deleteButton()).size();
        Assertions.assertEquals(productsCount,productsCountInCamparison);
        log.info(format("Убеждаемся, что на странице сравнения %s товаров", productsCount));
    }
}

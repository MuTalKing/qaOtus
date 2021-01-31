import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import yandex.YandexPageSteps;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class YandexMarket {
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeAll
    public void setUp() {
        YandexPageSteps.driverSetUp();
    }

    @Test
    public void comparisonOfPhones(){
        YandexPageSteps.openPage(cfg.urlYandex());
        YandexPageSteps.selectSection("Электроника");
        YandexPageSteps.selectSubSection("Смартфоны");
        YandexPageSteps.selectPhoneProducer("Samsung");
        YandexPageSteps.selectPhoneProducer("Xiaomi");
        YandexPageSteps.sortBy("по цене");
        YandexPageSteps.addFirstProducerPhoneToComparison("Samsung");
        YandexPageSteps.verifyProductName("Samsung");
        YandexPageSteps.addFirstProducerPhoneToComparison("Xiaomi");
        YandexPageSteps.verifyProductName("Xiaomi");
        YandexPageSteps.moveToComparisonPage();
        YandexPageSteps.verifyProductsCount(2);
    }

    @AfterAll
    public void setDown(){
        YandexPageSteps.driverSetDown();
    }
}

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import otus.OtusPage;
import static otus.BaseSteps.cfg;

import static otus.BaseSteps.log;
import static otus.PageObject.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OtusTest {
    String facebook="gogolev";
    String vk="gogolev";

    @BeforeAll
    public void setUp(){
        baseSteps.driverSetUp();
    }

    @Test
    public void otusTest(){
        baseSteps.openPage(cfg.otusURL());
        loginPage.clickAuthorizationButton()
                 .filLoginField(cfg.email())
                 .filPasswordField(cfg.password())
                 .clickLoginButton();
        otusPage.openPersonalSettings()
                .setInformationAndSave();
        baseSteps.refreshDriver();
        loginPage.clickAuthorizationButton()
                .filLoginField(cfg.email())
                .filPasswordField(cfg.password())
                .clickLoginButton();
        otusPage.openPersonalSettings();
        log.info("Проверяем, что все наши данные сохранились");
        Assertions.assertEquals(facebook, otusPage.getFacebookField());
        Assertions.assertEquals(vk, otusPage.getVKField());
    }

    @AfterAll
    public void setDown(){
        baseSteps.driverSetDown();
    }
}

package ru.otus.steps;

import io.cucumber.java.ru.Когда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.otus.page.MainPage;

import static java.lang.String.format;
import static ru.otus.hooks.BrowserHooks.driver;
import static ru.otus.hooks.BrowserHooks.log;

public class MainPageStepDefs {

    private MainPage mainPage = new MainPage();

    @Когда("^Открыта страница '(.*)'$")
    public void openMainPage(String url){
        driver.get(url);
        log.info(format("Открыта страница %s", url));
    }

    @Когда("^Заголовок страницы звучит как '(.*)'$")
    public void checkTitle(String title){
        Assertions.assertEquals(driver.getTitle(), title);
        log.info(format("Проверяем, что заголовок сайта совпадает с %s", title));
    }

    @Когда("^Переходим в раздел '(.*)'$")
    public void goToTopic(String topicName){
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(mainPage.topic(topicName)));
        driver.findElement(mainPage.topic(topicName)).click();
        log.info(format("Переходим в раздел '%s'", topicName));
    }

    @Когда("^Количество курсов равно (.*)$")
    public void checkCountCourses(String count){
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(mainPage.courses(count)));
        mainPage.isCountTrue(count);
        log.info(format("Проверяем, что количество курсов равно %s", count));
    }

}

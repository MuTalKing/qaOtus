package ru.otus.steps;

import io.cucumber.java.ru.Когда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.otus.page.MainPage;

import static ru.otus.hooks.BrowserHooks.driver;
import static ru.otus.hooks.BrowserHooks.log;

public class MainPageStepDefs {

    private MainPage mainPage = new MainPage();

    @Когда("^Открыта страница '(.*)'$")
    public void openMainPage(String url){
        driver.get(url);
        log.info("Открыта страница {}", url);
    }

    @Когда("^Заголовок страницы звучит как '(.*)'$")
    public void checkTitle(String title){
        Assertions.assertEquals(driver.getTitle(), title);
        log.info("Проверяем, что заголовок сайта совпадает с {}", title);
    }

    @Когда("^Переходим в раздел '(.*)'$")
    public void goToTopic(String topicName){
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(mainPage.topic(topicName)));
        driver.findElement(mainPage.topic(topicName)).click();
        log.info("Переходим в раздел '{}'", topicName);
    }

    @Когда("^Количество курсов равно (.*)$")
    public void checkCountCourses(String count){
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(mainPage.coursesCount));
        String text = driver.findElement(mainPage.coursesCount).getText();
        Assertions.assertEquals("Курсов: " + count, text);
        log.info("Проверяем, что количество курсов равно {}", count);
    }

}

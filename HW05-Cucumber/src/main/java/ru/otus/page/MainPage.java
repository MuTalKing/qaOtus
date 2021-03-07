package ru.otus.page;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

import static java.lang.String.format;
import static ru.otus.hooks.BrowserHooks.driver;

@Component
public class MainPage {

    public By topic(String topicName){
        return By.xpath(format("//div[@class='nav__scroll course-categories__nav-box']//a[@title='%s']", topicName));
    }

    public By courses(String count){
        return By.xpath(format("//div[@class='title-new__info-item'][text()='Курсов: %s']", count));
    }

    public boolean isCountTrue(String count){
        try {
            driver.findElement(courses(count));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }






}

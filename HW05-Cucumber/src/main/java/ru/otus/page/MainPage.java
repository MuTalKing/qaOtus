package ru.otus.page;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class MainPage {

    public By topic(String topicName){
        return By.xpath(format("//div[@class='nav__scroll course-categories__nav-box']//a[@title='%s']", topicName));
    }

    public By courses(String count){
        return By.xpath(format("//div[@class='title-new__info-item'][text()='Курсов: %s']", count));
    }

    public By coursesCount = By.className("title-new__info-item");
}

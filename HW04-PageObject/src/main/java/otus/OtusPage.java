package otus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static otus.BaseSteps.log;
import static otus.BaseSteps.action;
import static otus.BaseSteps.driverChrome;

public class OtusPage {

    By userField = By.xpath("//div[@class='header2-menu__item-wrapper header2-menu__item-wrapper__username']");
    By myProfile = By.xpath("//b[@class='header2-menu__dropdown-text_name'][text()='Сергей Гоголев']");
    By contactField = By.xpath("//div[@class='input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation']");
    By facebookButton = By.xpath("//button[@title='Facebook']");
    By facebookField = By.xpath("//input[@name='contact-0-value']");
    By vkButton = By.xpath("//div[@data-num='1']//button[@title='VK']");
    By vkField = By.xpath("//input[@name='contact-1-value']");
    By secondContactField = By.xpath("//div[@data-num='1']//div[@class='input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation']");
    By addButton = By.xpath("//button[@type='button'][text()='Добавить']");
    By saveButton = By.xpath("//button[@title='Сохранить и продолжить']");



    public OtusPage openPersonalSettings(){
        WebElement userFieldElement = new WebDriverWait(driverChrome,10).until(ExpectedConditions.presenceOfElementLocated(userField));
        action.moveToElement(userFieldElement).build().perform();
        new WebDriverWait(driverChrome,10).until(ExpectedConditions.presenceOfElementLocated(myProfile)).click();
        log.info("Открываем 'Мой профиль'");

        return this;
    }

    public OtusPage setInformationAndSave(){
        new WebDriverWait(driverChrome,10).until(ExpectedConditions.presenceOfElementLocated(contactField)).click();
        WebElement telegramButtonElement = new WebDriverWait(driverChrome,10).until(ExpectedConditions.elementToBeClickable(facebookButton));
        telegramButtonElement.click();
        new WebDriverWait(driverChrome,10).until(ExpectedConditions.presenceOfElementLocated(facebookField)).sendKeys("gogolev");
        log.info("Указываем контакт Фейсбука");
        new WebDriverWait(driverChrome,10).until(ExpectedConditions.presenceOfElementLocated(addButton)).click();
        new WebDriverWait(driverChrome,10).until(ExpectedConditions.presenceOfElementLocated(secondContactField)).click();
        new WebDriverWait(driverChrome,10).until(ExpectedConditions.presenceOfElementLocated(vkButton)).click();
        new WebDriverWait(driverChrome,10).until(ExpectedConditions.presenceOfElementLocated(vkField)).sendKeys("gogolev");
        log.info("Указываем контакт ВК");
        new WebDriverWait(driverChrome,10).until(ExpectedConditions.presenceOfElementLocated(saveButton)).click();
        log.info("Сохраняем данные");

        return this;
    }



    public String getFacebookField(){
        return driverChrome.findElement(facebookField).getAttribute("value");
    }

    public String getVKField(){
        return driverChrome.findElement(vkField).getAttribute("value");
    }




}

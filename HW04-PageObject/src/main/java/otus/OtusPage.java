package otus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static otus.BaseSteps.log;
import static otus.BaseSteps.action;
import static otus.BaseSteps.driverChrome;

public class OtusPage {

    private By userField = By.xpath("//div[@class='header2-menu__item-wrapper header2-menu__item-wrapper__username']");
    private By myProfile = By.xpath("//b[@class='header2-menu__dropdown-text_name'][text()='Сергей Гоголев']");
    private By contactField = By.xpath("//div[@class='input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation']");
    private By facebookButton = By.xpath("//button[@title='Facebook']");
    private By facebookField = By.xpath("//input[@name='contact-0-value']");
    private By vkButton = By.xpath("//div[@data-num='1']//button[@title='VK']");
    private By vkField = By.xpath("//input[@name='contact-1-value']");
    private By secondContactField = By.xpath("//div[@data-num='1']//div[@class='input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation']");
    private By addButton = By.xpath("//button[@type='button'][text()='Добавить']");
    private By saveButton = By.xpath("//button[@title='Сохранить и продолжить']");

    public WebElement getElement(By locator){
        return new WebDriverWait(driverChrome, 10).until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public OtusPage openPersonalSettings(){
        action.moveToElement(getElement(userField)).build().perform();
        getElement(myProfile).click();
        log.info("Открываем 'Мой профиль'");

        return this;
    }

    public OtusPage setInformationAndSave(){
        getElement(contactField).click();
        getElement(facebookButton).click();
        getElement(facebookField).sendKeys("gogolev");
        log.info("Указываем контакт Фейсбука");
        getElement(addButton).click();
        getElement(secondContactField).click();
        getElement(vkButton).click();
        getElement(vkField).sendKeys("gogolev");
        log.info("Указываем контакт ВК");
        getElement(saveButton).click();
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

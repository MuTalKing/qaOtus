package ru.otus.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import static ru.otus.hooks.BrowserHooks.driver;
import static ru.otus.hooks.BrowserHooks.log;

@Component
public class LoginPage {

    private By authorizationButton = By.xpath("//button[contains(@class,'js-open-modal')]");
    private By loginField = By.xpath("//input[contains(@class, 'js-email-input')]");
    private By passwordField = By.xpath("//input[contains(@class, 'js-psw-input')]");
    private By loginButton = By.xpath("//button[contains(@class, 'new-button_md')]");

    public WebElement getElement(By locator){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public LoginPage clickAuthorizationButton(){
        getElement(authorizationButton).click();
        log.info("Нажимаем на кнопку 'Войти'");

        return this;
    }

    public LoginPage filLoginField(String email){
        getElement(loginField).sendKeys(email);
        log.info("Вводим email");

        return this;
    }

    public LoginPage filPasswordField(String password){
        getElement(passwordField).sendKeys(password);
        log.info("Вводим пароль");

        return this;
    }

    public LoginPage clickLoginButton(){
        getElement(loginButton).click();
        log.info("Входим под своей учетной записью");

        return this;
    }




}

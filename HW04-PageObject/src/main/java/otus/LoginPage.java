package otus;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static otus.BaseSteps.driverChrome;
import static otus.BaseSteps.log;

public class LoginPage {

    By authorizationButton = By.xpath("//button[contains(@class,'js-open-modal')]");
    By loginField = By.xpath("//input[contains(@class, 'js-email-input')]");
    By passwordField = By.xpath("//input[contains(@class, 'js-psw-input')]");
    By loginButton = By.xpath("//button[contains(@class, 'new-button_md')]");

    public LoginPage clickAuthorizationButton(){
        new WebDriverWait(driverChrome, 10).until(ExpectedConditions.presenceOfElementLocated(authorizationButton)).click();
        log.info("Нажимаем на кнопку 'Войти'");

        return this;
    }

    public LoginPage filLoginField(String email){
        new WebDriverWait(driverChrome, 10).until(ExpectedConditions.presenceOfElementLocated(loginField)).sendKeys(email);
        log.info("Вводим email");

        return this;
    }

    public LoginPage filPasswordField(String password){
        new WebDriverWait(driverChrome, 10).until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
        log.info("Вводим пароль");

        return this;
    }

    public LoginPage clickLoginButton(){
        new WebDriverWait(driverChrome, 10).until(ExpectedConditions.presenceOfElementLocated(loginButton)).click();
        log.info("Входим под своей учетной записью");

        return this;
    }


}

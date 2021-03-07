package ru.otus.steps;

import io.cucumber.java.ru.Когда;
import ru.otus.page.LoginPage;

import static ru.otus.hooks.BrowserHooks.config;

public class LoginPageStepDefs {


    private LoginPage loginPage = new LoginPage();

    @Когда("^Нажимаем на кнопку 'Вход и регистрация'$")
    public void clickAuthorizationButton(){
        loginPage.clickAuthorizationButton();
    }

    @Когда("^Заполняем поле email - (.*)$")
    public void filLoginField(String email){
        loginPage.filLoginField(email);
    }

    @Когда("^Вводим пароль - (.*)$")
    public void filPasswordField(String password){
        loginPage.filPasswordField(password);
    }

    @Когда("^Нажимаем на кнопку 'Войти'$")
    public void clickLoginButton(){
        loginPage.clickLoginButton();
    }

    @Когда("^Авторизуемся на сайте под тестовым пользователем$")
    public void authorization(){
        loginPage.clickAuthorizationButton();
        loginPage.filLoginField(config.email());
        loginPage.filPasswordField(config.password());
        loginPage.clickLoginButton();
    }
}

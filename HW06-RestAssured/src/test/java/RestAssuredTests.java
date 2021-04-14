import org.junit.jupiter.api.Test;

public class RestAssuredTests {

    @Test
    public void checkCreationUser(){
        UserCreationSteps userCreationSteps = new UserCreationSteps();
        userCreationSteps.createUser1(); //Создаем первого пользователя
        userCreationSteps.createUser2(); //Создаем второго пользователя без почты, телефона и статуса
        userCreationSteps.gettingUser1ByName(); //Проверяем, что сваггер успешно возвращает нам первого пользователя
        userCreationSteps.negativeGettingUserByName(); //Негативный сценарий - проверяем, что он выдает ошибку, если запросить у него какого-то неизвестного пользователя
    }


}

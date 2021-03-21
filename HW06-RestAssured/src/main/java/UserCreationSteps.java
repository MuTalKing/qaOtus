import static org.hamcrest.Matchers.equalTo;

public class UserCreationSteps {

    public UserCreationSteps createUser1(){
        UserApi userApi = new UserApi();
        userApi.createUser(UserBuilder.user1)
                .then()
                .spec(Specification.responseSpec)
                .body("message", equalTo("10"));

        return this;
    }

    public UserCreationSteps createUser2(){
        UserApi userApi = new UserApi();
        userApi.createUser(UserBuilder.user2)
                .then()
                .spec(Specification.responseSpec)
                .body("message", equalTo("11"));

        return this;
    }

    public UserCreationSteps gettingUser1ByName(){
        UserApi userApi = new UserApi();
        userApi.getUserByName(UserBuilder.user1.getUsername())
                .then()
                .spec(Specification.responseSpec)
                .body("firstName", equalTo(UserBuilder.user1.getFirstName()));

        return this;
    }

    public UserCreationSteps negativeGettingUserByName(){
        UserApi userApi = new UserApi();
        userApi.getUserByName("asdxcwdasd")
                .then()
                .statusCode(404)
                .body("message", equalTo("User not found"));

        return this;
    }
}

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {
    private static final String PATH_USER_CREATION = "/user";
    private static final String PATH_USER_GETTER = "/user/{username}";

    public Response createUser(User user){
        return
                given(Specification.requestSpec)
                        .body(user)
                        .basePath(PATH_USER_CREATION)
                        .when()
                        .post();
    }

    public Response getUserByName(String username){
        return
                given(Specification.requestSpec)
                .basePath(PATH_USER_GETTER)
                .pathParam("username", username)
                .accept(ContentType.JSON)
                .when()
                .get();
    }

}

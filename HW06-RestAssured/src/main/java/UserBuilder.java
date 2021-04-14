public class UserBuilder {

    public static User user1 = User.builder()
            .email("email")
            .firstName("FirstName")
            .id(10L)
            .lastName("LastName")
            .password("Password")
            .phone("77777777777")
            .username("UserName")
            .userStatus(10L)
            .build();

    public static User user2 = User.builder()
            .firstName("FirstName1")
            .id(11L)
            .lastName("LastName1")
            .password("Password1")
            .username("UserName1")
            .build();
}

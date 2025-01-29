package Services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import modules.DataBaseProcessor.DataBaseConnectionManager.DatabaseConnectionManager;
import modules.Entities.User.User;
import modules.DataBaseProcessor.Services.UserService.UserService;
import org.hibernate.Session;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

public class UserServiceTest {

    private static User expectedUser = new User();

    @BeforeAll
    public static void initTestData() {
        expectedUser.setName("stos");
        expectedUser.setLogin("sto");
        expectedUser.setPassword("dva");
        expectedUser.setID(1);
    }


    @Test
    @Tag("loginTest")
    @Tag("UserServiceTest")
    @Tag("ExpectedSuccess")
    public void loginTest() {
        User testUser = UserService.login("sto", "dva");
        Assertions.assertEquals(expectedUser, testUser, "should be the same");
    }

    @Test
    @Tag("loginTest")
    @Tag("UserServiceTest")
    @Tag("ExpectedFail")
    public void loginTest_FalseLogin() {
        User testUser = UserService.login("stos", "dva");
        Assertions.assertNull(testUser, "should be null");
    }

    @Test
    @Tag("loginTest")
    @Tag("UserServiceTest")
    @Tag("ExpectedFail")
    public void loginTest_FalsePassword() {
        User testUser = UserService.login("sto", "odin");
        Assertions.assertNull(testUser, "should be null");
    }

    @Test
    @Tag("registerTest")
    @Tag("UserServiceTest")
    @Tag("ExpectedFail")
    public void registerTest_Failed1() {
        boolean result = UserService.register("sto", "dva");
        Assertions.assertFalse(result, "should be false");
    }

    @Test
    @Tag("registerTest")
    @Tag("UserServiceTest")
    @Tag("ExpectedFail")
    public void registerTest_Failed2() {
        boolean result = UserService.register("sto", "dvach");
        Assertions.assertFalse(result, "should be false");
    }

}

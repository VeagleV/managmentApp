package DataBase;

import static org.mockito.Mockito.*;

import modules.DataBaseProcessor.DataAccess.UserDataAccess.UserDataAccess;
import modules.Entities.User.User;
import org.junit.jupiter.api.*;

public class UserDataAccessTest {

    private static UserDataAccess userDataAccess = new UserDataAccess();
    private static User expectedUser = new User();

    @BeforeAll
    public static void initTestData() {
        expectedUser.setName("stos");
        expectedUser.setLogin("sto");
        expectedUser.setPassword("dva");
        expectedUser.setID(1);
    }

    @Test
    @Tag("getByLoginAndPasswordTest")
    @Tag("UserDataAccessTest")
    @Tag("ExpectedSuccess")
    public void getByLoginAndPasswordTest() {
        User testUser = userDataAccess.getByLoginAndPassword("sto", "dva");
        Assertions.assertEquals(expectedUser, testUser, "should be the same");
    }

    @Test
    @Tag("getByLoginAndPasswordTest")
    @Tag("UserDataAccessTest")
    @Tag("ExpectedFail")
    public void getByLoginAndPasswordTest_Fail_LoginAndPassword() {
        User testUser = userDataAccess.getByLoginAndPassword("stos1", "dvach");
        Assertions.assertNull(testUser, "should be null");
    }

    @Test
    @Tag("getByLoginAndPasswordTest")
    @Tag("UserDataAccessTest")
    @Tag("ExpectedFail")
    public void getByLoginAndPasswordTest_Fail_Login() {
        User testUser = userDataAccess.getByLoginAndPassword("stos1", "dva");
        Assertions.assertNull(testUser, "should be null");
    }

    @Test
    @Tag("getByLoginAndPasswordTest")
    @Tag("UserDataAccessTest")
    @Tag("ExpectedFail")
    public void getByLoginAndPasswordTest_Fail_Password() {
        User testUser = userDataAccess.getByLoginAndPassword("stos", "dvach");
        Assertions.assertNull(testUser, "should be null");
    }

    @Test
    @Tag("getByLoginTest")
    @Tag("UserDataAccessTest")
    @Tag("ExpectedSuccess")
    public void getByLoginTest() {
        User testUser = userDataAccess.getByLogin("sto");
        Assertions.assertEquals(expectedUser, testUser, "should be the same");
    }

    @Test
    @Tag("getByLoginTest")
    @Tag("UserDataAccessTest")
    @Tag("ExpectedFail")
    public void getByLoginTest_Fail() {
        User testUser = userDataAccess.getByLogin("stos");
        Assertions.assertNull(testUser, "should be null");
    }

}

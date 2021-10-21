package tests.ui.login;

import org.testng.annotations.Test;
import tests.ui.BaseTest;

public class LoginPageTests extends BaseTest {

    @Test(description = "Verifying that user can login with existing credits")
    public void verifyUserCanLoginWithExistingCredits() {
        loginPageSteps
                .login(TEST_USER_EMAIL, TEST_USER_PASSWORD)
                .isLoginSuccessful();
    }
}

package tests.ui.login;

import configurations.RetryAnalyzer;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import utils.AllureUtils;

public class LoginPageTests extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Verifying that user can login with existing credits")
    public void verifyUserCanLoginWithExistingCredits() {
        loginPageSteps.login(USERNAME,PASSWORD);
        AllureUtils.takeScreenshot();
    }
}

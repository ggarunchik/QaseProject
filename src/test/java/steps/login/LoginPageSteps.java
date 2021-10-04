package steps.login;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import pageobjects.login.LoginPage;
import pageobjects.projects.ProjectsPage;

@Log4j2
public class LoginPageSteps {

    private final LoginPage loginPage;
    private final ProjectsPage projectsPage;

    public LoginPageSteps() {
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
    }

    @Step("Logging with credits: Email: {userEmail} Password: {userPassword}")
    public LoginPageSteps login(String userEmail, String userPassword) {
        log.info("Entering user email: {} and password: {}", userEmail, userPassword);
        loginPage
                .openLoginPage()
                .enterUserEmail(userEmail)
                .enterUserPassword(userPassword)
                .clickLoginButton();
        return this;
    }

    public LoginPageSteps isLoginSuccessful() {
        log.info("Check is login successful");
        Assert.assertTrue(projectsPage.isPageOpened(), "Login is not successful");
        return this;
    }
}

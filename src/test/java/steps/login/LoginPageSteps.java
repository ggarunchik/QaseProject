package steps.login;

import io.qameta.allure.Step;
import pageobjects.login.LoginPage;
import pageobjects.projects.ProjectsPage;

public class LoginPageSteps {

    private final LoginPage loginPage;
    private final ProjectsPage projectsPage;

    public LoginPageSteps() {
       loginPage = new LoginPage();
       projectsPage = new ProjectsPage();
    }

    @Step("Logging with credits: Email: {userEmail} Password: {userPassword}")
    public LoginPageSteps login(String userEmail, String userPassword) {
        loginPage
                .openLoginPage()
                .isPageOpened()
                .enterUserEmail(userEmail)
                .enterUserPassword(userPassword)
                .clickLoginButton();
        projectsPage.isPageOpened();
        return this;
    }
}

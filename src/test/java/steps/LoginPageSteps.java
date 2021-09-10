package steps;

import pages.loginPage.LoginPage;
import pages.projectsPage.ProjectsPage;

public class LoginPageSteps {

    private final LoginPage loginPage;
    private final ProjectsPage projectsPage;

    public LoginPageSteps() {
       loginPage = new LoginPage();
       projectsPage = new ProjectsPage();
    }

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

package tests.ui;

import com.codeborne.selenide.Configuration;
import configurations.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.login.LoginPageSteps;
import steps.projects.ProjectsPageSteps;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    protected LoginPageSteps loginPageSteps;
    protected ProjectsPageSteps projectsPageSteps;

    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");

    @BeforeMethod
    public void setupBrowser() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        loginPageSteps = new LoginPageSteps();
        projectsPageSteps = new ProjectsPageSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }
}

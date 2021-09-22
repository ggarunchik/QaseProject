package tests.ui;

import com.codeborne.selenide.Configuration;
import configurations.TestListener;
import models.factory.newprojectfactory.NewProjectFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import steps.login.LoginPageSteps;
import steps.projects.ProjectsPageSteps;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    protected LoginPageSteps loginPageSteps;
    protected ProjectsPageSteps projectsPageSteps;
    protected NewProjectFactory newProjectFactory;

    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected final String USERNAME = propertyReader.getPropertyValueByKey("username");
    protected final String PASSWORD = propertyReader.getPropertyValueByKey("password");

    @BeforeMethod
    public void setupBrowser() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        loginPageSteps = new LoginPageSteps();
        projectsPageSteps = new ProjectsPageSteps();
        newProjectFactory = new NewProjectFactory();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }
}

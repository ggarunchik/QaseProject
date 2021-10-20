package tests.ui;

import com.codeborne.selenide.Configuration;
import configurations.Highlighter;
import models.factory.newprojectfactory.ProjectFactory;
import models.factory.newtestcasefactory.TestCaseFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.project.DeleteTestModalPage;
import pageobjects.project.EditTestCasePage;
import pageobjects.project.ProjectPage;
import pageobjects.project.TestCaseInfoPage;
import pageobjects.testplan.CreateTestPlanPage;
import pageobjects.testplan.SelectTestCasesPage;
import pageobjects.testplan.TestPlanPage;
import steps.login.LoginPageSteps;
import steps.project.ProjectPageSteps;
import steps.projects.ProjectsPageSteps;
import steps.testplan.TestPlanSteps;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    protected LoginPageSteps loginPageSteps;
    protected ProjectsPageSteps projectsPageSteps;
    protected ProjectFactory newProjectFactory;
    protected TestCaseFactory testCaseFactory;
    protected ProjectPage projectPage;
    protected ProjectPageSteps projectPageSteps;
    protected EditTestCasePage editTestCasePage;
    protected DeleteTestModalPage deleteTestModalPage;
    protected TestCaseInfoPage testCaseInfoPage;
    protected TestPlanSteps testPlanSteps;

    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected final String USERNAME = propertyReader.getPropertyValueByKey("username");
    protected final String PASSWORD = propertyReader.getPropertyValueByKey("password");
    protected final String PROJECT_CODE = propertyReader.getPropertyValueByKey("test_project_code");
    public final static String TEST_USER_EMAIL = System.getenv("username");
    public final static String TEST_USER_PASSWORD = System.getenv("password");

    @BeforeMethod
    public void setupBrowser() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 8000;
        Configuration.pageLoadTimeout = 90000;
        Configuration.browser = "chrome";
        Configuration.clickViaJs = false;
        addListener(new Highlighter());
        loginPageSteps = new LoginPageSteps();
        projectsPageSteps = new ProjectsPageSteps();
        newProjectFactory = new ProjectFactory();
        testCaseFactory = new TestCaseFactory();
        projectPage = new ProjectPage();
        projectPageSteps = new ProjectPageSteps();
        editTestCasePage = new EditTestCasePage();
        deleteTestModalPage = new DeleteTestModalPage();
        testCaseInfoPage = new TestCaseInfoPage();
        testPlanSteps = new TestPlanSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }
}

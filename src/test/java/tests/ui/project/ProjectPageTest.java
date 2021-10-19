package tests.ui.project;

import models.project.testcase.TestCase;
import org.testng.annotations.Test;
import tests.ui.BaseTest;

public class ProjectPageTest extends BaseTest {

    @Test(description = "Verify CRUD for test case")
    public void verifyCRUDforTestCase() {
        TestCase testCase = testCaseFactory.generateRandomTestCase();
        TestCase editedTestCase = testCaseFactory.generateRandomTestCase();
        loginPageSteps
                .login(USERNAME, PASSWORD);
        projectsPageSteps
                .openProject("glebTest");
        projectPageSteps
                .createNewTestCase(testCase)
                .editTestCase(testCase.getTitle(), editedTestCase)
                .deleteTestCase(editedTestCase.getTitle());
    }

    @Test(description = "Verify test could be added to a suite")
    public void verifyTestCouldBeAddedToSuite() {
        TestCase testCase = testCaseFactory.generateRandomTestCase();
        loginPageSteps
                .login(USERNAME, PASSWORD);
        projectsPageSteps
                .openProject("glebTest");
        projectPageSteps
                .createNewTestCase(testCase,"Test Suite #1 (autotest)");
    }
}

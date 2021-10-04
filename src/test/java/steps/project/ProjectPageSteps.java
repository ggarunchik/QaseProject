package steps.project;

import io.qameta.allure.Step;
import models.project.testcase.TestCase;
import org.testng.Assert;
import pageobjects.project.CreateTestCasePage;
import pageobjects.project.DeleteTestModalPage;
import pageobjects.project.ProjectPage;
import pageobjects.project.TestCaseInfoPage;

public class ProjectPageSteps {

    private ProjectPage projectPage;
    private CreateTestCasePage createTestCasePage;
    private TestCaseInfoPage testCaseInfoPage;
    private DeleteTestModalPage deleteTestModalPage;

    public ProjectPageSteps() {
        projectPage = new ProjectPage();
        createTestCasePage = new CreateTestCasePage();
        testCaseInfoPage = new TestCaseInfoPage();
        deleteTestModalPage = new DeleteTestModalPage();
    }

    @Step("Create new test case")
    public ProjectPageSteps createNewTestCase(TestCase testCase) {
        projectPage
                .clickCreateTestCase();
        createTestCasePage
                .enterTestCaseData(testCase)
                .clickSaveTestCaseButton();
        boolean isTestCaseCreated =
                projectPage
                        .isTestCaseCreated(testCase.getTitle());
        Assert.assertTrue(isTestCaseCreated, "Test case has no been created");
        return this;
    }

    @Step("Deleting test case")
    public ProjectPageSteps deleteTestCase(TestCase testCase) {
        projectPage
                .clickOnCaseByCaseName(testCase.getTitle());
        testCaseInfoPage
                .clickDeleteButton();
        deleteTestModalPage
                .clickDeleteTestCaseButton();
        projectPage
                .isTestCaseExist(testCase.getTitle());
        return this;
    }
}

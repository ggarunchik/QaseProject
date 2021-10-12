package steps.project;

import io.qameta.allure.Step;
import models.project.testcase.TestCase;
import pageobjects.project.*;

import static org.testng.Assert.assertTrue;

public class ProjectPageSteps {

    private ProjectPage projectPage;
    private CreateTestCasePage createTestCasePage;
    private TestCaseInfoPage testCaseInfoPage;
    private DeleteTestModalPage deleteTestModalPage;
    private EditTestCasePage editTestCasePage;

    public ProjectPageSteps() {
        projectPage = new ProjectPage();
        createTestCasePage = new CreateTestCasePage();
        testCaseInfoPage = new TestCaseInfoPage();
        deleteTestModalPage = new DeleteTestModalPage();
        editTestCasePage = new EditTestCasePage();
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
        assertTrue(isTestCaseCreated, "Test case has no been created");
        return this;
    }

    @Step("Deleting test case with name")
    public ProjectPageSteps deleteTestCase(String caseTitle) {
        projectPage
                .clickOnCaseByCaseName(caseTitle);
        testCaseInfoPage
                .clickDeleteButton();
        deleteTestModalPage
                .clickDeleteTestCaseButton();
        projectPage
                .isTestCaseNotExist(caseTitle);
        return this;
    }

    @Step("Editing test case")
    public ProjectPageSteps editTestCase(String testTitleToEdit, TestCase editedTestCase) {
        projectPage
                .clickOnCaseByCaseName(testTitleToEdit);
        testCaseInfoPage
                .clickEditTestCaseButton();
        editTestCasePage
                .edit(editedTestCase)
                .clickSaveEditCaseButton();
        projectPage
                .clickOnCaseByCaseName(editedTestCase.getTitle());
        assertTrue(
                testCaseInfoPage.getCaseTitle().equals(editedTestCase.getTitle()) &&
                         testCaseInfoPage.getFieldValueByName("Description").equals(editedTestCase.getDescription()) &&
                         testCaseInfoPage.getFieldValueByName("Severity").equals(editedTestCase.getSeverity()),
                "Some fields are not been updated");
        return this;
    }
}

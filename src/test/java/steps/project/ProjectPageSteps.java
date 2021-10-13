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

    @Step("Create new test case with name {testCase.title")
    public ProjectPageSteps createNewTestCase(TestCase testCase) {
        projectPage
                .clickCreateTestCase();
        createTestCasePage
                .enterTestCaseData(testCase)
                .clickSaveTestCaseButton();
        boolean isTestCaseCreated =
                projectPage.isTestCaseExist(testCase.getTitle());
        assertTrue(isTestCaseCreated, "Test case has no been created");
        return this;
    }

    @Step("Deleting test case with name {caseTitle}")
    public ProjectPageSteps deleteTestCase(String caseTitle) {
        projectPage
                .clickOnCaseByCaseName(caseTitle);
        testCaseInfoPage
                .clickDeleteButton();
        deleteTestModalPage
                .clickDeleteTestCaseButton();
        boolean isTestCaseCreated =
                projectPage.isTestCaseExist(caseTitle);
        assertTrue(isTestCaseCreated, "Test case has no been deleted (found in a list)");
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

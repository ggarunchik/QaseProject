package steps.project;

import io.qameta.allure.Step;
import models.project.testcase.TestCase;
import org.testng.Assert;
import pageobjects.project.*;

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
        Assert.assertTrue(isTestCaseCreated, "Test case has no been created");
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
    public ProjectPageSteps editTestCase(String caseTitle, String newTitle) {
        projectPage
                .clickOnCaseByCaseName(caseTitle);
        testCaseInfoPage
                .clickEditTestCaseButton();
        editTestCasePage
                .editInputWithLabel("Title", newTitle)
                .editTextareaWithLabel("Description", "Edited Description")
                .editDropDownWithLabel("Severity", "Trivial")
                .clickSaveEditCaseButton();
        projectPage
                .clickOnCaseByCaseName("Edited title");
        testCaseInfoPage.isTitleChanged(newTitle);
        testCaseInfoPage.isCaseDataChanged("Description", "Edited Description");
        testCaseInfoPage.isCaseDataChanged("Severity", "Trivial");
        return this;
    }
}

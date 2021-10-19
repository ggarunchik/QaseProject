package steps.testplan;

import io.qameta.allure.Step;
import models.testplan.TestPlan;
import pageobjects.testplan.CreateTestPlanPage;
import pageobjects.testplan.SelectTestCasesPage;
import pageobjects.testplan.TestPlanPage;

import static org.testng.Assert.assertTrue;

public class TestPlanSteps {

    private TestPlanPage testPlanPage;
    private CreateTestPlanPage createTestPlanPage;
    private SelectTestCasesPage selectTestCasesPage;

    public TestPlanSteps() {
        testPlanPage = new TestPlanPage();
        createTestPlanPage = new CreateTestPlanPage();
        selectTestCasesPage = new SelectTestCasesPage();
    }

    //TODO не хочу тут передавать один тест сьют - передавать лист сьютов...в методе selectTestCases -
    // сделать обработку события
    @Step("Creating new test plan")
    public TestPlanSteps createNewTestPlan(TestPlan testPlan, String projectCode, String testSuiteName) {
        testPlanPage
                .openPage(projectCode)
                .clickCreateTestPlanButton();
        createTestPlanPage
                .enterTitle(testPlan.getTestPlanTitle())
                .enterDescription(testPlan.getTestPlanDescription())
                .clickAddCasesButton();
        selectTestCasesPage
                .selectTestCases(testSuiteName)
                .clickDoneButton();
        createTestPlanPage
                .isCasesAmountCorrect(SelectTestCasesPage.getSelectedCases());
        createTestPlanPage
                .clickSavePlanButton();
        boolean isTestPlanCreated =
                testPlanPage
                        .isTestPlanDisplayed(testPlan.getTestPlanTitle());
        assertTrue(isTestPlanCreated, "Test plan has not been created (Can't find {testPlan.getTestPlanTitle()} in a list");
        return this;
    }
}

package tests.ui.testplan;

import models.factory.testplanfactory.TestPlanFactory;
import models.testplan.TestPlan;
import org.testng.annotations.Test;
import tests.ui.BaseTest;

public class TestPlanTest extends BaseTest {

    @Test(description = "Verify new test plan could be created")
    public void verifyTestPlanCouldBeCreated() {
        TestPlan testPlan = new TestPlanFactory().generateTestPlanData();
        loginPageSteps
                .login(USERNAME, PASSWORD);
        testPlanSteps
                .createNewTestPlan(testPlan, PROJECT_CODE, "Test cases without suite");
    }
}

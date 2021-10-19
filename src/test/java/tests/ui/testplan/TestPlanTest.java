package tests.ui.testplan;

import models.factory.testplanfactory.TestPlanFactory;
import models.testplan.TestPlan;
import org.testng.annotations.Test;
import tests.ui.BaseTest;

import java.util.Arrays;
import java.util.List;

public class TestPlanTest extends BaseTest {

    @Test(description = "Verify new test plan could be created")
    public void verifyTestPlanCouldBeCreated() {
        TestPlan testPlan = new TestPlanFactory().generateTestPlanData();
        List<String> suites = Arrays.asList("Test Suite #2 (autotest)", "Test Suite #3 (autotest)", "Test Suite #1 (autotest)");
        loginPageSteps
                .login(USERNAME, PASSWORD);
        testPlanSteps
                .createNewTestPlan(testPlan, PROJECT_CODE, suites);
    }
}

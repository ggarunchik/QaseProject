package models.factory.testplanfactory;

import models.factory.BaseFactory;
import models.testplan.TestPlan;

public class TestPlanFactory extends BaseFactory {

    public TestPlan generateTestPlanData() {
        return TestPlan.builder()
                .testPlanTitle(String.valueOf(faker.funnyName().name()))
                .testPlanDescription(String.valueOf(faker.chuckNorris().fact()))
                .build();
    }
}

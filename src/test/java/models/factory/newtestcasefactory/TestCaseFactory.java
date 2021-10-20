package models.factory.newtestcasefactory;

import models.factory.BaseFactory;
import models.project.testcase.TestCase;

public class TestCaseFactory extends BaseFactory {

    public TestCase generateRandomTestCase() {
        return TestCase.builder()
                .title(String.valueOf(faker.funnyName().name()))
                .status(getRandomOption(statusList))
                .description(String.valueOf(faker.chuckNorris().fact()))
                .severity(getRandomOption(severityList))
                .priority(getRandomOption(priorityList))
                .type(getRandomOption(typeList))
                .layer(getRandomOption(layerList))
                .isFlaky(getRandomOption(isFlakyList))
                .behavior(getRandomOption(behaviorList))
                .automationStatus(getRandomOption(autoStatusList))
                .preConditions(String.valueOf(faker.chuckNorris().fact()))
                .postConditions(String.valueOf(faker.chuckNorris().fact()))
                .build();
    }
}

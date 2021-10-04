package models.factory.newtestcasefactory;

import models.factory.BaseFactory;
import models.project.testcase.TestCase;

public class TestCaseFactory extends BaseFactory {

    public TestCase generateRandomTestCase() {
        return TestCase.builder()
                .title(String.valueOf(faker.funnyName().name()))
                .status("Draft")
                .description(String.valueOf(faker.chuckNorris().fact()))
                .severity("Blocker")
                .priority("High")
                .type("Smoke")
                .layer("E2E")
                .isFlaky("Yes")
                .behavior("Positive")
                .automationStatus("To be automated")
                .preConditions(String.valueOf(faker.chuckNorris().fact()))
                .postConditions(String.valueOf(faker.chuckNorris().fact()))
                .build();
    }
}

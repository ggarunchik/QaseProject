package elements.testsuite;


import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TestSuiteElement {
    String testSuiteName;
    String BASE_LOCATOR = "//p[contains(text(), '%s')]//../..//";
    String SUITE_CASE_COUNTER = BASE_LOCATOR + "p[@class = 'suite-cases-counter']";
    String SUITE_CASE_CHECKBOX = BASE_LOCATOR + "span[@class = 'custom-control-indicator']";
    String SUITE_CASE_DROPDOWN = BASE_LOCATOR + "div[@class = 'dropdown'";
    String SUITE_CASE_LOCATOR = "//p[contains(@class, 'suite-title') and text() = '%s']";

    public TestSuiteElement(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }

    @Step("Click on suite with name {suiteName}")
    public void clickOnSuite(String suiteName) {
        $(By.xpath(String.format(SUITE_CASE_LOCATOR, testSuiteName))).click();
    }

    @Step("Select suite with name {suiteName}")
    public void selectSuiteCheckbox() {
        $(By.xpath(String.format(SUITE_CASE_CHECKBOX, testSuiteName))).click();
    }

    @Step("Getting selected test cases amount {suiteName}")
    public int getSelectedTestCases() {
        String suiteText = $(By.xpath(String.format(SUITE_CASE_COUNTER, testSuiteName))).getText();
        return Integer.parseInt(suiteText.split("/")[0]);
    }

    @Step("Getting amount of tests in a suite: {suiteName}")
    public int getTestCasesAmountInSuite() {
        String suiteText = $(By.xpath(String.format(SUITE_CASE_COUNTER, testSuiteName))).getText();
        return Integer.parseInt(suiteText.split("/")[1]);
    }
}

package pageobjects.testplan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.testsuite.TestSuiteElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class SelectTestCasesPage extends BasePage {
    public static final By SELECT_CASES_XPATH = By.xpath("//*[contains(text(),'Select test cases')]");
    public static final By DONE_BUTTON_ID = By.id("select-cases-done-button");

    public static int selectedCases = 0;

    public static int getSelectedCases() {
        return selectedCases;
    }

    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(SELECT_CASES_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Select test case suite")
    public SelectTestCasesPage selectTestCases(String testSuiteName) {
        if (new TestSuiteElement(testSuiteName).getTestCasesAmountInSuite() > 0) {
            new TestSuiteElement(testSuiteName).selectSuiteCheckbox();
            setSelectedCases(testSuiteName);
        } else {
            Assert.fail("Can't select suite without cases in it");
        }
        return this;
    }

    @Step("Click on Done button")
    public CreateTestPlanPage clickDoneButton() {
        $(DONE_BUTTON_ID).click();
        return new CreateTestPlanPage();
    }

    public static void setSelectedCases(String testSuiteName) {
        selectedCases = selectedCases + new TestSuiteElement(testSuiteName).getSelectedTestCases();
    }
}

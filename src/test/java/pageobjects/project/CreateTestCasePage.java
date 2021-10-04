package pageobjects.project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import models.project.testcase.TestCase;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class CreateTestCasePage extends BasePage {

    private static final By SAVE_BUTTON_ID = By.id("save-case");

    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(SAVE_BUTTON_ID).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Generating test case data")
    public CreateTestCasePage enterTestCaseData(TestCase testCase) {
        new Input("Title").write(testCase.getTitle());
        new Input("Description").writeToInputWithToast(testCase.getDescription());
        new DropDown("Status").selectOption(testCase.getStatus());
        new DropDown("Severity").selectOption(testCase.getSeverity());
        new DropDown("Priority").selectOption(testCase.getPriority());
        new DropDown("Layer").selectOption(testCase.getLayer());
        new DropDown("Is Flaky").selectOption(testCase.getIsFlaky());
        new DropDown("Behavior").selectOption(testCase.getBehavior());
        new DropDown("Type").selectOption(testCase.getType());
        new DropDown("Automation status").selectOption(testCase.getAutomationStatus());
        new Input("Pre-conditions").writeToInputWithToast(testCase.getPreConditions());
        new Input("Post-conditions").writeToInputWithToast(testCase.getPostConditions());
        return this;
    }

    @Step("Click on save test case button")
    public CreateTestCasePage clickSaveTestCaseButton() {
        $(SAVE_BUTTON_ID).click();
        return this;
    }
}

package pageobjects.project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.DropDown;
import elements.Input;
import elements.TextArea;
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
                $(SAVE_BUTTON_ID).shouldBe(Condition.visible, Duration.ofSeconds(WAIT_DURATION));
        return element.isDisplayed();
    }

    @Step("Generating test case data")
    public CreateTestCasePage enterTestCaseData(TestCase testCase, String... suite) {
        new Input("Title").write(testCase.getTitle());
        new TextArea("Description").write(testCase.getDescription());
        new DropDown("Status").selectOption(testCase.getStatus());
        new DropDown("Severity").selectOption(testCase.getSeverity());
        new DropDown("Priority").selectOption(testCase.getPriority());
        new DropDown("Layer").selectOption(testCase.getLayer());
        new DropDown("Is Flaky").selectOption(testCase.getIsFlaky());
        new DropDown("Behavior").selectOption(testCase.getBehavior());
        new DropDown("Type").selectOption(testCase.getType());
        new DropDown("Automation status").selectOption(testCase.getAutomationStatus());
        new TextArea("Pre-conditions").write(testCase.getPreConditions());
        new TextArea("Post-conditions").write(testCase.getPostConditions());
        if(suite.length > 0) {
            new DropDown("Suite").selectOption(suite[0]);
        }
        return this;
    }

    @Step("Click on save test case button")
    public CreateTestCasePage clickSaveTestCaseButton() {
        $(SAVE_BUTTON_ID).click();
        return this;
    }
}

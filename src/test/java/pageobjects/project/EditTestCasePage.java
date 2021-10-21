package pageobjects.project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.project.testcase.TestCase;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class EditTestCasePage extends BasePage {

    private static final String EDIT_CASE_BUTTON_XPATH = "//button[contains(text(), '%s')]";

    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(By.xpath(String.format(EDIT_CASE_BUTTON_XPATH, "Save"))).shouldBe(Condition.visible, Duration.ofSeconds(WAIT_DURATION));
        return element.isDisplayed();
    }

    @Step("Changing dropdown option with label {label} to {option}")
    public EditTestCasePage editDropDownWithLabel(String label, String option) {
        isPageOpened();
        new DropDown(label).selectOption(option);
        return this;
    }

    @Step("Click Save edit test case button")
    public SaveTestModalPage clickSaveEditCaseButton() {
        $(By.xpath(String.format(EDIT_CASE_BUTTON_XPATH, "Save"))).click();
        return new SaveTestModalPage();
    }

    @Step("Editing test case with new random values")
    public EditTestCasePage edit(TestCase testCase) {
        isPageOpened();
        new Input("Title").clear();
        new Input("Title").write(testCase.getTitle());
        new TextArea("Description").clear();
        new TextArea("Description").write(testCase.getDescription());
        new DropDown("Severity").selectOption(testCase.getSeverity());
        return this;
    }
}

package pageobjects.project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class EditTestCasePage extends BasePage {

    private static final String EDIT_CASE_BUTTON_XPATH = "//button[contains(text(), '%s')]";

    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(By.xpath(String.format(EDIT_CASE_BUTTON_XPATH, "Save"))).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Changing input text with label {label} to {text}")
    public EditTestCasePage editInputWithLabel(String label, String text) {
        isPageOpened();
        new Input(label).clear();
        new Input(label).write(text);
        return this;
    }

    @Step("Changing textarea text with label {label} to {text}")
    public EditTestCasePage editTextareaWithLabel(String label, String text) {
        isPageOpened();
        new Input(label).clear();
        new Input(label).writeToInputWithToast(text);
        return this;
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
}

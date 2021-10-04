package pageobjects.project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.casepreview.InfoField;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class TestCaseInfoPage extends BasePage {

    private static final By PREVIEW_TITLE_CSS = By.cssSelector(".preview-title");
    private static final By PREVIEW_CLOSE_CSS = By.cssSelector(".preview-close");
    public static final By DELETE_TEST_CASE_BUTTON_CSS = By.cssSelector("button[title='Delete case']");
    public static final By EDIT_TEST_CASE_BUTTON_CSS = By.cssSelector("a[title='Edit case']");

    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(PREVIEW_TITLE_CSS).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Closing test case info")
    public ProjectPage clickCloseButton() {
        $(PREVIEW_CLOSE_CSS).click();
        return new ProjectPage();
    }

    @Step("Deleting test case")
    public DeleteTestModalPage clickDeleteButton() {
        isPageOpened();
        $(DELETE_TEST_CASE_BUTTON_CSS).click();
        return new DeleteTestModalPage();
    }

    @Step("Getting field ({}) value")
    public String getFieldValueByName(String label) {
        return new InfoField(label).getFieldValueByName();
    }

    @Step("Getting test case title")
    public String getCaseTitle() {
        return $(PREVIEW_TITLE_CSS).getText();
    }

    @Step("Click on Edit test case button")
    public EditTestCasePage clickEditTestCaseButton() {
        $(EDIT_TEST_CASE_BUTTON_CSS).click();
        return new EditTestCasePage();
    }

    @Step("Verify case data has been changed")
    public boolean isCaseDataChanged(String label, String text) {
        return getFieldValueByName(label).equals(text);
    }

    @Step("Verify case title")
    public boolean isTitleChanged(String text){
        return getCaseTitle().equals(text);
    }
}

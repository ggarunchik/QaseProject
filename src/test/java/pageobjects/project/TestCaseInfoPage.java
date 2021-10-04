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
    public static final By DELETE_TEST_CASE_BUTTON_XPATH = By.cssSelector("button[title='Delete case']");

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
        $(DELETE_TEST_CASE_BUTTON_XPATH).click();
        return new DeleteTestModalPage();
    }

    @Step("Getting field ({}) value")
    public String getFieldValueByName(String label) {
        return new InfoField(label).getFieldValueByName();
    }
}

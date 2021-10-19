package pageobjects.testplan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class SelectTestCasesPage extends BasePage {
    public static final By SELECT_CASES_XPATH = By.xpath("//*[contains(text(),'Select test cases')]");
    private static final String BASE_LOCATOR = "//p[contains(text(), '%s')]//../..//";
    public static final By SUITE_CASE_COUNTER = By.xpath(BASE_LOCATOR + "p[@class = 'suite-cases-counter']");
    public static final By SUITE_CASE_CHECKBOX = By.xpath(BASE_LOCATOR + "span[@class = 'custom-control-indicator']");
    public static final By SUITE_CASE_DROPDOWN = By.xpath(BASE_LOCATOR + "div[@class = 'dropdown'");
    public static final By SUITE_CASE_LOCATOR = By.xpath("//p[contains(@class, 'suite-title') and text() = '%s']");


    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(SELECT_CASES_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Select test case suite")
    public SelectTestCasesPage selectTestCases() {
        return this;
    }
}

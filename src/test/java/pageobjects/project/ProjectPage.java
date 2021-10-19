package pageobjects.project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ProjectPage extends BasePage {

    private static final By REPOSITORY_HEADER_XPATH = By.xpath("//div[@class='container-fluid container-app-content']");
    private static final By NO_PROJECT_CSS = By.cssSelector(".no-project");
    private static final By NO_PROJECT_CREATE_TEST_BUTTON_XPATH = By.xpath("//a[contains(text(),'Create new case')]");
    private static final By PROJECT_CREATE_TEST_BUTTON_ID = By.id("create-case-button");
    private static final By TEST_CASE_TITLE_CSS = By.cssSelector(".case-row-title");
    //TODO фигня локатор надо найти лучше
    private final String TEST_CASE_TITLE_XPATH = "    //div[@class = 'suite-block-header']//a[@class = 'suite-header-title' and text() = '%s']" +
            "//..//../..//./..//div[@class = 'cases-container']//div[@class = 'case-row-title']";


    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(REPOSITORY_HEADER_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    public boolean isNewRepository() {
        return $(NO_PROJECT_CSS).isDisplayed();
    }

    @Step("Click create test case button")
    public CreateTestCasePage clickCreateTestCase() {
        if (isNewRepository()) {
            $(NO_PROJECT_CREATE_TEST_BUTTON_XPATH).click();
        } else {
            $(PROJECT_CREATE_TEST_BUTTON_ID).click();
        }
        return new CreateTestCasePage();
    }

    @Step("Verify test case {testCaseName} exists")
    public boolean isTestCaseExist(String testCaseName) {
        isPageOpened();
        refresh();
        isPageOpened();
        List<SelenideElement> titleNames = $$(TEST_CASE_TITLE_CSS);
        return titleNames.stream().anyMatch(item -> testCaseName.equals(item.getText()));
    }

    @Step("Verify test case {testCaseName} exists")
    public boolean isTestCaseExistInSuite(String testCaseName, String suiteName) {
        isPageOpened();
        refresh();
        isPageOpened();
        List<SelenideElement> titleNames = $$(By.xpath(String.format(TEST_CASE_TITLE_XPATH, suiteName)));
        return titleNames.stream().anyMatch(item -> testCaseName.equals(item.getText()));
    }

    @Step("Click on test case with name {testCaseName}")
    public TestCaseInfoPage clickOnCaseByCaseName(String testCaseName) {
        isPageOpened();
        List<SelenideElement> titleNames = $$(TEST_CASE_TITLE_CSS);
        for (SelenideElement element : titleNames) {
            String testName = element.getText();
            if (testName.equals(testCaseName)) {
                element.click();
            }
        }
        return new TestCaseInfoPage();
    }
}

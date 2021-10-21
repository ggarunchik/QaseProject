package pageobjects.testplan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageobjects.BasePage;
import utils.PropertyReader;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class TestPlanPage extends BasePage {
    private final String TEST_PLAN_PAGE_URL = System.getenv().getOrDefault("base_url",PropertyReader.getProperty("base_url")) + "plan";
    public static final By TEST_PLAN_TITLE_XPATH = By.xpath("//h1[contains(text(),'Test plans')]");
    public static final By CREATE_TEST_PLAN_BUTTON_ID = By.id("createButton");
    public static final By NO_PROJECT_TEXT_CSS = By.cssSelector("span.no-project.mt-4");
    public static final By NO_PROJECT_IMG_CSS = By.cssSelector("img.empty-list");
    public static final By LIST_OF_TEST_PLANS_CSS = By.cssSelector(".defect-title");


    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(TEST_PLAN_TITLE_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(WAIT_DURATION));
        return element.isDisplayed();
    }

    @Step("Click in Create test plan button")
    public CreateTestPlanPage clickCreateTestPlanButton() {
        $(CREATE_TEST_PLAN_BUTTON_ID).click();
        return new CreateTestPlanPage();
    }

    @Step("Open test plan page for project with code {projectCode}")
    public TestPlanPage openPage(String projectCode) {
        open(TEST_PLAN_PAGE_URL + "/" + projectCode);
        return this;
    }

    @Step("Verify project with name exists in search")
    public boolean isTestPlanDisplayed(String testPlanName) {
        isPageOpened();
        return $$(LIST_OF_TEST_PLANS_CSS).findBy(Condition.text(testPlanName)).isDisplayed();
    }
}

package pageobjects.testplan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPlanPage extends BasePage {
    private final String TEST_PLAN_PAGE_URL = propertyReader.getPropertyValueByKey("base_url") + "plan";
    public static final By TEST_PLAN_TITLE_XPATH = By.xpath("//h1[contains(text(),'Test plans')]");
    public static final By CREATE_TEST_PLAN_BUTTON_ID = By.id("createButton");
    public static final By NO_PROJECT_TEXT_XPATH = By.xpath("//span[@class = 'no-project mt-4']");
    public static final By NO_PROJECT_IMG_XPATH = By.xpath("//img[@class = 'empty-list']");


    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(TEST_PLAN_TITLE_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Open test plan page for project with code {projectCode}")
    public CreateTestPlanPage openPage(String projectCode) {
        open(TEST_PLAN_PAGE_URL + "/" + projectCode);
        return new CreateTestPlanPage();
    }

    @Step("Click in Create test plan button")
    public CreateTestPlanPage clickCreateTestPlanButton() {
        $(CREATE_TEST_PLAN_BUTTON_ID).click();
        return new CreateTestPlanPage();
    }
}

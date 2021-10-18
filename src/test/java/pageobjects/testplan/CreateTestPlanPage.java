package pageobjects.testplan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;


public class CreateTestPlanPage extends BasePage {
    public static final By SELECT_CASES_XPATH = By.xpath("//h1[contains(text(),'Create test plan')]");
    public static final By ADD_CASES_BUTTON_ID = By.id("edit-plan-add-cases-button");
    public static final By SAVE_PLAN_BUTTON = By.id("save-plan");
    public static final By CANCEL_BUTTON = By.xpath("//*[contains(text(),'Cancel')]");


    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(SELECT_CASES_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }
}

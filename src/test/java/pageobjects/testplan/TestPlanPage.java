package pageobjects.testplan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class TestPlanPage extends BasePage {
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
}

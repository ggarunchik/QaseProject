package pageobjects.testplan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;


public class CreateTestPlanPage extends BasePage {
    public static final By CREATE_TEST_PLAN_LOCATOR_XPATH = By.xpath("//a[@title ='Test plan list']");
    public static final By ADD_CASES_BUTTON_ID = By.id("edit-plan-add-cases-button");
    public static final By SAVE_PLAN_BUTTON = By.id("save-plan");
    public static final By CANCEL_BUTTON = By.xpath("//*[contains(text(),'Cancel')]");
    public static final By AMOUNT_OF_SELECTED_CASES = By.xpath("//div[@class = 'row'][2]//../p[not(@class='empty-node')]");


    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(CREATE_TEST_PLAN_LOCATOR_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Enter title {testPlan.getTestPlanTitle")
    public CreateTestPlanPage enterTitle(String title) {
        isPageOpened();
        new Input("Title").write(title);
        return this;
    }

    @Step("Enter description {testPlan.getTestPlanDescription")
    public CreateTestPlanPage enterDescription(String description) {
        isPageOpened();
        new TextArea("Description").write(description);
        return this;
    }

    @Step("Click on Add cases button")
    public SelectTestCasesPage clickAddCasesButton() {
        isPageOpened();
        $(ADD_CASES_BUTTON_ID).click();
        return new SelectTestCasesPage();
    }

    @Step("Click on Create plan button")
    public TestPlanPage clickSavePlanButton() {
        isPageOpened();
        $(SAVE_PLAN_BUTTON).click();
        return new TestPlanPage();
    }

    @Step("Is amount of selected cases are equal to {selectedCasesAmount}")
    public boolean isCasesAmountCorrect(Integer selectedCasesAmount) {
        isPageOpened();
        String text = $(AMOUNT_OF_SELECTED_CASES).getText();
        int casesAmount = Integer.parseInt(text.contains(" ") ? text.split(" ")[0] : text);
        return selectedCasesAmount.equals(casesAmount);
    }
}

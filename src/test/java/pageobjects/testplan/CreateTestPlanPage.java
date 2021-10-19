package pageobjects.testplan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.testplan.TestPlan;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;


public class CreateTestPlanPage extends BasePage {
    public static final By SELECT_CASES_XPATH = By.xpath("//h1[contains(text(),'Create test plan')]");
    public static final By ADD_CASES_BUTTON_ID = By.id("edit-plan-add-cases-button");
    public static final By SAVE_PLAN_BUTTON = By.id("save-plan");
    public static final By CANCEL_BUTTON = By.xpath("//*[contains(text(),'Cancel')]");
    public static final By AMOUNT_OF_SELECTED_CASES = By.xpath("//div[@class = 'row']//../p[not(@class='empty-node')]");


    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(SELECT_CASES_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Enter title {testPlan.getTestPlanTitle")
    public CreateTestPlanPage enterTitle(TestPlan testPlan) {
        new Input("Title").write(testPlan.getTestPlanTitle());
        return this;
    }

    @Step("Enter description {testPlan.getTestPlanDescription")
    public CreateTestPlanPage enterDescription(TestPlan testPlan) {
        new TextArea("Description").write(testPlan.getTestPlanDescription());
        return this;
    }

    @Step("Click on Add cases button")
    public SelectTestCasesPage clickAddCasesButton() {
        $(ADD_CASES_BUTTON_ID).click();
        return new SelectTestCasesPage();
    }

    @Step("Click on Create plan button")
    public TestPlanPage clickCreatePlanButton() {
        $(SAVE_PLAN_BUTTON).click();
        return new TestPlanPage();
    }

    @Step("Is amount of selected cases are equal to {selectedCasesAmount}")
    public boolean isCasesAmountCorrect(Integer selectedCasesAmount) {
        String text = $(AMOUNT_OF_SELECTED_CASES).getText();
        int casesAmount = Integer.parseInt(text.contains(" ") ? text.split(" ")[0] : text);
        return selectedCasesAmount.equals(casesAmount);
    }
}

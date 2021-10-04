package pageobjects.project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DeleteTestModalPage extends BasePage {
    private static final String MODAL_BUTTON_LOCATOR_XPATH = "//div[@class='ReactModalPortal']//button[contains(text(), '%s')]";

    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(By.xpath(String.format(MODAL_BUTTON_LOCATOR_XPATH, "Delete"))).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Click Delete test case button")
    public ProjectPage clickDeleteTestCaseButton() {
        $(By.xpath(String.format(MODAL_BUTTON_LOCATOR_XPATH, "Delete"))).click();
        return new ProjectPage();
    }

    @Step("Click Cancel deleting test case button")
    public TestCaseInfoPage clickCancelButton() {
        $(By.xpath(String.format(MODAL_BUTTON_LOCATOR_XPATH, "Cancel"))).click();
        return new TestCaseInfoPage();
    }
}

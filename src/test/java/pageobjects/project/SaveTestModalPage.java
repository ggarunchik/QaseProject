package pageobjects.project;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageobjects.BaseModalPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class SaveTestModalPage extends BaseModalPage {
    private static final String MODAL_BUTTON_LOCATOR_XPATH = "//div[@class='ReactModalPortal']//button[contains(text(), '%s')]";

    @Override
    public boolean isModalOpened() {
        SelenideElement element =
                $(By.xpath(String.format(MODAL_BUTTON_LOCATOR_XPATH, "Save"))).shouldBe(Condition.visible, Duration.ofSeconds(WAIT_DURATION));
        return element.isDisplayed();
    }

    @Step("Click Delete test case button")
    public ProjectPage clickOnSaveButton() {
        isModalOpened();
        $(By.xpath(String.format(MODAL_BUTTON_LOCATOR_XPATH, "Save"))).click();
        return new ProjectPage();
    }
}

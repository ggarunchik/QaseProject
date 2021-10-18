package pageobjects.testplan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class SelectTestCasesPage extends BasePage {
    public static final By SELECT_CASES_XPATH = By.xpath("//*[contains(text(),'Select test cases')]");


    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(SELECT_CASES_XPATH).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }
}

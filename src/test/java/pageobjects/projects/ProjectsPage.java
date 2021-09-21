package pageobjects.projects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectsPage extends BasePage {

    private static final String PROJECTS_NAME_TABLE_CSS = "th[class='sortable']";


    @Step("Verifying is Projects Page opened")
    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(PROJECTS_NAME_TABLE_CSS).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }
}

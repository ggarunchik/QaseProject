package pageobjects.projects;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pageobjects.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectsPage extends BasePage {

    private static final String PROJECTS_NAME_TABLE_CSS = "th[class='sortable']";


    @Step("Verifying is Projects Page opened")
    @Override
    public ProjectsPage isPageOpened() {
        log.info("Check the 'Login' button is displayed.");
        try {
            $(PROJECTS_NAME_TABLE_CSS).shouldBe(Condition.visible, Duration.ofMillis(4000));
        } catch (NoSuchElementException exception) {
            log.error("'Login' button can't be found.");
            Assert.fail("'Login' button can't be found.");
        }
        return this;
    }
}

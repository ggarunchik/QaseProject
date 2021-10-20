package pageobjects.projects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pageobjects.BasePage;
import pageobjects.createproject.CreateProjectPage;
import pageobjects.project.ProjectPage;
import utils.PropertyReader;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {

    private static final String PROJECTS_NAME_TABLE_CSS = "th.sortable";
    private static final String CREATE_PROJECTS_BUTTON_CSS = "#createButton";
    private static final String PROJECT_NAME_CSS = "p.header";
    private static final By SEARCH_FORM_CSS = By.cssSelector(".form-control");
    private static final By PROJECT_TITLE_IN_SEARCH_CSS = By.cssSelector(".defect-title");
    private static final String PROJECTS_PAGE_URL = System.getenv().getOrDefault("base_url", PropertyReader.getProperty("base_url")) + "projects";


    @Step("Verifying is Projects Page opened")
    @Override
    public boolean isPageOpened() {
        SelenideElement element =
                $(PROJECTS_NAME_TABLE_CSS).shouldBe(Condition.visible, Duration.ofSeconds(4));
        return element.isDisplayed();
    }

    @Step("Opening Projects Page.")
    public ProjectsPage openProjectsPage() {
        open(PROJECTS_PAGE_URL);
        return this;
    }

    public ProjectsPage isCorrectProjectPageOpened(String projectName) {
        log.info("Check is correct project page has been opened {}", projectName);
        try {
            SelenideElement element = $(By.cssSelector(PROJECT_NAME_CSS));
            element.shouldBe(Condition.visible, Duration.ofMillis(5000));
            boolean isProjectNameCorrect =
                    projectName.equals(element.getText());
            Assert.assertTrue(isProjectNameCorrect, "Project name is incorrect");
        } catch (NoSuchElementException exception) {
            log.error("Project name is incorrect");
            Assert.fail("Project name is incorrect");
        }
        return this;
    }

    @Step("Click on Create new project button")
    public CreateProjectPage clickOnCreateProjectButton() {
        $(CREATE_PROJECTS_BUTTON_CSS).click();
        return new CreateProjectPage();
    }

    @Step("Select search tap")
    public ProjectsPage searchInForm(String projectName) {
        SelenideElement element = $(SEARCH_FORM_CSS);
        element.click();
        element.sendKeys(projectName);
        return this;
    }

    @Step("Verify project with name exists in search")
    public boolean isProjectDisplayed(String projectName) {
        return $$(PROJECT_TITLE_IN_SEARCH_CSS).findBy(Condition.text(projectName)).isDisplayed();
    }

    @Step("Opening project page")
    public ProjectPage openProjectPage(String projectName) {
        $$(PROJECT_TITLE_IN_SEARCH_CSS).findBy(Condition.text(projectName)).click();
        return new ProjectPage();
    }

}

package pageobjects.projects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pageobjects.BasePage;
import pageobjects.projects.createprojectpage.CreateProjectPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class ProjectsPage extends BasePage {

    private static final String PROJECTS_NAME_TABLE_CSS = "th[class='sortable']";
    private static final String CREATE_PROJECTS_BUTTON_CSS = "#createButton";
    private static final String PROJECT_NAME_XPATH = "//p[@class='header']";
    private final String PROJECTS_PAGE_URL = propertyReader.getPropertyValueByKey("projectsPage");


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

    @Step("Opening Projects Page.")
    public ProjectsPage openProjectsPage() {
        log.info("Opening Projects Page.");
        open(PROJECTS_PAGE_URL);
        return this;
    }

    public ProjectsPage isCorrectProjectPageOpened(String projectName) {
        log.info("Check is correct project page has been opened {}", projectName);
        try {
            SelenideElement element = $(By.xpath(PROJECT_NAME_XPATH));
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
    
    @Step("Click on Create new project button.")
    public CreateProjectPage clickOnCreateProjectButton() {
        log.info("Click on Create new project button.");
        $(CREATE_PROJECTS_BUTTON_CSS).click();
        return new CreateProjectPage();
    }
}

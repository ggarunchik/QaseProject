package pageobjects.projects.createprojectpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.NewProject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pageobjects.BasePage;
import utils.AllureUtils;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CreateProjectPage extends BasePage {
    private static final By CREATE_PROJECTS_BUTTON_CSS = By.cssSelector("button[type='submit']");
    private static final By DESCRIPTION_TEXT_AREA_CSS = By.cssSelector("#inputDescription");
    private static final String ACCESS_TYPE_XPATH = "//label[@class='form-check-label' and contains(text(), '%s')]";


    @Step("Verifying is Create Project Page opened")
    @Override
    public CreateProjectPage isPageOpened() {
        log.info("Verifying is Create Project Page opened.");
        try {
            $(CREATE_PROJECTS_BUTTON_CSS).shouldBe(Condition.visible, Duration.ofMillis(4000));
        } catch (NoSuchElementException exception) {
            log.error("'Create Project' button can't be found.");
            Assert.fail("'Create Project' button can't be found.");
            AllureUtils.takeScreenshot();
        }
        return this;
    }

    @Step("Entering new project data.")
    public CreateProjectPage enterNewProjectData(NewProject newProject) {
        log.info("Entering new project data {}.", newProject);
        new Input("Project name").write(newProject.getProjectName());
        new Input("Project Code").clear();
        new Input("Project Code").write(newProject.getProjectCode());
        $(DESCRIPTION_TEXT_AREA_CSS).sendKeys(newProject.getProjectDescription());
        return this;
    }

    @Step("Selecting access type {accessType}.")
    public CreateProjectPage selectAccessType(String accessType) {
        log.info("Selecting access type{}", accessType);
        SelenideElement element = $(By.xpath(String.format(ACCESS_TYPE_XPATH, accessType)));
        element.click();
        element.isSelected();
        return this;
    }

    @Step("Clicking on create project button.")
    public CreateProjectPage clickOnCreateButton() {
        log.info("Clicking on create project button.");
        $(CREATE_PROJECTS_BUTTON_CSS).click();
        return this;
    }
}
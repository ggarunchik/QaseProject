package steps.projects;

import io.qameta.allure.Step;

import models.singleproject.Project;
import org.testng.Assert;
import pageobjects.projects.ProjectsPage;
import pageobjects.projects.createprojectpage.CreateProjectPage;

public class ProjectsPageSteps {

    private ProjectsPage projectsPage;
    private CreateProjectPage createProjectPage;

    public ProjectsPageSteps() {
        projectsPage = new ProjectsPage();
        createProjectPage = new CreateProjectPage();
    }

    @Step("Verify is project has been created {newProject}")
    public ProjectsPageSteps createNewProject(Project newProject, String accessType) {
        boolean isProjectCreated =
                projectsPage
                        .openProjectsPage()
                        .clickOnCreateProjectButton()
                        .isPageOpened();
        createProjectPage
                .enterNewProjectData(newProject)
                .selectAccessType(accessType)
                .clickOnCreateButton();
        projectsPage
                .isCorrectProjectPageOpened(newProject.getTitle());
        Assert.assertTrue(isProjectCreated, "Project has not been created");
        return this;
    }
}

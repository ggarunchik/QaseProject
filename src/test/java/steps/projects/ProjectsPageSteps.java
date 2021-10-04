package steps.projects;

import io.qameta.allure.Step;
import models.project.Project;
import org.testng.Assert;
import pageobjects.createproject.CreateProjectPage;
import pageobjects.project.ProjectPage;
import pageobjects.projects.ProjectsPage;

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

    @Step("Search for project with name {projectName}")
    public ProjectsPageSteps searchForProject(String projectName) {
        boolean isProjectDisplayed =
                projectsPage
                        .searchInForm(projectName)
                        .isProjectDisplayed(projectName);
        Assert.assertTrue(isProjectDisplayed, "Project could not be found is search");
        return this;
    }

    @Step("Opening project with name {projectName}")
    public ProjectPage openProject(String projectName) {
        projectsPage
                .searchInForm(projectName)
                .openProjectPage(projectName);
        return new ProjectPage();
    }
}

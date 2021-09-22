package steps.projects;

import io.qameta.allure.Step;
import models.NewProject;
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

    public ProjectsPageSteps createNewProject(NewProject newProject, String accessType) {
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
                        .isCorrectProjectPageOpened(newProject.getProjectName());
        Assert.assertTrue(isProjectCreated, "Project has not been created");
        return this;
    }
}

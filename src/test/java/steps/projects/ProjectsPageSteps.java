package steps.projects;

import io.qameta.allure.Step;
import models.NewProject;
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
        projectsPage
                .openProjectsPage()
                .clickOnCreateProjectButton();
        createProjectPage
                .isPageOpened()
                .enterNewProjectData(newProject)
                .selectAccessType(accessType)
                .clickOnCreateButton();
        projectsPage
                .isCorrectProjectPageOpened(newProject.getProjectName());
        return this;
    }
}

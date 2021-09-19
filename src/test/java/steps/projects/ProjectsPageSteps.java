package steps.projects;

import models.singleproject.Project;
import pageobjects.projects.ProjectsPage;
import pageobjects.projects.createprojectpage.CreateProjectPage;

public class ProjectsPageSteps {

    private ProjectsPage projectsPage;
    private CreateProjectPage createProjectPage;

    public ProjectsPageSteps() {
        projectsPage = new ProjectsPage();
        createProjectPage = new CreateProjectPage();
    }

    public ProjectsPageSteps createNewProject(Project newProject, String accessType) {
        projectsPage
                .openProjectsPage()
                .clickOnCreateProjectButton();
        createProjectPage
                .isPageOpened()
                .enterNewProjectData(newProject)
                .selectAccessType(accessType)
                .clickOnCreateButton();
        projectsPage
                .isCorrectProjectPageOpened(newProject.getTitle());
        return this;
    }
}

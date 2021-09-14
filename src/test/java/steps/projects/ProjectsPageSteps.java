package steps.projects;

import pageobjects.projects.ProjectsPage;

public class ProjectsPageSteps {

    private ProjectsPage projectsPage;

    public ProjectsPageSteps() {
        projectsPage = new ProjectsPage();
    }

    public ProjectsPageSteps verifyProjectPageIsOpened() {
        projectsPage.isPageOpened();
        return this;
    }
}

package steps;

import org.testng.Assert;
import pages.projectsPage.ProjectsPage;
import tests.ui.BaseTest;

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

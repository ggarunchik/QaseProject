package tests.ui.projectspage;

import models.singleproject.Project;
import org.testng.annotations.Test;
import tests.ui.BaseTest;
import utils.AllureUtils;

public class ProjectsPageTest extends BaseTest {

    @Test(description = "Creating a new project")
    public void verifyNewProjectCouldBeCreated() {
        Project project = newProjectFactory.generateNewProjectData();
        loginPageSteps.login(USERNAME,PASSWORD);
        projectsPageSteps.createNewProject(project, "Public");
        AllureUtils.takeScreenshot();
    }
}

package tests.ui.projectspage;

import models.NewProject;
import org.testng.annotations.Test;
import tests.ui.BaseTest;

public class ProjectsPageTest extends BaseTest {

    @Test(description = "Creating a new project")
    public void verifyNewProjectCouldBeCreated() {
        NewProject newProject = newProjectFactory.generateNewProjectData();
        loginPageSteps
                .login(USERNAME, PASSWORD);
        projectsPageSteps
                .createNewProject(newProject, "Public");
    }
}

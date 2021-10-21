package tests.ui.projectspage;

import models.project.Project;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import tests.ui.BaseTest;

public class ProjectsPageTest extends BaseTest {

    @Test(description = "Creating a new project")
    public void verifyNewProjectCouldBeCreated() {
        Project newProject = newProjectFactory.generateNewProjectData();
        loginPageSteps
                .login(TEST_USER_EMAIL, TEST_USER_PASSWORD);
        projectsPageSteps
                .createNewProject(newProject, "Public");
    }

    @Test(description = "Searching for project")
    public void verifyProjectDisplayedInSearch(@Optional("glebTest") String param) {
        loginPageSteps
                .login(TEST_USER_EMAIL, TEST_USER_PASSWORD);
        projectsPageSteps
                .searchForProject(param);
    }
}

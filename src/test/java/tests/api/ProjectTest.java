package tests.api;

import configurations.RetryAnalyzer;
import models.projects.Projects;
import models.singleproject.Project;
import models.singleproject.createproject.ProjectCreateResults;
import org.testng.Assert;
import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ProjectTest extends BaseApiTest{

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "CRUD Project Test")
    public void projectsAPITest() {
        //Create a new project
        Project project = newProjectFactory.generateNewProjectData();
        ProjectCreateResults createResponse = projectsAdapter.create(project);
        //Verify code is correct
        Assert.assertEquals(createResponse.getResult().getCode(), project.getCode().toUpperCase(), "Code is invalid.");
        //Get all projects
        Projects projectsResultResponse = projectsAdapter.get(100);
        //Verify new project is in a list
        assertThat(projectsResultResponse.getProjectsResult().getProjectResultList(),
                hasItem(hasProperty("code", is(project.getCode().toUpperCase()))));
        //Get project
        Project response = projectsAdapter.get(project.getCode().toUpperCase());
        Assert.assertEquals(response.getProjectResult().getCode(), project.getCode().toUpperCase(), "Code is invalid.");
    }
}

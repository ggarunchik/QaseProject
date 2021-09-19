package tests.api;

import adapters.ProjectsAdapter;
import configurations.TestListener;
import lombok.extern.log4j.Log4j2;
import models.factory.newprojectfactory.NewProjectFactory;
import org.testng.annotations.Listeners;

@Log4j2
@Listeners(TestListener.class)
public class BaseApiTest {
    ProjectsAdapter projectsAdapter = new ProjectsAdapter();
    NewProjectFactory newProjectFactory = new NewProjectFactory();
}

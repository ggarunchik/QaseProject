package tests.api;

import adapters.ProjectsAdapter;
import configurations.TestListener;
import lombok.extern.log4j.Log4j2;
import models.factory.newprojectfactory.ProjectFactory;
import org.testng.annotations.Listeners;

@Log4j2
@Listeners(TestListener.class)
public class BaseApiTest {
    ProjectsAdapter projectsAdapter = new ProjectsAdapter();
    ProjectFactory newProjectFactory = new ProjectFactory();
}

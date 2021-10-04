package models.factory.newprojectfactory;

import models.factory.BaseFactory;
import models.project.Project;

public class ProjectFactory extends BaseFactory {

    public Project generateNewProjectData() {
        return Project.builder()
                .title(String.valueOf(faker.funnyName().name()))
                .code(String.valueOf(faker.lorem().characters(2, 10, false, false)))
                .description(String.valueOf(faker.chuckNorris().fact()))
                .build();
    }
}

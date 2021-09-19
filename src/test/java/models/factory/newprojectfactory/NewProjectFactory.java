package models.factory.newprojectfactory;

import models.singleproject.Project;
import models.factory.BaseFactory;

public class NewProjectFactory extends BaseFactory {

    public Project generateNewProjectData() {
        return Project.builder()
                .title(String.valueOf(faker.funnyName().name()))
                .code(String.valueOf(faker.lorem().characters(2,10,false,false)))
                .description(String.valueOf(faker.chuckNorris().fact()))
                .build();
    }
}

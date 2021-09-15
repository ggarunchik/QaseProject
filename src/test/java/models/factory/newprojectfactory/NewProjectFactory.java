package models.factory.newprojectfactory;

import models.NewProject;
import models.factory.BaseFactory;

public class NewProjectFactory extends BaseFactory {

    public NewProject generateNewProjectData() {
        return NewProject.builder()
                .projectName(String.valueOf(faker.funnyName().name()))
                .projectCode(String.valueOf(faker.code().asin()))
                .projectDescription(String.valueOf(faker.chuckNorris().fact()))
                .build();
    }
}

package adapters;

import lombok.extern.log4j.Log4j2;
import models.project.Project;
import models.project.createproject.ProjectCreateResults;
import models.projects.Projects;

@Log4j2
public class ProjectsAdapter extends BaseAdapter {

    public Project get(Project project) {
        String response = get("project/" + project.getCode(), "", 200);
        return gson.fromJson(response, Project.class);
    }

    public Projects get(int limit) {
        String response = get("project/" + "?limit=" + limit, "", 200);
        return gson.fromJson(response, Projects.class);
    }

    public Project get(String code) {
        String response = get("project/" + code, "", 200);
        return gson.fromJson(response, Project.class);
    }

    public ProjectCreateResults create(Project project) {
        String response = post("project/",
                gson.toJson(project), 200);
        return gson.fromJson(response, ProjectCreateResults.class);
    }
}

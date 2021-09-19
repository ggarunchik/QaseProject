package models.projects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import models.singleproject.ProjectResult;

import java.util.List;

@AllArgsConstructor
@Data
public class ProjectsResult {
    @Expose
    final int total;
    @Expose
    final int filtered;
    @Expose
    final int count;
    @SerializedName("entities")
    @Expose
    final List<ProjectResult> projectResultList;
}

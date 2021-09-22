package models.projects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Projects {
    @Expose
    final boolean status;
    @SerializedName("result")
    @Expose
    final ProjectsResult projectsResult;

}

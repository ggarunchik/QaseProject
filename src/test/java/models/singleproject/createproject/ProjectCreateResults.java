package models.singleproject.createproject;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ProjectCreateResults {
    @Expose
    final boolean status;
    @Expose
    Result result;
}

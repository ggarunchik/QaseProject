package models.project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    @Expose
    final String title;
    @Expose
    final String code;
    @Expose
    final String description;
    @Expose(serialize = false)
    final boolean status;
    @SerializedName("result")
    @Expose
    final ProjectResult projectResult;
}

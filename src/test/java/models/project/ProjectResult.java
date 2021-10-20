package models.project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProjectResult {
    @Expose
    final String title;
    @Expose
    final String code;
    @SerializedName("counts")
    @Expose
    final Counts counts;
}

package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewProject {
    final String projectName;
    final String projectCode;
    final String projectDescription;
}

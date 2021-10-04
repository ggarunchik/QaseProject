package models.project;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Runs {
    @Expose
    final int total;
    @Expose
    final int active;
}

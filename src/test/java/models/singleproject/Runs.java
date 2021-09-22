package models.singleproject;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Runs {
    @Expose
    final int total;
    @Expose
    final int active;
}

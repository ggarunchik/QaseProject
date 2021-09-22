package models.singleproject;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class Defects {
    @Expose
    final int total;
    @Expose
    final int open;
}

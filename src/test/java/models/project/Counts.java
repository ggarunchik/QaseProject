package models.project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Counts {
    @Expose
    final int cases;
    @Expose
    final int suites;
    @Expose
    final int milestones;
    @SerializedName("runs")
    @Expose
    final Runs runs;
    @SerializedName("defects")
    @Expose
    final Defects defects;

}

package models.testplan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TestPlan {
    String testPlanTitle;
    String testPlanDescription;
}

package models.project.testcase;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    final String title;
    final String status;
    final String description;
    final String suite;
    final String severity;
    final String priority;
    final String type;
    final String layer;
    final String isFlaky;
    final String milestone;
    final String behavior;
    final String automationStatus;
    final String preConditions;
    final String postConditions;
}

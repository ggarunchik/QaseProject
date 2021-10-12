package models.factory;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class BaseFactory {
    public static final List<String> typeList = new ArrayList<>(Arrays.asList("Smoke", "Functional", "Regression",
            "Security", "Usability", "Performance", "Acceptance"));
    public static final List<String> statusList = new ArrayList<>(Arrays.asList("Actual", "Draft", "Deprecated"));
    public static final List<String> severityList = new ArrayList<>(Arrays.asList("Blocker", "Critical", "Major",
            "Normal", "Minor", "Trivial"));
    public static final List<String> layerList = new ArrayList<>(Arrays.asList("E2E", "API", "Unit"));
    public static final List<String> priorityList = new ArrayList<>(Arrays.asList("High", "Medium", "Low"));
    public static final List<String> isFlakyList = new ArrayList<>(Arrays.asList("Yes", "No"));
    public static final List<String> behaviorList = new ArrayList<>(Arrays.asList("Positive", "Negative", "Destructive"));
    public static final List<String> autoStatusList = new ArrayList<>(Arrays.asList("To be automated", "Automated"));

    protected Faker faker = new Faker();

    public String getRandomOption(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

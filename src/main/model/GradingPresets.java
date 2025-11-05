// File: GradingPresets.java
package main.model;

import java.util.Arrays;
import java.util.List;

public class GradingPresets {

    // Common grading structures
    public static GradingStrategy threeCA() {
        return createStrategy(Arrays.asList(0.333, 0.333, 0.334));
    }

    public static GradingStrategy twoCAAndProject() {
        return createStrategy(Arrays.asList(0.25, 0.25, 0.50));
    }

    public static GradingStrategy projectAndFinal() {
        return createStrategy(Arrays.asList(0.50, 0.50));
    }

    public static GradingStrategy fourEqualAssignments() {
        return createStrategy(Arrays.asList(0.25, 0.25, 0.25, 0.25));
    }

    // For custom weight combinations
    public static GradingStrategy custom(List<Double> weights) {
        return createStrategy(weights);
    }

    // Private helper method
    private static GradingStrategy createStrategy(List<Double> weights) {
        return new GradingStrategy() {
            @Override
            public double calculateGrade(List<Assignment> assignments) {
                if (assignments.size() != weights.size()) {
                    throw new IllegalArgumentException(
                            "Expected " + weights.size() + " assignments, but got " + assignments.size()
                    );
                }

                double total = 0;
                for (int i = 0; i < assignments.size(); i++) {
                    Assignment assignment = assignments.get(i);
                    double weight = weights.get(i);
                    double percentage = (assignment.getScore() / assignment.getMaxScore()) * 100;
                    total += percentage * weight;
                }
                return total;
            }
        };
    }
}
package main.model;

public interface GradingStrategy {
    double calculateGrade(List<Assignment> assignments);
}

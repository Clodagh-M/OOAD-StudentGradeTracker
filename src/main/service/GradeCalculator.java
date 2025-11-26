package main.service;

import main.model.Module;
import java.util.Scanner;

public class GradeCalculator {
    private Scanner scanner;
    private CalculationMode mode;

    public enum CalculationMode {
        MODULE_GRADE,
        PASS_REQUIREMENTS
    }

    public GradeCalculator(Scanner scanner, CalculationMode mode) {
        this.scanner = scanner;
        this.mode = mode;
    }

    // Polymorphic behavior based on mode
    public void calculate(Module module) {
        switch(mode) {
            case MODULE_GRADE:
                calculateModuleGrade(module);
                break;
            case PASS_REQUIREMENTS:
                calculatePassRequirements(module);
                break;
        }
    }

    private void calculateModuleGrade(Module module) {
        double totalOverall = 0;
        for (var assignment : module.getAssignments()) {
            totalOverall += (assignment.getScore() / 100) * assignment.getWeight();
        }
        System.out.printf("Module %s Grade: %.2f%%\n", module.getName(), totalOverall);
    }

    private void calculatePassRequirements(Module module) {
        // Your existing pass calculation logic here
        double scoreWithWeight = 0;
        double totalWeight = 0;

        System.out.println("Please enter grade of each assignment: enter zero if not completed " + module.getName());
        for(var assignment : module.getAssignments()) {
            System.out.printf("  - %s: %.1f/100\n", assignment.getName(), assignment.getScore());
            double score = scanner.nextDouble();
            scanner.nextLine();
            assignment.setScore(score);
            if (score == 0) {
                System.out.println("Only assignments entered before zero considered");
                break;
            }
            scoreWithWeight += score * (assignment.getWeight() / 100);
            totalWeight += assignment.getWeight();
        }

        double remainingWeight = 100 - totalWeight;
        double remainingWeightPercent = remainingWeight / 100;
        double passmark = 40;
        double finalgrade = (passmark - scoreWithWeight) / remainingWeightPercent;

        if(finalgrade <= 0) {
            System.out.printf("You have already passed the module with current assignment score");
        } else if(finalgrade > 100) {
            System.out.printf("It is impossible to pass the module with current assignment score");
        } else {
            System.out.printf("You need at least %.2f%% of the remaining assessment(s) to pass overall.%n", finalgrade);
        }
    }
}
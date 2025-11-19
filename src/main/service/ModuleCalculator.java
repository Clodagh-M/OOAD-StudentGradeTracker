package main.service;

import main.model.Assignment;
import main.model.Module;

public class ModuleCalculator {
    public double calculateModuleGrade(Module module) {
        double totalOverall = 0;

        for (Assignment assignment : module.getAssignments()) {
            totalOverall += (assignment.getScore() / 100) * assignment.getWeight();
        }
        return totalOverall;
    }
}
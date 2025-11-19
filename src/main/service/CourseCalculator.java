package main.service;

import main.model.Course;
import main.model.Module;

import java.util.List;

public class CourseCalculator extends Course {

    public static double getOverallGrade(List<Module> modules) {
        if (modules.isEmpty()) return 0;

        double totalGrade = 0;
        int moduleCount = modules.size();

        for (Module module : modules) {
            totalGrade += ModuleCalculator.getModuleGrade(module);
        }

        return totalGrade / moduleCount;
    }

}

package main.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private List<Module> modules;

    // Fix constructor to use the passed modules
    public Course(String name, List<Module> modules) {
        this.name = name;
        this.modules = modules != null ? modules : new ArrayList<>();
    }

    // Add alternative constructor for empty course
    public Course(String name) {
        this.name = name;
        this.modules = new ArrayList<>();
    }

    // Add overall grade calculation
    public double getOverallGrade() {
        if (modules.isEmpty()) return 0;

        double totalGrade = 0;
        int moduleCount = modules.size();

        // Simple average of all modules (you can modify this for weighted modules)
        for (Module module : modules) {
            totalGrade += module.getModuleGrade();
        }

        return totalGrade / moduleCount;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    // Getters and setters...
    public String getName() { return name; }
    public List<Module> getModules() { return modules; }
    public void setName(String name) { this.name = name; }
    public void setModules(List<Module> modules) { this.modules = modules; }
}
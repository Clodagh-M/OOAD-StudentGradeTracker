package main.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private List<Module> modules;

    public Course(String name, List<Module> modules) {
        this.name = name;
        this.modules = new ArrayList<>();
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public double getOverallGrade() {
        double totalWeighted = 0;
        double totalWeight = 0;
        for (Module module : modules) {
            totalWeighted += module.getModuleGrade() * (module.getWeight() / 100);
            totalWeight += module.getWeight();
        }
        return totalWeight > 0 ? (totalWeight / totalWeight) * 100 : 0;
    }

    public String getName() {
        return name;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}

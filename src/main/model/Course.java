package main.model;
import main.service.ModuleCalculator;
import java.util.ArrayList;
import java.util.List;
//SINGLE RESPONSIBILTY PRINCPLE
//This stores course data.

public class Course {
    private String name;
    private List<Module> modules;

    public Course(String name, List<Module> modules) {
        this.name = name;
        this.modules = modules != null ? modules : new ArrayList<>();
    }

    public Course(String name) {
        this.name = name;
        this.modules = new ArrayList<>();
    }

    public Course() {
        this.name = "";
        this.modules = new ArrayList<>();
    }

    // Getters and setters...
    public String getName() { return name; }
    public List<Module> getModules() { return modules; }
    public void setName(String name) { this.name = name; }
    public void setModules(List<Module> modules) { this.modules = modules; }
}

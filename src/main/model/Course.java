package main.model;

public class Course {

    private final String name;
    private final String department;
    private final int numberOfModules;
    private final Module[] modules;

    public Course(String name, String department, int numberOfModules, Module[] modules) {
        this.name = name;
        this.department = department;
        this.numberOfModules = numberOfModules;
        this.modules = modules;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public int getNumberOfModules() {
        return numberOfModules;
    }
    public Module[] getModules() {
        return modules;
    }
}

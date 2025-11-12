package main.model;

import java.util.ArrayList;

public class Module {
    private String name;
    private ArrayList<Assignment> assignments;

    public Module(String name, ArrayList<Assignment> assignments) {
        this.name = name;
        this.assignments = assignments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void addModule(Assignment assignment) {
        this.assignments.add(assignment);
    }

}

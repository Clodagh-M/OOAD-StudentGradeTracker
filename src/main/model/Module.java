package main.model;

import java.util.ArrayList;

public class Module {
    private String name;
    private ArrayList<Assignment> assignments;

    public Module(String name, ArrayList<Assignment> assignments) {
        this.name = name;
        this.assignments = assignments != null ? assignments : new ArrayList<>();
    }

    public Module(String name) {
        this.name = name;
        this.assignments = new ArrayList<>();
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

    public double getModuleGrade() {
        if (assignments.isEmpty()) return 0;

        double totalWeighted = 0;
        double totalWeight = 0;

        for (Assignment assignment : assignments) {
            totalWeighted += assignment.getPercentage() * (assignment.getWeight() / 100);
            totalWeight += assignment.getWeight();
        }

        return totalWeight > 0 ? totalWeighted : 0;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

}

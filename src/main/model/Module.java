package main.model;

import java.util.ArrayList;

public class Module {
    private String name;
    private ArrayList<Assignment> assignments;

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
        double totalOverall = 0;

        for (Assignment assignment : assignments) {
            totalOverall += (assignment.getScore() /100) * assignment.getWeight();
        }
        return totalOverall;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add(assignment);
    }

}

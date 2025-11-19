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

    public void addAssignment(Assignment assignment) {
        if(validateAssignments()){
        this.assignments.add(assignment);
        }
        else{
            throw new IllegalArgumentException("Invalid assignment, has to be less than 100");
        }
    }

    public boolean validateAssignments() {
        double totalWeight = 0;

        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
            if(totalWeight > 100) {
                return false;
            }
        }
        return true;
    }
}

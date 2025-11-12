package main.model;

import java.util.ArrayList;

public class Module {
    private String name;
    private ArrayList<Assignment> assignments;

    public Module(String name) {
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

    public void displayAssignments(){
        System.out.println("Module Name: " + this.name);
        for(Assignment assignment:assignments){
            System.out.println("Assignment Name: " + assignment.getName());
        }
    }


}

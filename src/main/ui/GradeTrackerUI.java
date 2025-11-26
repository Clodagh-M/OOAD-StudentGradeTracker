package main.ui;

import java.util.Scanner;

import main.model.*;
import main.model.Module;
import main.service.CourseCalculator;
import main.service.IAssignmentCalculator;
import main.service.AssignmentCalculator;

public class GradeTrackerUI {
    private Course course;
    private Scanner scanner;
    private IAssignmentCalculator assignmentCalculator;

    public GradeTrackerUI(Course course) {
        this.course = course;
        this.scanner = new Scanner(System.in);
        this.assignmentCalculator = new AssignmentCalculator(scanner);
    }

    public void viewOverallGrade() {
        System.out.printf("\nOverall Course Grade: %.2f%%\n", CourseCalculator.getOverallGrade(course.getModules()));
    }

    private void viewModuleGrades() {
        System.out.println("\n=== Module Grades ===");
        for (main.model.Module module : course.getModules()) {
            System.out.printf("%s\n", module.getName());

            // Show individual assignments
            for (Assignment assignment : module.getAssignments()) {
                System.out.printf("  - %s: %.1f/100\n",
                        assignment.getName(),
                        assignment.getScore());
            }
            System.out.println();
        }
    }
    private void viewAssignmentGrades() {
        for(int i=0;i<course.getModules().size();i++){
            System.out.printf("%d. %s\n",i+1,course.getModules().get(i).getName());
        }
        System.out.print("Select  a module: ");
        int MODULEINDEX= scanner.nextInt() - 1;
        scanner.nextLine();
        if(MODULEINDEX < 0 || MODULEINDEX >= course.getModules().size()){
            System.out.println("Invalid module selection!");
            return;
        }
        Module selected=course.getModules().get(MODULEINDEX);

        assignmentCalculator.calculateGradeLeft(selected);

    }


    private void updateAssignmentScore() {
        System.out.println("\n=== Update Assignment Score ===");

        // List all modules
        for (int i = 0; i < course.getModules().size(); i++) {
            System.out.println((i + 1) + ". " + course.getModules().get(i).getName());
        }

        System.out.print("Select module (1-" + course.getModules().size() + "): ");
        int moduleIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (moduleIndex < 0 || moduleIndex >= course.getModules().size()) {
            System.out.println("Invalid module selection!");
            return;
        }

        main.model.Module selectedModule = course.getModules().get(moduleIndex);

        // List assignments in selected module
        System.out.println("\nAssignments in " + selectedModule.getName() + ":");
        for (int i = 0; i < selectedModule.getAssignments().size(); i++) {
            Assignment assignment = selectedModule.getAssignments().get(i);
            System.out.printf("%d. %s (Current: %.1f/100)\n",
                    i + 1, assignment.getName(), assignment.getScore());
        }

        System.out.print("Select assignment: ");
        int assignmentIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (assignmentIndex < 0 || assignmentIndex >= selectedModule.getAssignments().size()) {
            System.out.println("Invalid assignment selection!");
            return;
        }

        Assignment selectedAssignment = selectedModule.getAssignments().get(assignmentIndex);

        System.out.print("Enter new score (max 100): ");
        double newScore = scanner.nextDouble();
        scanner.nextLine();

        if (newScore < 0 || newScore > 100) {
            System.out.println("Invalid score! Must be between 0 and 100");
            return;
        }

        selectedAssignment.setScore(newScore);
        System.out.println("Score updated successfully!");
//        System.out.printf("New percentage: %.1f%%\n", selectedAssignment.getPercentage());
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== Grade Tracker ===");
            System.out.println("1. View Overall Grade");
            System.out.println("2. View Module Grades");
            System.out.println("3. Update Assignment Score");
            System.out.println("4. Calculate To Pass Module");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewOverallGrade();
                    break;
                case 2:
                    viewModuleGrades();
                    break;
                case 3:
                    updateAssignmentScore();
                    break;
                case 4:
                    viewAssignmentGrades();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
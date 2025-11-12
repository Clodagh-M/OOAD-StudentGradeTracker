package main.ui;

import java.util.Scanner;
import java.util.ArrayList;
import main.model.*;

public class GradeTrackerUI {
    private Course course;
    private Scanner scanner;

    public GradeTrackerUI() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        initializeCourse();
        showMainMenu();
    }

    private void initializeCourse() {
        ArrayList<main.model.Module> modules = new ArrayList<>();

        main.model.Module OOAD = new main.model.Module("Object Oriented Analysis & Design");
        OOAD.addAssignment(new Assignment("CA1", 0, 100, 30));
        OOAD.addAssignment(new Assignment("CA2", 0, 100, 30));
        OOAD.addAssignment(new Assignment("FEO", 0, 100, 40));
        modules.add(OOAD);


        main.model.Module WF = new main.model.Module("Web Frameworks");
        WF.addAssignment(new Assignment("Project", 0, 100, 100));
        modules.add(WF);

        // Create the course with all modules
        course = new Course("Computing - Y3", modules);

        System.out.println("Course initialized with " + modules.size() + " modules!");
    }

    private void viewOverallGrade() {
        System.out.printf("\nOverall Course Grade: %.2f%%\n", course.getOverallGrade());
    }

    private void viewModuleGrades() {
        System.out.println("\n=== Module Grades ===");
        for (main.model.Module module : course.getModules()) {
            System.out.printf("%s: %.2f%%\n", module.getName(), module.getModuleGrade());

            // Show individual assignments
            for (Assignment assignment : module.getAssignments()) {
                System.out.printf("  - %s: %.1f/%.0f (%.1f%%)\n",
                        assignment.getName(),
                        assignment.getScore(),
                        assignment.getMaxScore(),
                        assignment.getPercentage());
            }
            System.out.println();

        }
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
            System.out.printf("%d. %s (Current: %.1f/%.0f)\n",
                    i + 1, assignment.getName(), assignment.getScore(), assignment.getMaxScore());
        }

        System.out.print("Select assignment: ");
        int assignmentIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (assignmentIndex < 0 || assignmentIndex >= selectedModule.getAssignments().size()) {
            System.out.println("Invalid assignment selection!");
            return;
        }

        Assignment selectedAssignment = selectedModule.getAssignments().get(assignmentIndex);

        System.out.print("Enter new score (max " + selectedAssignment.getMaxScore() + "): ");
        double newScore = scanner.nextDouble();
        scanner.nextLine();

        if (newScore < 0 || newScore > selectedAssignment.getMaxScore()) {
            System.out.println("Invalid score! Must be between 0 and " + selectedAssignment.getMaxScore());
            return;
        }

        selectedAssignment.setScore(newScore);
        System.out.println("Score updated successfully!");
        System.out.printf("New percentage: %.1f%%\n", selectedAssignment.getPercentage());
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n=== Grade Tracker ===");
            System.out.println("1. View Overall Grade");
            System.out.println("2. View Module Grades");
            System.out.println("3. Update Assignment Score");
            System.out.println("4. Exit");
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
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
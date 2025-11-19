package main.ui;

import java.util.Scanner;
import java.util.ArrayList;
import main.model.*;
import main.model.Module;



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
        OOAD.addAssignment(new Assignment("CA1 - Essay", 0,  30));
        OOAD.addAssignment(new Assignment("CA2 - Project", 0, 30));
        OOAD.addAssignment(new Assignment("FEO - Code Review", 0,  40));
        modules.add(OOAD);

        main.model.Module WF = new main.model.Module("Web Frameworks");
        WF.addAssignment(new Assignment("Project", 0, 100));
        modules.add(WF);

        main.model.Module DSC = new main.model.Module("Data Structures & Concurrency");
        DSC.addAssignment(new Assignment("CA - Report", 0, 50));
        DSC.addAssignment(new Assignment("Final Exam", 0,  50));
        modules.add(DSC);

        main.model.Module ST = new main.model.Module("Software Tools");
        ST.addAssignment(new Assignment("Group Project", 0, 50));
        ST.addAssignment(new Assignment("CA", 0, 50));
        modules.add(ST);

        main.model.Module DA = new main.model.Module("Data Analytics");
        DA.addAssignment(new Assignment("Labs", 0, 15));
        DA.addAssignment(new Assignment("Project", 0, 35));
        DA.addAssignment(new Assignment("Final Exam", 0, 50));
        modules.add(DA);

        main.model.Module PD = new main.model.Module("Professional Development");
        PD.addAssignment(new Assignment("CA1 - CV", 0, 40));
        PD.addAssignment(new Assignment("CA2 - Video Presentation", 0, 30));
        PD.addAssignment(new Assignment("CA3 - Reflective Journals", 0, 30));
        modules.add(PD);

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
    private void calculateGradeLeft(Module module, Scanner scanner){
         double scoreWithWeight = 0;
         double totalweight=0;

        System.out.println("Please enter grade of  each assignment: enter zero if not completed "+module.getName());
       for(Assignment assignment : module.getAssignments()){
           System.out.printf("  - %s: %.1f/100\n",assignment.getName(),assignment.getScore());
           double score = scanner.nextDouble();
           scanner.nextLine();
           assignment.setScore(score);
           if (score==0){
               System.out.println("Only assigments enntered before zero considered");
               break;
           }
            scoreWithWeight += score*(assignment.getWeight()/100);
            totalweight += assignment.getWeight();
       }




        double remainingWeight = 100 - totalweight;
        double remainingWeightPercent = remainingWeight/100;
        double passmark=40;
        double finalgrade=(passmark-scoreWithWeight)/remainingWeightPercent;
        if(finalgrade<=0){
            System.out.printf("You  have already passed the module with current assignment score");
        }
        else if(finalgrade>100){
            System.out.printf("Its is impossible to pass the module with current assignment score");
        }


        System.out.printf("You need at least %.2f%% of the remaining assessment(s) to pass overall .%n",finalgrade);
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

    private void showMainMenu() {
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

                    calculateGradeLeft(selected,scanner);
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
package main.service;

import main.model.Assignment;
import main.model.Module;

import java.util.Scanner;

public class AssignmentCalculator implements IAssignmentCalculator {

    private Scanner scanner;

    public AssignmentCalculator(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void  calculateGradeLeft(Module module){
        double scoreWithWeight = 0;
        double totalweight=0;

        System.out.println("Please enter grade of  each assignment: enter zero if not completed "+module.getName());
        for(Assignment assignment : module.getAssignments()){
            System.out.printf("  - %s: %.1f/100\n",assignment.getName(),assignment.getScore());
            double score = scanner.nextDouble();
            scanner.nextLine();
            assignment.setScore(score);
            if (score==0){
                System.out.println("Only assigments entered before zero considered");
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
}

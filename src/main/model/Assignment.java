package main.model;
import java.util.Scanner;
public class Assignment {
    private String name;
    private Scanner scanner;
    private  double score;

    private double maxScore;

    private double weight;
    public Assignment(String name, double score, double maxScore, double weight) {
        this.name = name;
        this.score = score;
        this.maxScore = maxScore;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public double getMaxScore() {
        return maxScore;
    }
    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }



    public static void calculateGradeLeft(Scanner scanner){

        System.out.print("Please enter grade of assignment: ");
        double score=scanner.nextInt();
        scanner.nextLine();

        System.out.print("Please enter weight of assignment: ");
        double weight=scanner.nextInt();
        scanner.nextLine();

        double scoreWithWeight = score*(weight/100);
        double remainingWeight = 100 - weight;
        double remainingWeightPercent = remainingWeight/100;
        double passmark=40;
        double finalgrade=(passmark-scoreWithWeight)/remainingWeightPercent;
        if(finalgrade<=0){
            System.out.printf("You  have already passed the module with current assignment score");
        }
        else if(finalgrade>100){
            System.out.printf("Its is impossible to pass the module with current assignment score");
        }
        System.out.printf("You need at least "+finalgrade+" of the remaining assessment(s) to pass overall");
    }



}


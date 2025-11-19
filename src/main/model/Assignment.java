package main.model;
import java.util.Scanner;
public class Assignment {
    private String name;
    private  double score;
    private double weight;
    public Assignment(String name, double score,  double weight) {
        this.name = name;
        this.score = score;

        this.weight = weight;
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


    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }








}


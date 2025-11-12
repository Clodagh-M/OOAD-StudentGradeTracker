package main.model;

public class Assignment {
    private String name;

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
    }}


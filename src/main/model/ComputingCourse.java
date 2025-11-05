package main.model;

public enum ComputingCourse {;

    private final String name = "Computing - Software Development";
    private final String department = "Computing";



//    private final GradingPresets gradingPresets;

//    Course(String name, String department, GradingPresets gradingPresets) {
//        this.name = name;
//        this.department = department;
////        this.gradingPresets = gradingPresets;
//    }

    ComputingCourse(String name, String department) {
        name = name;
        department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

//    public GradingPresets getGradingPresets() { return gradingPresets; }


}

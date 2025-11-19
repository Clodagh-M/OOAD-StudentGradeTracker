package main;

import main.model.Assignment;
import main.model.Course;
import main.model.Module;
import main.ui.GradeTrackerUI;

import java.util.ArrayList;

public class GradeTrackerApp {

    public static void main(String[] args) {
        Course course = initialiseCourse();
        GradeTrackerUI ui = new GradeTrackerUI(course);
        ui.showMainMenu();
    }

    private static Course initialiseCourse() {
        ArrayList<Module> modules = new ArrayList<>();

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
        return new Course("Computing - Y3", modules);
    }



}

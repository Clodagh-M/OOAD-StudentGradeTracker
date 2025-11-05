package main.model;

import java.util.Arrays;

public enum Module {

    dsc("Data Structures and Concurrency", (GradingPresets) GradingPresets.projectAndFinal()),
    wf("Web Frameworks", (GradingPresets) GradingPresets.projectAndFinal()),
    ooad("Object Oriented Analysis and Design", (GradingPresets) GradingPresets.custom(Arrays.asList(0.3, 0.3, 0.4))),
    st("Software Tools", (GradingPresets) GradingPresets.projectAndFinal()),
    da("Data Analytics", (GradingPresets) GradingPresets.custom(Arrays.asList(0.5, 0.15, 0.35))),
    pd("Professional Development", (GradingPresets) GradingPresets.custom(Arrays.asList(0.4, 0.3, 0.3)));

    private final String name;
    private final GradingPresets gradePreset;

    Module(String name, GradingPresets gradePreset) {
        this.name = name;
        this.gradePreset = gradePreset;
    }


}

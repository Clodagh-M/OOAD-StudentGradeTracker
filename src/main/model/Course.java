package main.model;

public enum Course {

    // MATHEMATICS
    CALCULUS_I("Calculus I", 4, "Mathematics"),
    CALCULUS_II("Calculus II", 4, "Mathematics"),
    CALCULUS_III("Calculus III", 4, "Mathematics"),
    LINEAR_ALGEBRA("Linear Algebra", 3, "Mathematics"),
    DIFFERENTIAL_EQUATIONS("Differential Equations", 3, "Mathematics"),
    DISCRETE_MATHEMATICS("Discrete Mathematics", 3, "Mathematics"),
    PROBABILITY_AND_STATISTICS("Probability and Statistics", 3, "Mathematics"),

    // COMPUTER SCIENCE
    INTRODUCTION_TO_PROGRAMMING("Introduction to Programming", 4, "Computer Science"),
    DATA_STRUCTURES("Data Structures", 4, "Computer Science"),
    ALGORITHMS("Algorithms", 4, "Computer Science"),
    COMPUTER_ORGANIZATION("Computer Organization", 3, "Computer Science"),
    OPERATING_SYSTEMS("Operating Systems", 3, "Computer Science"),
    DATABASE_SYSTEMS("Database Systems", 3, "Computer Science"),
    SOFTWARE_ENGINEERING("Software Engineering", 3, "Computer Science"),
    COMPUTER_NETWORKS("Computer Networks", 3, "Computer Science"),
    ARTIFICIAL_INTELLIGENCE("Artificial Intelligence", 3, "Computer Science"),
    WEB_DEVELOPMENT("Web Development", 3, "Computer Science"),

    // PHYSICAL SCIENCES
    GENERAL_PHYSICS_I("General Physics I", 4, "Physics"),
    GENERAL_PHYSICS_II("General Physics II", 4, "Physics"),
    GENERAL_CHEMISTRY_I("General Chemistry I", 4, "Chemistry"),
    GENERAL_CHEMISTRY_II("General Chemistry II", 4, "Chemistry"),
    ORGANIC_CHEMISTRY("Organic Chemistry", 4, "Chemistry"),
    BIOLOGY_I("Biology I", 4, "Biology"),
    BIOLOGY_II("Biology II", 4, "Biology"),
    GEOLOGY("Geology", 3, "Earth Sciences"),
    ASTRONOMY("Astronomy", 3, "Physics"),

    // ENGINEERING
    INTRODUCTION_TO_ENGINEERING("Introduction to Engineering", 3, "Engineering"),
    CIRCUIT_ANALYSIS("Circuit Analysis", 4, "Electrical Engineering"),
    THERMODYNAMICS("Thermodynamics", 4, "Mechanical Engineering"),
    FLUID_MECHANICS("Fluid Mechanics", 4, "Mechanical Engineering"),
    MATERIALS_SCIENCE("Materials Science", 3, "Engineering"),
    DIGITAL_LOGIC_DESIGN("Digital Logic Design", 4, "Electrical Engineering"),
    MECHANICS_OF_MATERIALS("Mechanics of Materials", 4, "Civil Engineering"),

    // HUMANITIES
    ENGLISH_COMPOSITION_I("English Composition I", 3, "English"),
    ENGLISH_COMPOSITION_II("English Composition II", 3, "English"),
    WORLD_LITERATURE("World Literature", 3, "English"),
    INTRODUCTION_TO_PHILOSOPHY("Introduction to Philosophy", 3, "Philosophy"),
    ETHICS("Ethics", 3, "Philosophy"),
    WORLD_HISTORY_I("World History I", 3, "History"),
    WORLD_HISTORY_II("World History II", 3, "History"),
    ART_HISTORY("Art History", 3, "Art"),
    MUSIC_APPRECIATION("Music Appreciation", 3, "Music"),

    // SOCIAL SCIENCES
    INTRODUCTION_TO_PSYCHOLOGY("Introduction to Psychology", 3, "Psychology"),
    INTRODUCTION_TO_SOCIOLOGY("Introduction to Sociology", 3, "Sociology"),
    INTRODUCTION_TO_ANTHROPOLOGY("Introduction to Anthropology", 3, "Anthropology"),
    MICROECONOMICS("Microeconomics", 3, "Economics"),
    MACROECONOMICS("Macroeconomics", 3, "Economics"),
    AMERICAN_GOVERNMENT("American Government", 3, "Political Science"),
    INTERNATIONAL_RELATIONS("International Relations", 3, "Political Science"),

    // BUSINESS
    PRINCIPLES_OF_MARKETING("Principles of Marketing", 3, "Business"),
    PRINCIPLES_OF_MANAGEMENT("Principles of Management", 3, "Business"),
    FINANCIAL_ACCOUNTING("Financial Accounting", 3, "Business"),
    MANAGERIAL_ACCOUNTING("Managerial Accounting", 3, "Business"),
    BUSINESS_LAW("Business Law", 3, "Business"),
    ORGANIZATIONAL_BEHAVIOR("Organizational Behavior", 3, "Business"),

    // LANGUAGES
    SPANISH_I("Spanish I", 4, "Languages"),
    SPANISH_II("Spanish II", 4, "Languages"),
    FRENCH_I("French I", 4, "Languages"),
    FRENCH_II("French II", 4, "Languages"),
    GERMAN_I("German I", 4, "Languages"),
    GERMAN_II("German II", 4, "Languages"),
    CHINESE_I("Chinese I", 4, "Languages"),
    CHINESE_II("Chinese II", 4, "Languages"),

    // ELECTIVES
    PUBLIC_SPEAKING("Public Speaking", 3, "Communication"),
    CRITICAL_THINKING("Critical Thinking", 3, "Philosophy"),
    ENVIRONMENTAL_SCIENCE("Environmental Science", 3, "Environmental Studies"),
    NUTRITION("Nutrition", 3, "Health Sciences"),
    PHYSICAL_EDUCATION("Physical Education", 1, "Health"),
    INTRODUCTION_TO_FILM("Introduction to Film", 3, "Media Studies");

    private String name;
    private int credits;
    private String department;

    Course(String name, int credits, String department) {
        this.name = name;
        this.credits = credits;
        this.department = department;
    }

    public String getName() {
        return name;
    }
    public int getCredits() {
        return credits;
    }
    public String getDepartment() {
        return department;
    }


}

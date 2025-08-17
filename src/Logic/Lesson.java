package Logic;

import java.util.ArrayList;

public class Lesson {
    private String name;
    private String college;
    private String examDate;
    private String timeClass;
    private int capacity;
    private int units;
    private int code;
    private studentType type;
    private ArrayList<String> prerequisite = new ArrayList<>();
    private ArrayList<String> requiredFor = new ArrayList<>();
    private ArrayList<String> professors = new ArrayList<>();
    private ArrayList<String> TAs = new ArrayList<>();

    public Lesson() {
    }

    public studentType getType() {
        return type;
    }

    public void setType(studentType type) {
        this.type = type;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTimeClass() {
        return timeClass;
    }

    public void setTimeClass(String timeClass) {
        this.timeClass = timeClass;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public ArrayList<String> getTAs() {
        return TAs;
    }

    public void setTAs(ArrayList<String> TAs) {
        this.TAs = TAs;
    }

    public ArrayList<String> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<String> professors) {
        this.professors = professors;
    }

    public ArrayList<String> getRequiredFor() {
        return requiredFor;
    }

    public void setRequiredFor(ArrayList<String> requiredFor) {
        this.requiredFor = requiredFor;
    }

    public ArrayList<String> getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(ArrayList<String> prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

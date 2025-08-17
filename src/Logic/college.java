package Logic;

import java.util.ArrayList;

public class college {
    private String name;
    private Din Din;
    private boolean hasDeputy;
    private Deputy deputy;
    private ArrayList<Professor> professors = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Lesson> lessons = new ArrayList<>();


    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
}

package Logic;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends User {
    private ArrayList<String> myLessons = new ArrayList<>();
    private HashMap<Student,Lesson> students = new HashMap<>();
    private HashMap<Student,Lesson> teacherAssistants = new HashMap<>();
    private professorType typeP = professorType.Normal;


    public Professor() {
        setType(userType.Professor);
        setTypeP(professorType.Normal);
    }

    public HashMap<Student, Lesson> getTeacherAssistants() {
        return teacherAssistants;
    }

    public void setTeacherAssistants(HashMap<Student, Lesson> teacherAssistants) {
        this.teacherAssistants = teacherAssistants;
    }

    public ArrayList<String> getMyLessons() {
        return myLessons;
    }

    public void setMyLessons(ArrayList<String> myLessons) {
        this.myLessons = myLessons;
    }

    public HashMap<Student, Lesson> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Student, Lesson> students) {
        this.students = students;
    }

    public professorType getTypeP() {
        return typeP;
    }

    public void setTypeP(professorType typeP) {
        this.typeP = typeP;
    }
}

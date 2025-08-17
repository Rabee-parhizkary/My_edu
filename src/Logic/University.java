package Logic;

import java.util.ArrayList;

public class University {
    private static ArrayList<college> colleges = new ArrayList<>();

    public static ArrayList<college> getColleges() {
        return colleges;
    }

    public static void setColleges(ArrayList<college> colleges) {
        University.colleges = colleges;
    }
}

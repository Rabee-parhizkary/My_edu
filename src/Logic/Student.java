package Logic;

import java.util.HashMap;

public class Student extends User {
    private int yearOfEntry;
    //first is professor second is course name
    private HashMap<String,String> myLessons = new HashMap<>();
    private studyStatus status;
    private studentType studentType;
    private String signupDate;
    private String guidingP;


    public Student() {
        setType(userType.Student);
    }

    public String getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(String signupDate) {
        this.signupDate = signupDate;
    }

    public String getGuidingP() {
        return guidingP;
    }

    public void setGuidingP(String guidingP) {
        this.guidingP = guidingP;
    }

    public Logic.studentType getStudentType() {
        return studentType;
    }

    public void setStudentType(Logic.studentType studentType) {
        this.studentType = studentType;
    }

    public int getYearOfEntry() {
        return yearOfEntry;
    }

    public void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public studyStatus getStatus() {
        return status;
    }

    public void setStatus(studyStatus status) {
        this.status = status;
    }

    public HashMap<String, String> getMyLessons() {
        return myLessons;
    }

    public void setMyLessons(HashMap<String, String> myLessons) {
        this.myLessons = myLessons;
    }
}

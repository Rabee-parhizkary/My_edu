package Logic;

import java.util.HashMap;

public class Deputy extends Professor{
    private HashMap<Integer,String> timeToChoose = new HashMap<>();
    public Deputy() {
        setTypeP(professorType.Deputy);
    }


    public HashMap<Integer, String> getTimeToChoose() {
        return timeToChoose;
    }

    public void setTimeToChoose(HashMap<Integer, String> timeToChoose) {
        this.timeToChoose = timeToChoose;
    }
}

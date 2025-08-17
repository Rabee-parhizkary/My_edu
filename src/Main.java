import Frame.Proffesor.ProfessorsList;
import Frame.Proffesor.mainProfessor;
import Logic.User;

public class Main {


        public static void main(String args[]) {
                User user = new User();
                new ProfessorsList(user).setVisible(true);
        }


}

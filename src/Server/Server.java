package Server;

import Logic.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    private final ServerSocket serverSocket;
    private static ArrayList<Professor> professors = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Din> dins = new ArrayList<>();
    private static ArrayList<Deputy> deputies = new ArrayList<>();
    private static ArrayList<Lesson> lessons = new ArrayList<>();
    private static adminEDU adminEDU;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        updateUsers();

    }

    public void startServer() {

        try {
            // Listen for connections (clients to connect) on port 1234.
            while (!serverSocket.isClosed()) {
                // Will be closed in the Client Handler.
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                // The start method begins the execution of a thread.
                // When you call start() the run method is called.
                // The operating system schedules the threads.
                thread.start();
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    // Close the server socket gracefully.
    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Run the program.
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.startServer();
    }

    public void updateUsers() {
        File file = new File("D:/myedu3/src/Data/Students.txt");
        File file1 = new File("D:/myedu3/src/Data/Professors.txt");
        File file2 = new File("D:/myedu3/src/Data/Dins.txt");
        File file3 = new File("D:/myedu3/src/Data/Deputies.txt");
        File file4 = new File("D:/myedu3/src/Data/Lessons.txt");
        File file5 = new File("D:/myedu3/src/Data/AdminEDU.txt");
        try {
            Scanner scanner = new Scanner(file5);
            adminEDU = new adminEDU();
            if (scanner.hasNext()) {
                adminEDU.setUsername(scanner.next());
            }
            if (scanner.hasNext()) {
                adminEDU.setPassword(scanner.next());
            }
            while (scanner.hasNext()) {
                adminEDU.getMessages().add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner1 = new Scanner(file);
            while (scanner1.hasNextLine()) {
                Student s = new Student();
                s.setName(scanner1.next());
                s.setUsername(scanner1.next());
                s.setPassword(scanner1.next());
                s.setEmail(scanner1.next());
                s.setYearOfEntry(scanner1.nextInt());
                s.setCodeMeli(scanner1.next());
                s.setLastEntry(scanner1.next());
                s.setCollege(scanner1.next());
                s.setStudentType(studentType.valueOf(scanner1.next()));
                s.setStatus(studyStatus.valueOf(scanner1.next()));
                s.setGuidingP(scanner1.next());
                s.setSignupDate(scanner1.next());
                while (scanner1.hasNext()) {
                    String b = scanner1.next();
                    if (scanner1.hasNext()) {
                        String a = scanner1.next();
                        s.getMyLessons().put(b, a);
                    } else {
                        break;
                    }
                }
                if (scanner1.hasNextLine()) {
                    scanner1.nextLine();
                }
                students.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner2 = new Scanner(file1);
            while (scanner2.hasNextLine()) {
                Professor s = new Professor();
                s.setName(scanner2.next());
                s.setUsername(scanner2.next());
                s.setPassword(scanner2.next());
                s.setEmail(scanner2.next());
                s.setCodeMeli(scanner2.next());
                s.setLastEntry(scanner2.next());
                s.setCollege(scanner2.next());
                s.setTypeP(professorType.valueOf(scanner2.next()));
                while (scanner2.hasNext()) {
                    s.getMyLessons().add(scanner2.next());
                }
                if (scanner2.hasNextLine()) {
                    scanner2.nextLine();
                }
                if (s.getTypeP() == professorType.Normal) {
                    professors.add(s);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner3 = new Scanner(file2);
            while (scanner3.hasNextLine()) {
                Din s = new Din();

                s.setName(scanner3.next());
                s.setUsername(scanner3.next());
                s.setPassword(scanner3.next());
                s.setEmail(scanner3.next());
                s.setCodeMeli(scanner3.next());
                s.setLastEntry(scanner3.next());
                s.setCollege(scanner3.next());

                if (scanner3.hasNextLine()) {
                    scanner3.nextLine();
                }

                professors.add(s);
                dins.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner4 = new Scanner(file3);
            while (scanner4.hasNextLine()) {
                Deputy s = new Deputy();
                s.setName(scanner4.next());
                s.setUsername(scanner4.next());
                s.setPassword(scanner4.next());
                s.setEmail(scanner4.next());
                s.setCodeMeli(scanner4.next());
                s.setLastEntry(scanner4.next());
                s.setCollege(scanner4.next());
                while (scanner4.hasNext() && !scanner4.next().equals("Time")) {
                    s.getMyLessons().add(scanner4.next());
                }
                while (scanner4.hasNext()) {
                    s.getTimeToChoose().put(scanner4.nextInt(), scanner4.next());
                }

                if (scanner4.hasNextLine()) {
                    scanner4.nextLine();
                }
                professors.add(s);
                deputies.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner5 = new Scanner(file4);
            while (scanner5.hasNextLine()) {
                Lesson l = new Lesson();
                l.setName(scanner5.next());
                l.setCollege(scanner5.next());
                l.setExamDate(scanner5.next());
                l.setTimeClass(scanner5.next());
                l.setCapacity(scanner5.nextInt());
                l.setUnits(scanner5.nextInt());
                l.setCode(scanner5.nextInt());
                l.setType(studentType.valueOf(scanner5.next()));
                while (!scanner5.next().equals("requiredFor")) {
                    l.getPrerequisite().add(scanner5.next());
                }
                while (!scanner5.next().equals("professors")) {
                    l.getRequiredFor().add(scanner5.next());
                }
                while (!scanner5.next().equals("TAs")) {
                    l.getProfessors().add(scanner5.next());
                }
                while (scanner5.hasNext()) {
                    l.getTAs().add(scanner5.next());
                }
                lessons.add(l);
                if (scanner5.hasNextLine()) {
                    scanner5.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Din> getDins() {
        return dins;
    }

    public static void setDins(ArrayList<Din> dins) {
        Server.dins = dins;
    }

    public static Logic.adminEDU getAdminEDU() {
        return adminEDU;
    }

    public static void setAdminEDU(Logic.adminEDU adminEDU) {
        Server.adminEDU = adminEDU;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        Server.students = students;
    }

    public static ArrayList<Professor> getProfessors() {
        return professors;
    }

    public static void setProfessors(ArrayList<Professor> professors) {
        Server.professors = professors;
    }

    public static ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public static void setLessons(ArrayList<Lesson> lessons) {
        Server.lessons = lessons;
    }

    public static ArrayList<Deputy> getDeputies() {
        return deputies;
    }

    public static void setDeputies(ArrayList<Deputy> deputies) {
        Server.deputies = deputies;
    }
}


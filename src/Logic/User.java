package Logic;

import Server.ClientHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name;
    private String Username;
    private String password;
    private String email;
    private String codeMeli;
    private String lastEntry;
    private String college;
    private userType type;

    private boolean hasPic;
    private ImageIcon imageIcon;
    private ClientHandler clientHandler;
    private ArrayList<String> lessons = new ArrayList<>();
    //key is the name of the user message is from
    private HashMap<String,String> messages = new HashMap<>();

    public User(){

    }


    public HashMap<String, String> getMessages() {
        return messages;
    }

    public void setMessages(HashMap<String, String> messages) {
        this.messages = messages;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public userType getType() {
        return type;
    }

    public void setType(userType type) {
        this.type = type;
    }

    public ClientHandler getClientHandler() {
        return clientHandler;
    }

    public void setClientHandler(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    public String getLastEntry() {
        return lastEntry;
    }

    public void setLastEntry(String lastEntry) {
        this.lastEntry = lastEntry;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public boolean isHasPic() {
        return hasPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHasPic(boolean hasPic) {
        this.hasPic = hasPic;
    }

    public String getCodeMeli() {
        return codeMeli;
    }

    public void setCodeMeli(String codeMeli) {
        this.codeMeli = codeMeli;
    }

    public ArrayList<String> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<String> lessons) {
        this.lessons = lessons;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}

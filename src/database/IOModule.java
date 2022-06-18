package database;

import model.User;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class IOModule {

    /**
     * Launch the application.
     */
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {

    }

    /**
     * Create the frame.
     */
    public IOModule() {
    }

    public static Map<String, User> readUser() {
        Map<String, User> userMap = new HashMap<>();
        // read to the file
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/database/user.txt"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(","); // split it by ','
                String id = split[0]; // put each attribute into each variable
                String password = split[1];
                String name = split[2];
                String birth = split[3];
                User user = new User();
                user.setId(id); // and then set each value
                user.setPassword(password);
                user.setName(name);
                user.setBirth(birth);
                userMap.put(id, user);
            }
        } catch (Exception e) {
            return null;
        }
        return userMap;
    }

    // write to the file
    public static void writeUser(User user) { // since we split it by ',' put ',' when we write
        String line = user.getId() + "," + user.getPassword() + "," + user.getName() + "," + user.getBirth() + "\n";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/database/user.txt", true));
            writer.append(line);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

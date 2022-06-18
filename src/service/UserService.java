package service;

import database.DB;
import database.IOModule;
import database.Status;
import model.Adult;
import model.Teen;
import model.Movie;
import model.User;
import model.common.UserModule;
import util.DateUtil;

import java.util.Map;

public class UserService {
    public static void readUser() {
        Map<String, User> userMap = IOModule.readUser();
        DB.setUser(userMap);
    }

    public static String addUser(String id, User user) {
        // for checking parameter here before put data into DB;
        try {
            DB.putUser(id, user);
            IOModule.writeUser(user);
            return "success";
        } catch (Exception e) {
            return "DB error";
        }
    }

    // Settings for login method
    public static String login(String id, String password) {
        User user = DB.getUser(id);
        if (user == null) { // if user doesn't exist in DB
            return "Not Exist user"; 
        } else if (!password.equals(user.getPassword())) { // if password doesn't equal to password in DB
            return "Wrong Password";
        } else {
            Status.setLoginUser(id); // if we login in successfully
            return "success";
        }
    }

    public static void login(String id) {
        Status.setLoginUser(id);
    }

    public static User getUser(String id) {
        return DB.getUser(id);
    }

    // Settings for reserve method
    public static String reserve(Movie movie, int adult, int teen, int kid) {
        User user = getUser(Status.getLoginUser());
        if (user == null) { // if user doesn't exist in DB
            return "Not Exist user"; 
        }
        int age = DateUtil.getAge(user.getBirth()); 

        UserModule userModule;
        if (age < 20) { // if user age is under 20
            userModule = new Teen( // generate Teen object
                    user.getId(),
                    user.getPassword(),
                    user.getName(),
                    user.getBirth()
            );
        } else { // if user is over 20 
            userModule = new Adult( // generate Adult object
                    user.getId(),
                    user.getPassword(),
                    user.getName(),
                    user.getBirth()
            );
        }
        return userModule.reserve(movie, adult, teen, kid);
    }


}

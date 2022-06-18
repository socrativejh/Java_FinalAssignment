package database;

public class Status {
    private static String loginUser = null;

    public static String getLoginUser() {
        return loginUser;
    }

    public static void setLoginUser(String id) {
        loginUser = id;
    }

}

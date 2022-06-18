package model;

public class User {
    private String id;
    private String password;
    private String name;
    private String birth;
    
    // constructor for initializing 4 variables
    public User(String id,
                String password,
                String name,
                String birth) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }


    public User() {
    }


    @Override // for making values into one String
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}

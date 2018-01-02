package Model;


import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable{
    private String email;
    private String password;
    private String name;
    private static ArrayList<Course> course;

    public Admin(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;

    }

    public Admin(String email, String password, String name, ArrayList<Course> course) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.course = course;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean newCourse( String name, int id){
        Course courseToAdd = new Course(name,id);
        course.add(courseToAdd);
        return true;

    }

}
